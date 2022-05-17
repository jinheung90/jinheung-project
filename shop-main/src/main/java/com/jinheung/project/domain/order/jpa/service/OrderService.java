package com.jinheung.project.domain.order.jpa.service;

import com.jinheung.common.dto.product.OrderHasProductDto;
import com.jinheung.project.domain.order.dto.OrderRequest;
import com.jinheung.project.domain.order.jpa.entity.Order;
import com.jinheung.project.domain.order.jpa.entity.OrderHasProduct;
import com.jinheung.project.domain.order.jpa.repository.OrderHasProductRepository;
import com.jinheung.project.domain.order.jpa.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderHasProductRepository orderHasProductRepository;
    private final OrderRepository orderRepository;

    @Transactional
    public Order saveOrder(String impUid, Set<OrderHasProductDto> orderHasProducts) {
        Order order = orderRepository.save(Order.builder().impUid(impUid).build());
        List<OrderHasProduct> orderHasProductList = saveOrderHasProduct(order, orderHasProducts);
        order.setProducts(orderHasProductList);
        return order;
    }

    @Transactional
    public List<OrderHasProduct> saveOrderHasProduct(Order order, Set<OrderHasProductDto> orderHasProducts) {
        return orderHasProductRepository.saveAll(
            orderHasProducts.stream().map(
                dto -> OrderHasProduct.builder()
                .order(order)
                .productId(dto.getProductId())
                .quantity(dto.getQuantity())
                .price(dto.getPrice()).build()
        ).collect(Collectors.toList()));
    }
}
