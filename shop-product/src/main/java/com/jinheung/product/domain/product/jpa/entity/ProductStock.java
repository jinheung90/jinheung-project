package com.jinheung.product.domain.product.jpa.entity;

import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@Getter
@Table(name = "product_stocks")
@Entity
@Setter
public class ProductStock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_stocks")
    private Long id = null;

    @Column
    private String productId;

    @Column
    private Integer StockCount;

}
