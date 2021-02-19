package com.design.pattern.behavioral.observer.jdk;

/**
 * @Author: Huaaaaaa
 * @DateTime: 2021/2/19  18:32
 * @Description: 观察者模式在jdk中的使用
 */
public class JdkClient {

    public static void main(String[] args) {
        System.out.println("======使用jdk自带的观察者模式实现======");
        //具体目标类
        JdkWeatherCenter jdkWeatherCenter = new JdkWeatherCenter();
        //具体观察者类
        JdkXiaoMiWeatherHelper jdkXiaoMiWeatherHelper = new JdkXiaoMiWeatherHelper();
        //注册观察者
        jdkWeatherCenter.addObserver(jdkXiaoMiWeatherHelper);
        //定义传入参数
        JdkWeatherData jdkWeatherData = new JdkWeatherData(8, 100, 30);
        System.out.println("您好，现在是北京时间早上八点");
        //目标对象更新数据，即可实时同步给具体观察者
        jdkWeatherCenter.updateData(jdkWeatherData);
    }
}
