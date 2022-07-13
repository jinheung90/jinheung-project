package com.jinheung.product.domain.product.jpa.entity;

import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@Getter
@Table(name = "user_Has_product_likes", uniqueConstraints = {
    @UniqueConstraint(name = "UniqueUserIdAndProductId", columnNames = {"userId", "productId"})})
@Entity
@Setter
public class UserHasProductLike {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_Has_product_like_id")
    private Long id = null;
    @Column(name = "user_id")
    private Long userId;
    @Column(name = "product_id")
    private Long productId;

}
