package com.jinheung.project.domain.product.controller;

import com.jinheung.project.domain.product.es.entity.ProductInfo;
import com.jinheung.project.domain.product.es.service.ProductInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.elasticsearch.core.SearchPage;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping
public class ProductController {

    private final ProductInfoService productInfoService;

    @GetMapping("/search/product")
    public ResponseEntity<SearchPage<ProductInfo>> searchProduct(
        @RequestParam(name = "query") String query,
        @RequestParam(name = "page", defaultValue = "0") Integer page,
        @RequestParam(name = "size", defaultValue = "10") Integer size
    ) {
        return ResponseEntity.ok(productInfoService.searchProduct(query, page, size));
    }
}
