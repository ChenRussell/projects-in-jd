package com.jd.cloud;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

/**
 * created by chenrui18,2018/6/12 at 20:41
 */

@Configuration
@EnableAsync
@ComponentScan("com.jd.cloud")
public class TaskExecutorConfig2 {

    @Bean(name = "threadPoolTaskExecutor")
    public Executor threadPoolTaskExecutor() {
        return new ThreadPoolTaskExecutor();
    }
}
