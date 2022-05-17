package com.jinheung.project.domain.order.jpa.service;

import com.jinheung.common.dto.product.ProductInfoDto;
import com.jinheung.project.domain.order.jpa.entity.CartHasProduct;
import com.jinheung.project.domain.order.jpa.repository.CartHasProductRepository;
import com.jinheung.project.errorHandling.customRuntimeException.RuntimeExceptionWithCode;
import com.jinheung.project.errorHandling.errorEnums.GlobalErrorCode;
import io.swagger.models.auth.In;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.common.quota.ClientQuotaAlteration;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CartService {
    private final CartHasProductRepository cartHasProductRepository;

    public List<CartHasProduct> findALlByCartHasProductByUserIdOrderByCreatedAt(Long userId) {
        return cartHasProductRepository.findAllByUserIdOrderByCreatedAt(userId);
    }

    @Transactional
    public void deleteByUserIdAndId(Long userId, Long productId) {
        boolean result = cartHasProductRepository.existsByUserIdAndId(userId, productId);
        if(result) {
            cartHasProductRepository.deleteById(productId);
        } else {
            throw new RuntimeExceptionWithCode(GlobalErrorCode.BAD_REQUEST);
        }
    }

    @Transactional
    public CartHasProduct saveCartService(Long productId, Integer quantity, Long userId) {
        Optional<CartHasProduct> optionalCartHasProduct = cartHasProductRepository.findFirstByUserIdAndId(userId, productId);
        if(optionalCartHasProduct.isPresent()) {
            CartHasProduct cartHasProduct = optionalCartHasProduct.get();
            cartHasProduct.addQuantity(quantity);
            return cartHasProductRepository.save(cartHasProduct);
        } else {
            return cartHasProductRepository.save(
                CartHasProduct.builder().productId(productId)
                    .userId(userId)
                    .quantity(quantity)
                    .build()
            );
        }
    }
}
