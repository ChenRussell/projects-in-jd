package com.jd.cloud;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * created by chenrui18,2018/6/12 at 15:23
 */
public class AsyncTaskServiceTest {

    private ApplicationContext context;
//    @Before
//    public void prepare() {
//        // 相当于加载配置文件
//        context = new AnnotationConfigApplicationContext(TaskExecutorConfig.class);
//    }

    @Test
    public void run() {
        context = new AnnotationConfigApplicationContext(TaskExecutorConfig.class);
        AsyncTaskService bean = context.getBean(AsyncTaskService.class);
        for (int i = 0; i < 10; i++) {
            bean.executeAsyncTask(i);
            bean.executeAsyncTaskPlus(i+1);
        }
    }

    @Test
    public void run2() {
        context = new AnnotationConfigApplicationContext(TaskExecutorConfig2.class);
//        context = new AnnotationConfigApplicationContext("threadPoolTaskExecutor");
        AsyncTaskService bean = context.getBean(AsyncTaskService.class);
        bean.asyncMethodWithConfiguredExecutor();

        for (int i = 0; i < 10; i++) {
            bean.executeAsyncTask(i);
            bean.asyncMethodWithConfiguredExecutor();
        }
    }
}