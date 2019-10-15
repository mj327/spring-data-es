package com.agiview.flightupgrade.service.elastic.test;

import com.agiview.flightupgrade.service.elastic.ElasticSearchApplication;
import com.agiview.flightupgrade.service.elastic.model.OperationLog;
import com.agiview.flightupgrade.service.elastic.repository.OperationLogRepository;
import com.agiview.flightupgrade.service.elastic.service.OperationLogService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = ElasticSearchApplication.class)
public class OperationLogTest {

    @Autowired
    ElasticsearchTemplate elasticsearchTemplate;

    @Autowired
    OperationLogService operationLogService;

    @Autowired
    OperationLogRepository operationLogRepository;

    @Test
    public void testCreateIndex() {
        elasticsearchTemplate.createIndex(OperationLog.class);
    }

    @Test
    public void testInsertDocument() {


        OperationLog operationLog = new OperationLog();
        operationLog.setOperatorName("蒋老师");
        operationLog.setOperationDesc("修改活动");
        operationLog.setOperatingObjectId(112233);
        operationLog.setCreateTime(new Date());


        List<OperationLog> operationLogList = new ArrayList<>();
        operationLogList.add(operationLog);
        operationLogService.insert(operationLogList);
    }

    @Test
    public void testFindById() {
        Optional<OperationLog> optional = operationLogRepository.findById("Vz0oR20BOVeFQyVox_hq");
        System.out.println(optional.orElse(null));
    }

    @Test
    public void testDeleteById() {
        operationLogRepository.deleteById("RNkoRG0BUf7WBeTqpRrI");
    }

}
