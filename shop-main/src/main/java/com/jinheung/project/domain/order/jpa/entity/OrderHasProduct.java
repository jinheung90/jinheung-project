package com.jinheung.project.domain.order.jpa.entity;

import io.swagger.models.auth.In;
import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@Getter
@Table(name = "order_has_product")
@Entity
@Setter
public class OrderHasProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_has_product_id")
    private Long id = null;

    @Column(name = "product_id")
    private Long productId;

    @Column
    private Integer price;

    @Column
    private Integer quantity;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;
}
