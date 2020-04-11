package com.proxy;

import org.springframework.stereotype.Service;

/**
 * Created by xiangchao on 2020/4/11.
 * 将目标类加入ioc容器
 */
@Service
public class MyMathCalculator /**implements Calculator */{

//    @Override
    public int add(int i, int j) {
        int result = i+j;
        return result;
    }

//    @Override
    public int sub(int i, int j) {
        int result = i-j;
        return result;
    }

//    @Override
    public int mul(int i, int j) {
        int result = i*j;
        return result;
    }

//    @Override
    public int div(int i, int j) {
        int result = i/j;
        return result;
    }
}
