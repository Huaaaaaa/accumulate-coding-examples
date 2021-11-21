package com.accumulate.coding.basic.thread;

import com.accumulate.coding.basic.common.User;

/**
 * @author: Huaaaaaa
 * @createTime: 2021/11/18
 * @description: 单例模式
 */
public class UserFactory {

    private static volatile User user;

    public static User getUser() {
        if (null == user) {
            synchronized (UserFactory.class) {
                if (null == user) {
                    user = new User();
                }
            }
        }
        return user;
    }

    public static void main(String[] args) {
        User user = UserFactory.getUser();
        System.out.println(user);
    }
}
