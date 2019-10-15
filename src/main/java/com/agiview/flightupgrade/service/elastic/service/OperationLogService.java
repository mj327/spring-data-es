package com.agiview.flightupgrade.service.elastic.service;

import com.agiview.flightupgrade.service.elastic.model.OperationLog;
import com.agiview.flightupgrade.service.elastic.repository.OperationLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class OperationLogService {

    @Autowired
    OperationLogRepository operationLogRepository;

    public void insert(List<OperationLog> operationLogList) {
        if (operationLogList == null || operationLogList.size() == 0) {
            System.out.println("invalid params");
        }
        operationLogRepository.saveAll(operationLogList);
    }
}
