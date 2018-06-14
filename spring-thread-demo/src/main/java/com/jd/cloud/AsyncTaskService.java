package com.jd.cloud;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * created by chenrui18,2018/6/12 at 15:19
 *
 * 任务执行类
 *
 * @Async
 * 这个注解用于标注某个方法或某个类里面的所有方法都是需要异步处理的。
 * 被注解的方法被调用的时候，会在新线程中执行，而调用它的方法会在原来的线程中执行。
 * 这样可以避免阻塞、以及保证任务的实时性。适用于处理log、发送邮件、短信……等。
 */
@Service
public class AsyncTaskService {

    @Async
    public void executeAsyncTask(Integer i) {
        System.out.println("executeAsyncTask:"+i + ", "+ Thread.currentThread().getName());
    }

    @Async
    public void executeAsyncTaskPlus(Integer i) {
        System.out.println("executeAsyncTaskPlus:"+i + ", "+ Thread.currentThread().getName());
    }

    @Async("threadPoolTaskExecutor")
    public void asyncMethodWithConfiguredExecutor() {
        System.out.println("Execute method with configured executor - "
        +Thread.currentThread().getName());
    }
}
