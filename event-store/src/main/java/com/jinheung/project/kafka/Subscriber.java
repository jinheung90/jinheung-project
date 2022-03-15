package com.jinheung.project.kafka;



import org.springframework.context.annotation.Bean;
import org.springframework.kafka.annotation.KafkaListener;

import java.util.function.Consumer;


public class Subscriber {

    @Bean
    Consumer<String> input() {
        
    }
}
