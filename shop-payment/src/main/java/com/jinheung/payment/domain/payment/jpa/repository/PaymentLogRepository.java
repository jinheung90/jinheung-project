package com.jinheung.payment.domain.payment.jpa.repository;

//import com.jinheung.product.domain.product.jpa.entity.ProductStock;
import com.jinheung.payment.domain.payment.jpa.entity.PaymentLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentLogRepository extends JpaRepository<PaymentLog, Long> {

}
