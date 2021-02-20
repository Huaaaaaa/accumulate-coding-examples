package com.design.pattern.behavioral.memento.stack;

import java.io.InputStream;
import java.util.List;
import java.util.Stack;

/**
 * @Author: Huaaaaaa
 * @DateTime: 2021/2/20  16:18
 * @Description: 输入快照
 */
public class InputTextSnapShot {

    private String input;

    public InputTextSnapShot(String input) {
        this.input = input;
    }

    public String getInput() {
        return input;
    }
}
