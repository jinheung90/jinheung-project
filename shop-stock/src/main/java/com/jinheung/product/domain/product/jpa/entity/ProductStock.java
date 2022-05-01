package com.jinheung.product.domain.product.jpa.entity;

import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@Getter
@Table(name = "product_stocks")
@Entity

public class ProductStock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_stocks")
    private Long id = null;

    @Column(name = "product_id")
    private String productId;

    @Column(name = "stock_count")
    private Integer stockCount;

    @Column(name = "order_id")
    private String orderId;

    @Column
    private Integer price;


    public boolean reduceStock(int count) {
        stockCount -= count;
        if(stockCount < 0) {
            stockCount += count;
            return false;
        } else return true;
    }


}
