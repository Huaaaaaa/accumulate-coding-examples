package com.design.pattern.behavioral.command;

/**
 * @Author: Huaaaaaa
 * Date:  2021/1/9
 * Todo:  命令接口，提供命令执行命令的方法
 * Time 18:35
 */
public interface AiCommand {

    /**
     * 命令执行方法
     */
    void execute();

    /**
     * 命令撤销方法
     */
    void undo();
}
