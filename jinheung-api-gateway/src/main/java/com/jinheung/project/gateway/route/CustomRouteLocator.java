package com.jinheung.project.gateway.route;


import com.jinheung.project.auth.TokenProvider;

import lombok.RequiredArgsConstructor;
import org.springframework.cloud.gateway.filter.factory.AbstractNameValueGatewayFilterFactory;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class CustomRouteLocator {

    private final TokenProvider tokenProvider;

    private static String USER_ID_HEADER = "userId";
//
//    @Bean
//    public RouteLocator mainRouting(RouteLocatorBuilder builder) {
//        return builder.routes()
//                .route(r -> r.path("/login/**").and().method("POST", "GET", "DELETE", "PUT")
//                        .uri("http://localhost:8081"))
//                .route(r -> r.path("/signup/**").and().not().method("POST", "GET", "DELETE", "PUT")
//                        .uri("http://localhost:8081"))
//                .route(r -> r.path("/search/**").and().method("POST", "GET", "DELETE", "PUT")
//                        .uri("http://localhost:8081").filter(new AuthFilter(tokenProvider).apply(this.userIdHeaderConfig(UserRole.ROLE_USER.getValue()))))
//                .route(r -> r.path("/users/**").and().method("POST", "GET", "DELETE", "PUT").uri("http://localhost:8081")
//                        .filter(new AuthFilter(tokenProvider).apply(this.userIdHeaderConfig(UserRole.ROLE_USER.getValue()))))
//                .build();
//    }
}

