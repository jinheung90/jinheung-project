package com.jinheung.project.errorHandling;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.web.ResourceProperties;
import org.springframework.boot.autoconfigure.web.reactive.error.AbstractErrorWebExceptionHandler;
import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.reactive.error.ErrorAttributes;
import org.springframework.context.ApplicationContext;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.codec.ServerCodecConfigurer;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.*;
import reactor.core.publisher.Mono;

import java.util.Map;

// is deprecated
//@Component
//@Order(-2)
//public class GlobalErrorExceptionHandler extends AbstractErrorWebExceptionHandler {
//
//    private Logger logger = LoggerFactory.getLogger(this.getClass());
//
//    public GlobalErrorExceptionHandler(ErrorAttributes errorAttributes, ResourceProperties resourceProperties, ApplicationContext applicationContext,
//                                       ServerCodecConfigurer serverCodecConfigurer) {
//        super(errorAttributes, resourceProperties, applicationContext);
//        super.setMessageWriters(serverCodecConfigurer.getWriters());
//        super.setMessageReaders(serverCodecConfigurer.getReaders());
//    }
//
//    @Override
//    protected RouterFunction<ServerResponse> getRoutingFunction(final ErrorAttributes errorAttributes) { // 마지막으로 거쳐서 온 에러들
//
//        GlobalErrorAttributes attributes = null;
//
//        if(errorAttributes instanceof GlobalErrorAttributes) {
//            attributes = (GlobalErrorAttributes)errorAttributes;
//        }
//
//        return RouterFunctions.route(RequestPredicates.all(), this::renderErrorResponse);
//    }
//
//    private Mono<ServerResponse> renderErrorResponse(final ServerRequest request) {
//        final Map<String, Object> errorPropertiesMap = getErrorAttributes(request, ErrorAttributeOptions.defaults()); // attribute에서 가져온것
//        if(errorPropertiesMap.get("status") instanceof Integer) {
//            return ServerResponse.status((Integer) errorPropertiesMap.get("status")) // 여기에는 에러페이지 까지 작성할 수 있으나 그럴 필요가 없다
//                    .contentType(MediaType.APPLICATION_JSON)
//                    .body(BodyInserters.fromValue(errorPropertiesMap));
//        } else if(errorPropertiesMap.get("status") instanceof HttpStatus) {
//            return ServerResponse.status((HttpStatus) errorPropertiesMap.get("status")) // 여기에는 에러페이지 까지 작성할 수 있으나 그럴 필요가 없다
//                    .contentType(MediaType.APPLICATION_JSON)
//                    .body(BodyInserters.fromValue(errorPropertiesMap));
//        }
//        return ServerResponse.status(500) // 여기에는 에러페이지 까지 작성할 수 있으나 그럴 필요가 없다
//                .contentType(MediaType.APPLICATION_JSON)
//                .body(BodyInserters.fromValue(errorPropertiesMap));
//    }
//}
