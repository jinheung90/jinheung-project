package com.jinheung.project.config;

import com.jinheung.project.webscoket.message.CustomChannelInterceptor;
import com.jinheung.project.webscoket.message.CustomHandshakeHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.ChannelRegistration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;


@Configuration
@EnableWebSocket
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/client")
            .setAllowedOrigins("http://localhost:8081","http://127.0.0.1:8081")
//            .setAllowedOriginPatterns("https://*.audivice.com")
            .setHandshakeHandler(new CustomHandshakeHandler())
            .withSockJS();
        registry.addEndpoint("/client")
            .setAllowedOrigins( "http://localhost:8081","http://127.0.0.1:8081");
//            .setAllowedOrigins( "https://*.audivice.com");
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        registry.enableSimpleBroker("/sub");
        registry.setApplicationDestinationPrefixes("/pub");
        registry.setUserDestinationPrefix("/user");
    }
    @Override
    public void configureClientInboundChannel(ChannelRegistration registration) {
        registration.interceptors(new CustomChannelInterceptor(applicationEventPublisher));
    }

}
//@Configuration
//@EnableWebSocket
////@EnableWebSocketMessageBroker
//public class WebSocketConfig implements WebSocketConfigurer {
//
////    @Override
////    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
////        registry.addHandler("/signal");
////    }
//
////    @Bean
////    public WebSocketHandler myHandler() {
////        return new CustomWebsocketHandler();
////    }
//}
