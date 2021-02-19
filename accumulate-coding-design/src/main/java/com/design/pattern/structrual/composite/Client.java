package com.design.pattern.structrual.composite;

import java.math.BigDecimal;

/**
 * @Author: Huaaaaaa
 * Date:  2020/12/20
 * Todo: 组合模式之安全方式：客户端需要只要树枝和树叶构件
 * Time 16:54
 */
public class Client {
    public static void main(String[] args) {

        //一个小袋子装水杯、牙膏、牙刷
        ShoppingBag littleShoppingBag = new ShoppingBag("小袋");
        Product cup = new Goods("水杯", 2, new BigDecimal(20));
        Product toothBrush = new Goods("牙刷", 2, new BigDecimal(10));
        Product toothPaste = new Goods("牙膏", 1, new BigDecimal(30));
        littleShoppingBag.add(cup);
        littleShoppingBag.add(toothBrush);
        littleShoppingBag.add(toothPaste);
        System.out.println("小袋中总花费：" + littleShoppingBag.calculatePrice() + "元");

        //一个中袋子装苹果、香蕉
        ShoppingBag middleShoppingBag = new ShoppingBag("中袋");
        Product apple = new Goods("苹果", 2, new BigDecimal(7));
        Product banana = new Goods("香蕉", 2, new BigDecimal(3.5));
        middleShoppingBag.add(apple);
        middleShoppingBag.add(banana);
        System.out.println("中袋中总花费：" + middleShoppingBag.calculatePrice() + "元");

        //一个大袋装中袋和小袋
        ShoppingBag bigShoppingBag = new ShoppingBag("大袋");
        bigShoppingBag.add(littleShoppingBag);
        bigShoppingBag.add(middleShoppingBag);

        //计算总价格
        System.out.println("本次购物总花费：" + bigShoppingBag.calculatePrice() + "元");
    }
}
