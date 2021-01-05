package com.design.pattern.structrual.proxy.dynamic;

import java.lang.reflect.Proxy;

/**
 * Author: Huaaaaaa
 * Date:  2020/12/27
 * Todo: 权限代理类，在执行一些方法之前校验是否有操作权限
 * Time 21:39
 */
public class ProxyFactory {
    //目标代理类
    private Object target;


    public ProxyFactory(Object target) {
        this.target = target;
    }

    /**
     * 获取目标类的代理对象
     *
     * @return
     */
    public Object getProxyInstance() {
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), (proxy, method, args) -> {
            Long start = System.currentTimeMillis();
            Object res = method.invoke(target, args);
            Long end = System.currentTimeMillis();
            System.out.println("执行了" + (end - start) + "毫秒");
            return res;
        });
    }
}
