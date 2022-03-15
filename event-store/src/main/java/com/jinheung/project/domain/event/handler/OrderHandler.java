package com.jinheung.project.domain.event.handler;


import com.jinheung.project.clients.PaymentService;
import com.jinheung.project.clients.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderHandler {
    private final PaymentService paymentService;
    private final ProductService productService;
    private static final String PRODUCT_ID_HEADER_NAME = "id";
//    public Mono<OrderResponse> order(ServerRequest request) {
//
//        String productId = request.pathVariable(PRODUCT_ID_HEADER_NAME);
//        Long userId = Long.valueOf(Objects.requireNonNull(request.headers().firstHeader(USER_ID)));
//
//        Mono<PaymentResponse> paymentResponseMono =
//            paymentService.payProduct(Mono.just(new PaymentRequest(productId, userId)));
//
//        Mono<StockReductionResponse> productResponse =
//            productService.stockDeduction(Mono.just(new ProductRequest(productId, userId)));
//        return Mono.create(() -> {
//
//        })
//    }
}
