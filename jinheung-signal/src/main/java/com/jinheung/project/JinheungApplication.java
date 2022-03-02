package com.jinheung.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableScheduling;


@SpringBootApplication
@EnableFeignClients
//@EnableZuulProxy
@EnableScheduling
public class JinheungApplication {
	public static void main(String[] args) {
		SpringApplication.run(JinheungApplication.class, args);
	}
}
