package com.jinheung.project.config;
import com.jinheung.project.domain.signal.handler.CustomChannelInterceptor;


import com.jinheung.project.domain.signal.handler.CustomHandshakeHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.ChannelRegistration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.*;

@Configuration
@EnableWebSocket
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    @Value("${spring.rabbitmq.username}")
    private String userName;
    @Value("${spring.rabbitmq.password}")
    private String password;
    @Value("${spring.rabbitmq.host}")
    private String host;
    @Value("${spring.rabbitmq.port}")
    private int port;
    @Value("${endpoint}")
    private String endpoint;

    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/signal").setAllowedOrigins("http://localhost:3000")
            .setHandshakeHandler(new CustomHandshakeHandler())
            .withSockJS();
        registry.addEndpoint("/signal").setAllowedOrigins("http://localhost:3000");
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
//        registry.enableSimpleBroker("/sub");
        registry.enableStompBrokerRelay("/sub").setRelayHost(host)
            .setRelayPort(port).setSystemLogin(userName).setSystemPasscode(password);
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
