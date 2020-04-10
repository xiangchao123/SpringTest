package com.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * Created by xiangchao on 2020/4/8.
 */
public class applicationtest {
//    private ConfigurableApplicationContext ioc = new FileSystemXmlApplicationContext("F:\\springlearn\\src\\com\\conf\\applicationContext15.xml");
    private ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
    /**
     * @author chosen1
     * 单例 Bean的生命周期
     *      (容器启动)构造器---->初始化方法---->(容器关闭)销毁方法
     *      多实例：
     *          获取bean（构造器--->初始化方法--->容器关闭不会调用bean的销毁方法）
     *    后置处理器:构造器--->后置处理器before..--->初始化方法...--->后置处理器after...--->bean初始化完成
     *    无论bean是否有初始化方法，后置处理器都会默认其有，还会继续工作
     *
     */
    @org.junit.Test
    public void test(){

    }
}
