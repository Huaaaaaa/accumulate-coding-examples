package com.design.pattern.behavioral.memento.stack;

import java.util.Scanner;

/**
 * @Author: Huaaaaaa
 * @DateTime: 2021/2/20  16:37
 * @Description:
 */
public class InputClient {

    public static void main(String[] args) {
        InputText inputText = new InputText();
        SnapshotCaretaker snapshotCaretaker = new SnapshotCaretaker();
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入命令:");
        while (scanner.hasNext()) {
            String input = scanner.next();
            if (input.equals(":list")) {
                System.out.println(inputText.getText());
            } else if (input.equals(":undo")) {
                InputTextSnapShot inputTextSnapShot = snapshotCaretaker.popSnapshot();
                inputText.setText(inputTextSnapShot.getInput());
            } else {
                //输入内容追加到inputText中
                inputText.append(input + ",");
                InputTextSnapShot memento = inputText.createMemento(input);
                snapshotCaretaker.pushSnapshot(memento);
            }
        }

    }
}
