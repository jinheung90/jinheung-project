package com.jinheung.project.config;

import com.jinheung.project.domain.signaling.redis.entity.RoomInfo;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.ReactiveRedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.ReactiveRedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
public class RedisConfig {

    @Value("${spring.redis.host}")
    private String host;

    @Value("${spring.redis.port}")
    private int port;

    @Bean
    public LettuceConnectionFactory lettuceConnectionFactory() {
        return new LettuceConnectionFactory(host, port);
    }

//    @Bean
//    public ReactiveRedisTemplate<String, RoomInfo> roomInfoReactiveRedisTemplate(
//        LettuceConnectionFactory factory) {
//        StringRedisSerializer keySerializer = new StringRedisSerializer();
//        Jackson2JsonRedisSerializer<RoomInfo> valueSerializer =
//            new Jackson2JsonRedisSerializer<>(RoomInfo.class);
//        RedisSerializationContext.RedisSerializationContextBuilder<String, RoomInfo> builder =
//            RedisSerializationContext.newSerializationContext(keySerializer);
//        RedisSerializationContext<String, RoomInfo> context =
//            builder.value(valueSerializer).build();
//        return new ReactiveRedisTemplate<>(factory, context);
//    }


}
