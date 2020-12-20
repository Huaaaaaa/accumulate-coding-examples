package com.design.pattern.composite;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.util.CollectionUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Author: Huaaaaaa
 * Date:  2020/12/20
 * Todo: 树枝节点
 * Time 16:46
 */
public class ShoppingBag extends Product {
    /**
     * 树枝名称：即袋子名称
     */
    private String name;

    /**
     * 树叶：即要装的具体的物品
     */
    private List<Product> products = new ArrayList<>();


    public ShoppingBag(String name) {
        this.name = name;
    }

    /**
     * 自定义添加树叶方法
     *
     * @param p
     * @return
     */
    public boolean add(Product p) {
        return products.add(p);
    }

    /**
     * 自定义删除树叶方法
     *
     * @param index
     * @return
     */
    public Product remove(int index) {
        if (!CollectionUtils.isEmpty(products) && products.get(index) != null) {
            return products.remove(index);
        }
        return null;
    }

    @Override
    BigDecimal calculatePrice() {
        BigDecimal totalPrice = new BigDecimal(0);
        for (Product p : products) {
            totalPrice = totalPrice.add(p.calculatePrice());
        }
        return totalPrice;
    }

    @Override
    String show() {
        return this.name;
    }
}
