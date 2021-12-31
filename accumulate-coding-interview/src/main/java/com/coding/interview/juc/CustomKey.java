package com.coding.interview.juc;

/**
 * @author: Hu-aaa-aaa
 * @createTime: 2021/12/30 11:18 上午
 * @description:
 */
public class CustomKey {

    private int data;

    public CustomKey() {
    }

    public CustomKey(int data) {
        this.data = data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CustomKey)) return false;
        CustomKey customKey = (CustomKey) o;
        return data == customKey.data;
    }

    @Override
    public int hashCode() {
        return data;
    }

    @Override
    public String toString() {
        return "CustomKey{" +
                "data=" + data +
                '}';
    }
}
