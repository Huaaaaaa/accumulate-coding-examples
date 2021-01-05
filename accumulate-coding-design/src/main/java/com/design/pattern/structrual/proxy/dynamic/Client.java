package com.design.pattern.structrual.proxy.dynamic;

/**
 * Author: Huaaaaaa
 * Date:  2020/12/27
 * Todo:
 * Time 21:46
 */
public class Client {

    public static void main(String[] args) {
        IUser userService = new UserService();
        IUser proxyInstance = (IUser) new ProxyFactory(userService).getProxyInstance();
        boolean res = proxyInstance.delete("test01");
        System.out.println(res ? "删除成功" : "删除失败");
    }
}
