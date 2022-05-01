package com.jinheung.project.domain.order.mongo.repository;


import com.jinheung.project.domain.order.mongo.doc.OrderEvent;
import com.jinheung.project.domain.order.mongo.doc.PaymentLog;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PaymentLogRepository extends MongoRepository<PaymentLog, String> {

}
