package com.design.pattern.structrual.proxy.dynamic;

import org.springframework.util.StringUtils;

/**
 * Author: Huaaaaaa
 * Date:  2020/12/27
 * Todo: 目标类
 * Time 21:37
 */
public class UserService implements IUser {

    /**
     * 删除用户
     *
     * @param name
     * @return
     */
    @Override
    public boolean delete(String name) {
        if (!StringUtils.isEmpty(name) && name.contains("test")) {
            return true;
        }
        return false;
    }
}
