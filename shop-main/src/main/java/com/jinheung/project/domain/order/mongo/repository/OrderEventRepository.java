package com.jinheung.project.domain.order.mongo.repository;


import com.jinheung.project.domain.order.mongo.doc.OrderEvent;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrderEventRepository extends MongoRepository<OrderEvent, String> {

}
