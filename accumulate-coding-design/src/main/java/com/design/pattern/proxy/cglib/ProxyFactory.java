package com.design.pattern.proxy.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Author: Huaaaaaa
 * Date:  2020/12/27
 * Todo: 代理工厂，使用cglib代理模式动态创建代理类
 * Time 22:01
 */
public class ProxyFactory implements MethodInterceptor {

    /**
     * 目标类
     */
    private Object target;

    public ProxyFactory(Object target) {
        this.target = target;
    }

    public Object getProxyInstance() {
        Enhancer enhancer = new Enhancer();
        enhancer.setInterfaces(target.getClass().getInterfaces());
        enhancer.setCallback(this);
        return enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        Long start = System.currentTimeMillis();
        Object res = method.invoke(target, args);
        Long end = System.currentTimeMillis();
        System.out.println("执行了" + (end - start) + "毫秒");
        return res;
    }
}
