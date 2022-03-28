package com.jinheung.product.domain.product.jpa.repository;

//import com.jinheung.product.domain.product.jpa.entity.ProductStock;
import com.jinheung.product.domain.product.jpa.entity.PaymentLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentLogRepository extends JpaRepository<PaymentLog, Long> {

}
