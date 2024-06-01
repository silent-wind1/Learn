package com.yefeng.behavior.command.cm;

import com.yefeng.behavior.command.model.Game;

/**
 * 开启游戏命令
 * 实现 Command 接口
 * 该类代表了一种命令
 */
public class OpenCommand implements Command{
    private Game game;

    public OpenCommand(Game game) {
        this.game = game;
    }

    @Override
    public void execute() {
        this.game.open();
    }
}
