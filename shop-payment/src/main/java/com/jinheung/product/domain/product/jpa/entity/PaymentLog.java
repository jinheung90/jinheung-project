package com.jinheung.product.domain.product.jpa.entity;

import io.swagger.models.auth.In;
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
    private Integer quantity;

    @Column
    private Integer price;
}
