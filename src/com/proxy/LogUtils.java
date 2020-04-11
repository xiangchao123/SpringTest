package com.proxy;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * Created by xiangchao on 2020/4/11.
 * 1、将切面类（封装了通知方法（在目标方法执行前后执行的方法））加入到ioc容器中
 * 2、告诉Spring那个是切面类@Aspect
 * 3、告诉Spring切面类里面的每一个方法，都是何时何地运行；
 * 5个通知注解
 *  @Before：在目标方法之前运行：                      前置通知
 *  @After:在目标方法运行结束之后：                     后置通知
 *  @AfterReturning:在目标方法正常返回的时候：       返回通知
 *  @AfterThrowing:在目标方法抛出异常之后运行：       异常通知
 *  @Around：环绕：                                     环绕通知
 */
@Aspect
@Component
@Order(1)//改变切面顺序，数值越小，优先级越高
public class LogUtils {
    /**
     * @author chosen1
     *  抽取可重用的切入点表达式
     *  1、随便声明一个没有实现的返回void的空方法
    */
    @Pointcut("execution(public int com.proxy.MyMathCalculator.*(int,int) )")
    public void hahahMyPoint(){}

    //想在目标方法之前运行,写切入表达式
    //excution(访问权限符 返回值类型 方法签名)
    @Before("hahahMyPoint()")
    public static void logStart(JoinPoint joinPoint){
        Object[] args = joinPoint.getArgs();
        //获取到方法签名
        Signature signature = joinPoint.getSignature();

        System.out.println("["+signature.getName()+"]方法执行开始，用的参数列表["+ Arrays.asList(args)+"]");
    }
    /**
     * @author chosen1
     * 切入点表达式的写法
     * 固定格式：execution(访问权限符 返回值类型 方法全类名(参数表))
     * 通配符：
     *         *：1）匹配一个或者多个字符 execution(public int com.proxy.MyMath*r.*(int,int))
     *             2)匹配任意一个参数execution(public int com.proxy.MyMath*r.*(int,*))，只匹配两个参数
     *             3)只匹配一层路径
     *             4）权限位置*不能写：权限位置不谢就行：public【可选的】
     *         ..:1）匹配任意多个参数，任意类型参数execution(public int com.proxy.MyMath*r.*(..))
     *             2)匹配任意多层路径 execution(public int com..MyMath*r.*(int,*))
     *
     *            最模糊的:execution(* *.*(..))
    */
    //想在目标方法正常执行完成之后执行,告诉Spring这个result用来接收返回值
    @AfterReturning(value = "execution(public int com.proxy.MyMathCalculator.*(int,int))",returning = "result")
    public static void logReturn(JoinPoint joinPoint,Object result){
        System.out.println("["+joinPoint.getSignature().getName()+"]方法正确执行，计算结果"+result);
    }
    /**
     * @author chosen1
     * 细节4、我们可以在通知方法运行的时候，拿到目标方法的详细信息；
     * 1）只需要为通知方法的参数列表上写一个参数，JoinPoint封装了当前目标方法的详细信息
    */
    //想在目标方法出现异常执行
    @AfterThrowing(value = "execution(public int com.proxy.MyMathCalculator.*(int,int))",throwing = "e")
    public static void logException(JoinPoint joinPoint,Exception e){
        Object[] args = joinPoint.getArgs();
        System.out.println("[xxx]方法执行出现异常，异常信息[xxx]"+e);
    }
    //想在目标方法结束的时候执行
    /**
     * @author chosen1
     * Spring 对通知方法的要求不严格
     * 唯一要求的就是方法的参数列表一定不能乱写
     *      通知方法是Spring利用反射调用的，每次方法调用得确定这个方法的参数表的值
     *      参数表上的每一个参数，Spring都得知道是什么，JoinPoint认识，不知道的参数一定告诉Spring这是什么，如throwing ,returning
    */
    @After("hahahMyPoint()")
    private int  logEnd(){
        System.out.println("[xxx]方法最终结束了[xxx]");
        return 0;
    }

    /**
     * @author chosen1
     * @Around：环绕：是Spring中最强大的通知；
     * @Around：环绕：动态代理
     *     method.invoke(obj,args);
     *     四合一通知就是环绕通知；
     *     环绕通知中有一个参数:ProceedingJoinPoint pjp
     *     环绕通知：是优于普通通知执行，执行顺序
     *     新的顺序：
     *          环绕前置---普通前置---目标方法执行---环绕正常返回/出现异常---环绕后置---普通后置---普通返回或异常
     *     多切面中，环绕只是影响当前切面
    */
    @Around("hahahMyPoint()")
    public Object myAround(ProceedingJoinPoint pjp) throws Throwable {
        Object[] args = pjp.getArgs();
        Object proceed = null;
        try {

            //@Before
            System.out.println(pjp.getSignature().getName()+"环绕前置");
            //就是利用反射调用目标方法即可,就是method.invoke(obj,args);
             proceed = pjp.proceed(args);
            //@AfterReturing
            System.out.println("环绕返回通知,返回值"+proceed);
        }catch (Exception e){
            //@AfterThrowing
            System.out.println("环绕异常通知");
            //为了让外界能知道这个异常，这个异常一定抛出去
            throw new RuntimeException(e);
        }finally {
            //@After
            System.out.println("环绕后置通知");
        }

        //反射调用后的返回值也一定返回出去
        return proceed;
    }
}
