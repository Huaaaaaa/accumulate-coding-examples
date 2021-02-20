package com.design.pattern.behavioral.mediator.fangtx;

/**
 * @Author: Huaaaaaa
 * @DateTime: 2021/2/20  9:54
 * @Description: 抽象中介者：房产公司，提供同事对象的注册功能和转发请求功能
 */
public interface Medium {

    void register(Customer customer);

    void relay(String from,String message);
}
