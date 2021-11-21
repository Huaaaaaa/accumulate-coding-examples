package com.accumulate.coding.basic.lock;

import com.accumulate.coding.basic.common.User;
import org.openjdk.jol.info.ClassLayout;

/**
 * @author: Huaaaaaa
 * @createTime: 2021/11/19
 * @description: 验证锁升级过程
 */
public class UpgradeLock {

    public static void main(String[] args) throws InterruptedException {
        User unLockUser = new User();
        System.out.println("无锁user对象：" + ClassLayout.parseInstance(unLockUser).toPrintable());

        User shortSleepUser = new User();
        Thread.sleep(100);
        System.out.println("短暂sleep的user对象：" + ClassLayout.parseInstance(shortSleepUser).toPrintable());

        Thread.sleep(5000);
        User longSleepUser = new User();
        System.out.println("较长sleep的user对象（启用偏向锁）：" + ClassLayout.parseInstance(longSleepUser).toPrintable());

        for (int i = 0; i < 2; i++) {
            synchronized (longSleepUser) {
                System.out.println("偏向锁（带线程id）：" + ClassLayout.parseInstance(longSleepUser).toPrintable());
            }
            System.out.println("偏向锁释放（带线程id）：" + ClassLayout.parseInstance(longSleepUser).toPrintable());
        }
        new Thread(() -> {
            synchronized (longSleepUser) {
                System.out.println("轻量级锁：" + ClassLayout.parseInstance(longSleepUser).toPrintable());
                try {
                    System.out.println("睡眠3秒钟---");
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        new Thread(() -> {
            synchronized (longSleepUser) {
                System.out.println("重量级锁：" + ClassLayout.parseInstance(longSleepUser).toPrintable());
            }
        }).start();
    }
}
