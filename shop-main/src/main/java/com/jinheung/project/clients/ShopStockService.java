package com.jinheung.project.clients;

import com.jinheung.common.dto.product.ProductInfoDto;
import feign.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "shop-stock", url = "http://localhost:8085")
public interface ShopStockService {

    @GetMapping(
        value = "/product/ids",
        produces = "application/json")
    ResponseEntity<List<ProductInfoDto>> getProductsByIds(
        @RequestParam(name = "ids") List<Long> ids
    );

}
