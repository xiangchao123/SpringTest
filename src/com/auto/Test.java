package com.auto;

import com.auto.service.BookService;
import com.auto.servlet.BookServlet;
import com.xc.Book;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by xiangchao on 2020/4/10.
 * 使用Spring的单元测试
 * 1、导包：Spring单元测试包
 * 2、@ContextConfiguration(locations="")使用它来指定Spring的配置文件的位置
 * 3、@RunWith()指定用那种驱动进行单元测试，默认就是junit
 *      @RunWith(SpringJUnit4ClassRunner.class)使用Spring的单元测试模块来执行标了@Test注解的测试方法
 *      @org.junit.Test以前,注解只是由junit执行
 *  好处：我们不用ioc.getBean()获取组件了：直接@Autowired组件，Spring为我们自动装配
 *
 */
@ContextConfiguration(locations="classpath:applicationContext15.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class Test {
//    private ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext15.xml");

    @Autowired
    BookServlet bookServlet;
    /**
     * @author chosen1
     * 使用注解加入到容器中的组件，和使用配置加入到容器中的组件行为都是默认一样的；
     * 1、组件的id，默认就是组件的类名首字母小写:@Repository("bookdaohaha")改名字
     * 2、组件的作用域，默认就是单例的:@Scope(value = "prototype")修改为多实例
    */
    @org.junit.Test
    public void test(){
//        BookServlet bean = ioc.getBean(BookServlet.class);
//        bean.doGet();
        System.out.println(bookServlet);

    }

}
