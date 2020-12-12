package com.design.pattern.factory.simplefactory;

import org.springframework.util.Assert;

import java.util.Scanner;

/**
 * Author: Huaaaaaa
 * Date:  2020/12/12
 * Todo: 云商城，提供购买能力
 * Time 12:17
 */
public class CloudStore {

    public static void buy() {
        do {
            System.out.println("请输入您要购买的产品");
            Scanner scanner = new Scanner(System.in);
            String scType = scanner.nextLine();
            CloudProduct cf = CloudFactory.cloudService(scType);
            Assert.notNull(cf, "没有找到您要的产品");
            String product = cf.service();
            System.out.println(product);
            System.out.println("恭喜您购买完成");
        } while (true);
    }
}
