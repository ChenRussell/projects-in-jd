package com.jd.cloud;

import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

// 使用Java配置，而不是xml，相当于是一个配置文件
@Configuration
@ComponentScan("com.jd.cloud")  // 组件扫描
@EnableAsync    // 开启异步任务支持
public class TaskExecutorConfig implements AsyncConfigurer {
    //配置类实现AsyncConfigurer接口并重写getAsyncExecutor方法，并返回一个ThreadPoolTaskExecutor
    //这样我们就获取一个基于线程池的TaskExecutor
    public Executor getAsyncExecutor() {

        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(10);   // 线程池维护线程的基本数量
        executor.setMaxPoolSize(20);    // 线程池维护线程的最大数量
        executor.setQueueCapacity(25);  // 线程池所使用的缓冲队列大小
        executor.initialize();
        return executor;
    }

    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {

        return null;
    }
}
