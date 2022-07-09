package com.jinheung.project.domain.order.controller;

import com.jinheung.common.dto.product.ProductInfoDto;
import com.jinheung.project.clients.ShopStockClient;

import com.jinheung.project.domain.order.dto.CartRequest;
import com.jinheung.project.domain.order.dto.CartResponse;
import com.jinheung.project.domain.order.jpa.entity.CartHasProduct;
import com.jinheung.project.domain.order.jpa.service.CartService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.jinheung.common.consts.AuthHeaderNames.USER_ID;

@RequiredArgsConstructor
@RestController("/order/cart")
@RequestMapping
@Slf4j
public class CartController {
    private final ShopStockClient shopStockClient;
    private final CartService cartService;

    @GetMapping
    public ResponseEntity<CartResponse> getCartProduct(
        @RequestHeader(name = USER_ID) Long userId
    ) {

        List<CartHasProduct> cartHasProducts =
            cartService.findAllCartByHasProductByUserIdOrderByCreatedAt(userId);
        List<ProductInfoDto> productInfoDtoList;
        if(cartHasProducts.isEmpty()) {
            productInfoDtoList = new ArrayList<>();
        } else {
            productInfoDtoList = shopStockClient.getProductsByIds(
                cartHasProducts.stream().map(CartHasProduct::getProductId)
                    .collect(Collectors.toList())).getBody();
        }
        return ResponseEntity.ok(new CartResponse(productInfoDtoList));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCartProduct(
        @RequestHeader(name = USER_ID) Long userId,
        @PathVariable(name = "id") Long id
    ) {
        cartService.deleteByUserIdAndId(userId, id);
        return ResponseEntity.ok("ok");
    }

    @PostMapping
    public ResponseEntity<CartHasProduct> saveCart(
        @RequestHeader(name = USER_ID) Long userId,
        @RequestBody CartRequest cartRequest
    ) {
        return ResponseEntity.ok(cartService.saveCartService(
            cartRequest.getProductId(),
            cartRequest.getQuantity(),
            userId
        ));
    }
}
