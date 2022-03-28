package com.jinheung.project.config;

import com.jinheung.project.auth.redis.entity.RefreshTokenData;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
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

    public static final String REDIS_TIME_FORMAT = "yyyyMMddHHmmss";

    // 기본서버
    @Bean
    public LettuceConnectionFactory lettuceConnectionFactory() {
        return new LettuceConnectionFactory(host, port);
    }

    @Bean
    public ReactiveRedisTemplate<String, Object> redisTemplateForObject() {
        StringRedisSerializer keySerializer = new StringRedisSerializer();
        Jackson2JsonRedisSerializer<Object> valueSerializer =
            new Jackson2JsonRedisSerializer<>(Object.class);
        RedisSerializationContext.RedisSerializationContextBuilder<String, Object> builder =
            RedisSerializationContext.newSerializationContext(keySerializer);
        RedisSerializationContext<String, Object> context =
            builder.value(valueSerializer).build();
        return new ReactiveRedisTemplate<>(lettuceConnectionFactory(), context);
    }

    @Bean
    public ReactiveRedisTemplate<String, RefreshTokenData> redisTemplateForRefreshTokenData() {
        StringRedisSerializer keySerializer = new StringRedisSerializer();
        Jackson2JsonRedisSerializer<RefreshTokenData> valueSerializer =
            new Jackson2JsonRedisSerializer<>(RefreshTokenData.class);
        RedisSerializationContext.RedisSerializationContextBuilder<String, RefreshTokenData> builder =
            RedisSerializationContext.newSerializationContext(keySerializer);
        RedisSerializationContext<String, RefreshTokenData> context =
            builder.value(valueSerializer).build();
        return new ReactiveRedisTemplate<>(lettuceConnectionFactory(), context);
    }
}
