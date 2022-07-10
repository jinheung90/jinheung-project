package com.jinheung.project.config;



import feign.codec.StringDecoder;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.listener.DefaultErrorHandler;
import org.springframework.kafka.listener.ErrorHandler;
import org.springframework.retry.backoff.FixedBackOffPolicy;
import org.springframework.retry.policy.SimpleRetryPolicy;
import org.springframework.retry.support.RetryTemplate;
import org.springframework.util.backoff.FixedBackOff;

import java.util.HashMap;
import java.util.Map;

@EnableKafka
@Configuration
@Slf4j
public class kafkaConfig {
    @Value("${spring.kafka.bootstrap-servers}")
    private String server;
    @Value("${spring.kafka.consumer.group-id}")
    private String groupId;
    private static final String DEFAULT_ERROR_FORM = "topic : %s \n cause : %s \n message key : %s \n message value : %s\n";
    private static final int MAX_ATTEMPT = 2;
    private static final Long DELAY = 1000L;
//    2.8.4부터 deprecated
//    @Bean
//    public RetryTemplate retryTemplate() {
//        RetryTemplate retryTemplate = new RetryTemplate();
//        FixedBackOffPolicy fixedBackOffPolicy = new FixedBackOffPolicy();
//        fixedBackOffPolicy.setBackOffPeriod(DELAY);
//        retryTemplate.setBackOffPolicy(fixedBackOffPolicy);
//        SimpleRetryPolicy retryPolicy = new SimpleRetryPolicy();
//        retryPolicy.setMaxAttempts(MAX_ATTEMPT);
//        retryTemplate.setRetryPolicy(retryPolicy);
//        return retryTemplate;
//    }

    @Bean
    public ConsumerFactory<String, String> consumerFactory() {
        Map<String, Object> properties = new HashMap<>();
        properties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, server);
        properties.put(ConsumerConfig.GROUP_ID_CONFIG, groupId);
        properties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        properties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        return new DefaultKafkaConsumerFactory<>(properties);
    }

    @Bean
    ConcurrentKafkaListenerContainerFactory<String, String> kafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String,String> factory =
            new ConcurrentKafkaListenerContainerFactory<>();
        factory.setCommonErrorHandler(customDefaultErrorHandler());
        factory.setConsumerFactory(this.consumerFactory());
        return factory;
    }

    private DefaultErrorHandler customDefaultErrorHandler() {
        DefaultErrorHandler errorHandler = new DefaultErrorHandler();
        errorHandler.setBackOffFunction(
            (c, e) -> {
                log.error(
                    String.format(DEFAULT_ERROR_FORM,
                        c.topic(), e.getMessage(),
                        c.key(), c.value()));
                return new FixedBackOff(DELAY, MAX_ATTEMPT);
            }
        );
        return errorHandler;
    }

}
