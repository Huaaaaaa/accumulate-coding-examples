package com.design.pattern.proxy.staticproxy;

import com.google.common.collect.ImmutableList;

/**
 * Author: Huaaaaaa
 * Date:  2020/12/27
 * Todo:  客户端
 * Time 21:29
 */
public class Client {

    public static void main(String[] args) {
        ILogin login = new LoginProxy();
        boolean res = login.login("admin", "admin1234");
        System.out.println(res ? "登录成功" : "登录失败，请检查用户名或密码是否正确");
    }
}
