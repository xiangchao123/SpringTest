package com.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by xiangchao on 2020/4/11.
 * 帮Calculator.java生成代理对象的类
 */
public class CalculatorProxy {
    /**
     * @author chosen1
     * 为传入的参数对象创建一个动态代理对象
     * target:被代理对象
     * 返回：代理对象
    */
    public static Calculator getProxy(final Calculator target){
        ClassLoader loader = target.getClass().getClassLoader();
        Class<?>[] interfaces = target.getClass().getInterfaces();
        //方法执行器。帮我们目标对象执行目标方法
        InvocationHandler h = new InvocationHandler() {
            /**
             * @author chosen1
             * Object com.proxy:代理对象，给jdk使用，任何时候都不要动这个对象
             * Method method：当前将要执行的目标对象的方法
             * Object[] args:这个方法调用时外界传入的参数值
            */
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                //利用反射执行目标方法
                //目标方法执行后的返回值
                //这里可以添加日志功能。即在目标方法执行前后动态加载某些方法，如日志方法
                System.out.println("动态代理将要执行");
                Object result = method.invoke(target, args);
                //返回值必须返回出去外界才能拿到真正执行后的返回值
                return result;
            }
        };
        //Proxy为目标对象创建代理对象
        Object proxy = Proxy.newProxyInstance(loader, interfaces, h);
        return (Calculator) proxy;
    }
}
