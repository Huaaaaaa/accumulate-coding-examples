package com.design.pattern.proxy.staticproxy;

/**
 * Author: Huaaaaaa
 * Date:  2020/12/27
 * Todo: 登录代理类，在执行登录前后记录时间，最后统计出执行时长
 * Time 21:25
 */
public class LoginProxy implements ILogin {

    private ILogin iLogin;

    @Override
    public boolean login(String userName, String password) {
        long startTime = System.currentTimeMillis();
        iLogin = new LoginService();
        boolean res = iLogin.login(userName, password);
        long endTime = System.currentTimeMillis();
        System.out.println("执行时长是：" + (endTime - startTime));
        return res;
    }
}
