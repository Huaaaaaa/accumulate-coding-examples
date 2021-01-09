package com.design.pattern.behavioral.command;

/**
 * Author: Huaaaaaa
 * Date:  2021/1/9
 * Todo:
 * Time 19:39
 */
public class UndoCommand {

    AiCommand aiCommand;

    public UndoCommand(AiCommand aiCommand) {
        this.aiCommand = aiCommand;
    }
}
