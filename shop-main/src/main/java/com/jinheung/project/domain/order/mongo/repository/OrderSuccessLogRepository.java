package com.jinheung.project.domain.order.mongo.repository;


import com.jinheung.project.domain.order.mongo.doc.OrderSuccessLog;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrderSuccessLogRepository extends MongoRepository<OrderSuccessLog, String> {

}
