package com.design.pattern.behavioral.memento.stack;

import java.util.List;
import java.util.Stack;

/**
 * @Author: Huaaaaaa
 * @DateTime: 2021/2/20  16:21
 * @Description: Caretaker备忘录管理者：快照管理器
 */
public class SnapshotCaretaker {

    private Stack<InputTextSnapShot> snapshots = new Stack<>();

    public InputTextSnapShot popSnapshot() {
        return snapshots.pop();
    }

    public void pushSnapshot(InputTextSnapShot inputTextSnapShot) {
        snapshots.push(inputTextSnapShot);
    }
}
