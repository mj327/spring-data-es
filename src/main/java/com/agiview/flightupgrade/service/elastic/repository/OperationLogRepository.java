package com.agiview.flightupgrade.service.elastic.repository;

import com.agiview.flightupgrade.service.elastic.model.OperationLog;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface OperationLogRepository extends ElasticsearchRepository<OperationLog, String> {
}
