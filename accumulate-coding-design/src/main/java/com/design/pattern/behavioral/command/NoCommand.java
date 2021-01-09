package com.design.pattern.behavioral.command;

/**
 * Author: Huaaaaaa
 * Date:  2021/1/9
 * Todo: 空命令，什么都不实现
 * Time 19:12
 */
public class NoCommand implements AiCommand{


    @Override
    public void execute() {

    }

    @Override
    public void undo() {

    }
}
