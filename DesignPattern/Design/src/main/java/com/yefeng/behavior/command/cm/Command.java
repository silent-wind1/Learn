package com.yefeng.behavior.command.cm;


/**
 * 命令接口
 * 所有的命令都要实现该接口
 */
public interface Command {
    /**
     * 执行命令方法
     */
    void execute();
}