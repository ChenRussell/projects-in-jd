package com.jd.cloud.test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.SQLException;

public class TestConfig {

    private static ApplicationContext context;

//        static {
//        context = new ClassPathXmlApplicationContext("classpath:applicationContext-service.xml");
////        ((ClassPathXmlApplicationContext) context).start();
////        context.start();
//    }

    @Before
    public void prepare() {
            context = new ClassPathXmlApplicationContext("classpath:applicationContext-Service.xml");
    }


    @Test
    public void testDataSource() throws SQLException {
        DataSource dataSource = (DataSource) context.getBean("dataSource");
        System.out.println("数据源："+dataSource);
        System.out.println("连接："+dataSource.getConnection());
    }
}
