package com.yefeng.behavior.command.cm;

import java.util.ArrayList;
import java.util.List;

/**
 * 命令接收者 执行命令
 */
public class Manager {
    /**
     * 存放命令
     */
    private List<Command> commands = new ArrayList<>();

    /**
     * 添加命令
     * @param command
     */
    public void addCommand(Command command) {
        commands.add(command);
    }

    /**
     * 执行命令
     */
    public void executeCommand() {
        for (Command command : commands) {
            // 逐个遍历执行命令
            command.execute();
        }
        // 命令执行完毕后 , 清空集合
        commands.clear();
    }
}