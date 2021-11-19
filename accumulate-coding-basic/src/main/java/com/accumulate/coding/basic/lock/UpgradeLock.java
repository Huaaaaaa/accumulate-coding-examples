package com.accumulate.coding.basic.lock;

import com.accumulate.coding.basic.common.User;
import org.openjdk.jol.info.ClassLayout;

/**
 * @author: cyhua
 * @createTime: 2021/11/19
 * @description: 验证锁升级过程
 */
public class UpgradeLock {

    public static void main(String[] args) {
        User user = new User();
        System.out.println(ClassLayout.parseInstance(user).toPrintable());
    }
}
