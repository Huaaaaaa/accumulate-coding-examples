package com.design.pattern.structrual.proxy.staticproxy;

/**
 * Author: Huaaaaaa
 * Date:  2020/12/27
 * Todo:
 * Time 21:23
 */
public class LoginService implements ILogin {

    @Override
    public boolean login(String userName, String password) {
        if ("admin".equals(userName) && "admin123".equals(password)) {
            return true;
        }
        return false;
    }
}
