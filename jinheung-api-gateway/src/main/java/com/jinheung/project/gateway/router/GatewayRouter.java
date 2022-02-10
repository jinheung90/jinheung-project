package com.jinheung.project.gateway.router;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.filter.factory.TokenRelayGatewayFilterFactory;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class GatewayRouter {

//    @Autowired
//    private TokenRelayGatewayFilterFactory tokenRelayGatewayFilterFactory;
////    cloud:
////    gateway:
////    routes:
////        - id: user_profile
////    uri: http://localhost:8082
////    predicates:
////        - Path=/user
////    default-filters:
//
////    @Bean
////    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
////        return builder.routes()
////            .route("user_profile", r -> r.path("/user")
////                .filters(
////                    f -> {
////                        f.filter(tokenRelayGatewayFilterFactory.apply());
////                        return f;
////                    })
////                .uri("http://local")
////            ).build();
//    }
}
