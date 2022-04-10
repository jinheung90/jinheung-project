package com.jinheung.payment.domain.payment.jpa.entity;

import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@Getter
@Table(name = "payments_retries")
@Entity
@Setter
public class PaymentRetry {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "payment_log_id")
    private Long id = null;

    @Column
    private Long userId;

    @Column
    private String productId;

    @Column
    private String orderId;

    @Column
    private Integer retryCount;

    @Column
    private Integer quantity;

    @Column
    private Integer price;
}
