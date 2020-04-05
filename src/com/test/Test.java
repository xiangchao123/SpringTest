package com.test;

import com.xc.Person;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by xiangchao on 2020/4/5.
 */
public class Test {
    @org.junit.Test
    public void test(){
        // ApplicationContext:代表IOC容器
        ApplicationContext ioc = new ClassPathXmlApplicationContext("ioc.xml");
        Person bean = (Person) ioc.getBean("person01");
        System.out.println(bean);
    }

}
