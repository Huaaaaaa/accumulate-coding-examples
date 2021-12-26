package com.coding.interview.load;

import com.coding.interview.basic.Parent;

/**
 * @author: Hu-aaa-aaa
 * @createTime: 2021/12/26 10:58 上午
 * @description: 定义一个对象，测试克隆与new的效率
 */
public class CustomObj implements Cloneable {


    public CustomObj() {
    }

    public CustomObj(String pro) {
        pro = pro.substring(0, 3);

    }

    @Override
    public CustomObj clone() {
        try {
            return (CustomObj) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
