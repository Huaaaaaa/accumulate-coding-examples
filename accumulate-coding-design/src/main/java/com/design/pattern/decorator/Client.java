package com.design.pattern.decorator;

/**
 * Author: Huaaaaaa
 * Date:  2020/12/20
 * Todo:
 * Time 10:05
 */
public class Client {

    public static void main(String[] args) {
        Drink bubbleMilkTea = new BubbleMilkTea();
        bubbleMilkTea.setCount(2);
        String desc = bubbleMilkTea.getDescription() + bubbleMilkTea.getPrice() + "元";
        System.out.println(desc);

        bubbleMilkTea = new CondimentPudding(bubbleMilkTea);
        desc = bubbleMilkTea.getDescription() + bubbleMilkTea.cost() + "元";
        System.out.println(desc);

        bubbleMilkTea = new CondimentPearl(bubbleMilkTea);
        desc = bubbleMilkTea.getDescription() + bubbleMilkTea.cost() + "元";
        System.out.println(desc);

        bubbleMilkTea = new CondimentMesona(bubbleMilkTea);
        bubbleMilkTea.setCount(2);
        desc = bubbleMilkTea.getDescription() + bubbleMilkTea.cost() + "元";
        System.out.println(desc);
    }
}
