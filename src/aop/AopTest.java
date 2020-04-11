import com.proxy.Calculator;
import com.proxy.MyMathCalculator;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by xiangchao on 2020/4/11.
 */
public class AopTest {
    ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationaop.xml");
    @Test
    public void test(){
        //细节1、一定要用接口类型，不能用它本类
        //aop的底层是动态代理，容器中保存的组件是他的代理对象，当然不是本类的类型
//        Calculator bean = ioc.getBean(Calculator.class);
//        System.out.println(bean.add(1, 2));

        //没有接口,就是本类类型，cglib帮我们创建好的代理对象
        // class com.proxy.MyMathCalculator$$EnhancerBySpringCGLIB$$f52e1e43
        MyMathCalculator bean = ioc.getBean(MyMathCalculator.class);
        System.out.println(bean.getClass());
    }
    /**
     * @author chosen1
     * 细节3:通知方法的执行顺序
     *  正常执行：@Before(前置通知)====== @After（后置通知）====@AfterReturning(正常返回):
     *  异常执行：@Before(前置通知)====== @After（后置通知）====@AfterThrowing(方法异常)
    */
    @Test
    public void test2(){
        MyMathCalculator bean = ioc.getBean(MyMathCalculator.class);
        bean.div(2,1);
        System.out.println(bean.getClass());
    }
}
