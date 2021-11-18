package com.accumulate.coding.basic.juc;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author: cyhua
 * @createTime: 2021/11/17
 * @description: HashMap扩容测试
 */
public class HashMapResize {

    public static void main(String[] args) {
        HashMap<A, A> aMap = new HashMap();
        for (int i = 0; i < 15; i++) {
            A a = new A(String.valueOf(i));
            aMap.put(a, a);
        }

    }
}


class A {
    private String name;

    public String getName() {
        return name;
    }

    public A(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof A)) return false;
        A a = (A) o;
        return Objects.equals(name, a.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}