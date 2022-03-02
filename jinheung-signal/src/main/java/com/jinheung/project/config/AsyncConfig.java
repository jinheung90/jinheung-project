package com.jinheung.project.config;

import org.springframework.scheduling.annotation.AsyncConfigurerSupport;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

public class AsyncConfig extends AsyncConfigurerSupport {

    public Executor getAsyncExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(2);// 기본적으로 대기하는 스레드 풀의 개수
        executor.setMaxPoolSize(20); // 동시 동작하는 스레드의 개수
        executor.setQueueCapacity(1000); // 큐잉의 맥스 개수 이게 넘치면 스로우를 던진다
        executor.setThreadNamePrefix("audivice-async");
        executor.initialize();
        return executor;
    }
}
