package com.jd.cloud.test;

import com.jd.cloud.dao.PersonDao;
import com.jd.cloud.entity.Person;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.SQLException;

public class TestQuickStart {

    private static ApplicationContext context;

    @Before
    public void prepare() {
            context = new ClassPathXmlApplicationContext("classpath:applicationContext-Service.xml");
    }


    @Test
    public void testGetById() throws SQLException {
        PersonDao personDao = context.getBean(PersonDao.class);
        Person person = personDao.getById(1);
        System.out.println("查询结果：name="+person.getName()+",id="+person.getId());

    }

    @Test
    public void testSave() throws InterruptedException {
        PersonDao bean = context.getBean(PersonDao.class);
        Person person = new Person();
        for (int i = 0; i < 50; i++) {

            Thread.sleep(200);
            person.setName("chenrui"+i);
            person.setEmail("chnerui"+i+"@qq.com");
            person.setBirth("2018.2.1"+i);
            bean.save(person);
//            bean.
        }
    }
}
