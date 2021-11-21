package com.accumulate.coding.basic.base;

/**
 * @author: Huaaaaaa
 * @createTime: 2021/11/19
 * @description:
 */
public class AddNum {

    public static void main(String[] args) {
        int i = 2;
        i = i++;
        int j = i++;
        int k = i+ ++i + i++;
        System.out.println("i="+i);
        System.out.println("j="+j);
        System.out.println("k="+k);
    }
}
