package com.jinheung.payment.domain.payment.jpa.repository;

//import com.jinheung.product.domain.product.jpa.entity.ProductStock;
import com.jinheung.payment.domain.payment.jpa.entity.PaymentLog;
import com.jinheung.payment.domain.payment.jpa.entity.PaymentRetry;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRetryRepository extends JpaRepository<PaymentRetry, Long> {

}
