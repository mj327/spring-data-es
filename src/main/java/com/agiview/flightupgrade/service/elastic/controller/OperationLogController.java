package com.agiview.flightupgrade.service.elastic.controller;

import com.agiview.flightupgrade.service.elastic.model.OperationLog;
import com.agiview.flightupgrade.service.elastic.service.OperationLogService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author MaJun
 * Created at 5:00 PM, 2019-09-18
 * 操作日志索引Controller
 */
@RestController
@RequestMapping("/operationLog")
public class OperationLogController {

    @Autowired
    private OperationLogService operationLogService;

    @PostMapping("/insert")
    public void insert(@RequestBody @Validated List<OperationLog> operationLogList) {
        operationLogService.insert(operationLogList);
    }
}
