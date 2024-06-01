package com.yefeng.behavior.command;

import com.yefeng.behavior.command.cm.CloseCommand;
import com.yefeng.behavior.command.cm.OpenCommand;
import com.yefeng.behavior.command.cm.Manager;
import com.yefeng.behavior.command.model.Game;

public class Main {
    public static void main(String[] args) {
        Game game = new Game("Game 01");

        OpenCommand openCommand = new OpenCommand(game);
        CloseCommand closeCommand = new CloseCommand(game);

        // 发送命令
        Manager manager = new Manager();
        manager.addCommand(openCommand);
        manager.addCommand(closeCommand);

        // 执行命令
        manager.executeCommand();
    }
}
