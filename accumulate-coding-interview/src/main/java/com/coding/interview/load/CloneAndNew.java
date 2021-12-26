package com.coding.interview.load;

/**
 * @author: Hu-aaa-aaa
 * @createTime: 2021/12/26 10:59 上午
 * @description: 比较clone和new的效率
 * 当构造方法比较简单时，new的效率高于clone
 * 当构造方法中有业务逻辑时，clone的效率高于new
 * clone只是将内存中已经存在的对象复制一份分配到新的内存空间，不需要进行对象的初始化过程，而new每次都要执行初始化
 */
public class CloneAndNew {

    private static final int COUNT = 1000;

    public static void main(String[] args) {
        System.out.println("-------create original object--------");

        long t1 = System.currentTimeMillis();
        for (int i = 0; i < COUNT; i++) {
            CustomObj newObj = new CustomObj(String.valueOf(System.currentTimeMillis()));
        }
        System.out.println("newObj used time:" + (System.currentTimeMillis() - t1));
        CustomObj cloneObj = new CustomObj(String.valueOf(System.currentTimeMillis()));
        long t2 = System.currentTimeMillis();
        for (int i = 0; i < COUNT; i++) {
            CustomObj clone = cloneObj.clone();
        }
        System.out.println("cloneObj used time:" + (System.currentTimeMillis() - t2));
    }
}
