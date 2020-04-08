package com.test;

import com.xc.Car;
import com.xc.Person;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by xiangchao on 2020/4/5.
 */
public class Test {
    /**
     * @author chosen1
     * 1.src,源码包开始的路径，称为类路径的开始；
     *      所有源码包里面的东西都会被合并放在类路径（bin）里面
     *      java:/bin/
     *      web:/WEB-INF/classes/
     *
     *    细节：
     *    1.组件的创建工作是容器完成，容器中的对象的创建在容器创建完成的时候就已经创建好了
     *    2、同一个组件在ioc容器中是单实例的
     *    3、容器没有这个组件就获取，报异常
     *    4.容器在创建组件时，会用get、set方法进行赋值
     *    5.javaBean的属性名(property)由set.get方法后面的决定，如setID,ID为属性名
    */
    private ApplicationContext ioc = new ClassPathXmlApplicationContext("ioc.xml");
    private ApplicationContext ioc2 = new ClassPathXmlApplicationContext("ioc2.xml");
    private ApplicationContext ioc3 = new ClassPathXmlApplicationContext("ioc3.xml");


    /**
     * @author chosen1
     * FactoryBean
    */
    @org.junit.Test
    public void test11(){
        Object myFactoryBeanImple = ioc3.getBean("myFactoryBeanImple");
        System.out.println(myFactoryBeanImple);

    }
    /**
     * @author chosen1
     * 实验5:配置通过静态工厂方法创建的bean，实例工厂方法创建的bean、FactoryBean
    */
    @org.junit.Test
    public void test10(){
        Object airPlane01 = ioc3.getBean("airPlane01");
        Object airPlane02 = ioc3.getBean("airPlane02");
        System.out.println(airPlane02);

    }
    /**
     * @author chosen1
     * 实验9：测试bean的作用域，分别创建单实例和多实例的bean
    */
    @org.junit.Test
    public void test09(){
        Object book = ioc3.getBean("book");
        Object book1 = ioc3.getBean("book");
        System.out.println(book==book1);
    }
    @org.junit.Test
    public void test08(){
        Person person01 = (Person) ioc2.getBean("person06");
        System.out.println(person01);
    }
    @org.junit.Test
    public void test07(){
        Person person01 = (Person) ioc2.getBean("person06");
        System.out.println(person01);
    }
    /**
     * @author chosen1
     * 级联属性可以修改属性的属性，注意，原来的bean的值可能会被修改
    */
    @org.junit.Test
    public void test06(){
        Person person01 = (Person) ioc2.getBean("person04");
        System.out.println(person01.getCar());
        Object car01 = ioc2.getBean("car01");
        System.out.println(car01);

    }
    @org.junit.Test
    public void test05(){
        Person person01 = (Person) ioc2.getBean("person03");
        System.out.println(person01.getMaps());
        Object myMap = ioc2.getBean("myMap");
        System.out.println(myMap.getClass());
    }
    @org.junit.Test
    public void test04(){
        Person person01 =(Person) ioc2.getBean("person02");
        System.out.println(person01.getBooks());
        System.out.println(person01.getMaps());
        System.out.println(person01.getProperties());
    }
    /**
     * @author chosen1
     *实验4，正确的为各种属性赋值
    */
    @org.junit.Test
    public void test03(){
        Person person01 = (Person) ioc2.getBean("person02");
        System.out.println(person01.getLastname()==null);
        System.out.println(person01.getCar());
        Car car01 = ioc2.getBean("car01", Car.class);
        System.out.println(car01==person01.getCar());
        System.out.println(person01.getMaps());


    }
    /**
     * @author chosen1
     * 根据bean类型从IOC容器中获取bean实例
     * 如果ioc容器中这个类型的bean有多个，会报错
    */
    @org.junit.Test
    public void test2(){
//        Person bean = ioc.getBean(Person.class);
//        System.out.println(bean);
        Person person02 = ioc.getBean("person02", Person.class);
        System.out.println(person02);
        Object person03 = ioc.getBean("person03");
        System.out.println(person03);
        Object person04 = ioc.getBean("person04");
        System.out.println(person04);
    }
    @org.junit.Test
    public void test(){
        // ApplicationContext:代表IOC容器
        ApplicationContext ioc = new ClassPathXmlApplicationContext("ioc.xml");
        Person bean = (Person) ioc.getBean("person01");
        System.out.println(bean);
    }

}
