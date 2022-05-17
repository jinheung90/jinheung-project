package com.jinheung.product.domain.product.controller;

import com.google.gson.Gson;
import com.jinheung.common.consts.AuthHeaderNames;
import com.jinheung.common.dto.auth.UserRole;
import com.jinheung.common.dto.product.AsyncProductInfoPayload;
import com.jinheung.common.dto.product.ProductInfoDto;
import com.jinheung.common.event.MsaEvents;
import com.jinheung.product.domain.product.dto.ProductInsertRequest;
import com.jinheung.product.domain.product.jpa.entity.ProductInfo;
import com.jinheung.product.domain.product.jpa.service.ProductInfoService;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping
public class ProductController {

    private final ProductInfoService productInfoService;
    private final KafkaTemplate<String, String> payloadKafkaTemplate;

    @PostMapping("/product")
    public ResponseEntity<Boolean> saveAndUpdateProduct(
//        @RequestHeader(name = AuthHeaderNames.USER_ID, required = false) Long userId,
//        @RequestHeader(name = AuthHeaderNames.USER_AUTHORITIES, required = false) List<String> authorities,
        @RequestBody ProductInsertRequest request) {

//        if(!UserRole.hasRole(authorities, UserRole.ROLE_ADMIN)) {
//            return ResponseEntity.ok(false);
//        }

        productInfoService.saveProductInfo(
            request.getProductId(),
            request.getName(),
            request.getDetail(),
            request.getPrice(),
            request.getStock(),
            request.getActivity()
        );
        payloadKafkaTemplate.send(MsaEvents.KAFKA_TOPIC_SEARCH_ASYNC_PRODUCT_INFO,
            new Gson().toJson( new AsyncProductInfoPayload(
                request.getProductId(),
                request.getPrice(),
                request.getStock(),
                request.getName(),
                request.getDetail(),
                request.getActivity()
            ), AsyncProductInfoPayload.class));
        return ResponseEntity.ok(true);
    }
    @GetMapping
    public ResponseEntity<List<ProductInfoDto>> findAllByIds(
        @RequestParam(name = "ids") List<Long> ids
    ) {
        return ResponseEntity.ok(productInfoService.findByIds(ids).stream()
            .map(p -> ProductInfoDto.fromEntityValues(
                p.getId(),
                p.getStockCount(),
                p.getName(),
                p.getDetail(),
                p.getPrice(),
                p.getCreatedAt(),
                p.getUpdatedAt()
            )).collect(Collectors.toList())
        );
    }
}
