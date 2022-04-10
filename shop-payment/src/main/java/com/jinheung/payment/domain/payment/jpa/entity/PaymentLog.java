package com.jinheung.payment.domain.payment.jpa.entity;

import com.jinheung.payment.domain.payment.enums.PayFailType;
import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@Getter
@Table(name = "payments_logs")
@Entity
@Setter
public class PaymentLog {

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
    private Integer quantity;

    @Enumerated(EnumType.STRING)
    private PayFailType payFailType;
    @Column
    private Integer price;
}
