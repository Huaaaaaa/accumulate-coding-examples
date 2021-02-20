package com.design.pattern.behavioral.memento.stack;

import java.util.Stack;

/**
 * @Author: Huaaaaaa
 * @DateTime: 2021/2/20  16:13
 * @Description: Originator角色：输入的内容
 */
public class InputText {

    private StringBuilder text = new StringBuilder();

    public String getText() {
        return text.toString();
    }

    public void append(String input) {
        text.append(input);
    }

    /**
     * 创建快照
     *
     * @param input
     * @return
     */
    public InputTextSnapShot createMemento(String input) {
        return new InputTextSnapShot(input);
    }

    public void setText(String undo) {
        this.text.replace(text.lastIndexOf(undo), text.length()+1, "");
    }
}
