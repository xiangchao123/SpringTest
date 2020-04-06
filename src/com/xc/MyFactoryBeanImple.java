package com.xc;

import org.springframework.beans.factory.FactoryBean;

import java.util.UUID;

/**
 * Created by xiangchao on 2020/4/6.
 * 实现了FactoryBean接口的类是Spring可以认识的工厂类；
 * Spring会自动的调用工厂方法创建实例
 *
 * 1.编写一个FactoryBean的实现类
 * 2.在Spring配置文件中进行注册
 */
public class MyFactoryBeanImple implements FactoryBean<Book> {

    /**
     * @author chosen1
     * getObject:工厂方法，返回创建对象
    */
    @Override
    public Book getObject() throws Exception {
        System.out.println("MyFactoryBeanImple。。。帮你创建对象。。");
        Book book = new Book();
        book.setBookName(UUID.randomUUID().toString());
        return book;
    }
    /**
     * @author chosen1
     * 返回创建的对象的类型；
     * Spring会自动调用这个方法来确认创建的对象是什么类型
    */
    @Override
    public Class<?> getObjectType() {
        return Book.class;
    }
    /**
     * @author chosen1
     * isSingleton:是单例？
     * false:不是单例
     * true:是单例
    */
    @Override
    public boolean isSingleton() {
        return false;
    }
}
