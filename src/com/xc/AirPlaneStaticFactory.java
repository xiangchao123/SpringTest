package com.xc;

/**
 * 静态工厂
 * Created by xiangchao on 2020/4/6.
 */
public class AirPlaneStaticFactory {
    public static AirPlane getAirPlane(String jzName){
        System.out.println("AirPlaneStaticFactory...正在为你造飞机");
        AirPlane airPlane = new AirPlane();
        airPlane.setFdj("太行");
        airPlane.setFjsName("xiaoming ");
        airPlane.setJzName(jzName);
        airPlane.setPersonNum(300);
        airPlane.setYc("198.98m");
        return airPlane;
    }
}
