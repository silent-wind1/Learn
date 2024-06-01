package com.yefeng.behavior.command.cm;

import com.yefeng.behavior.command.model.Game;

/**
 * 关闭命令
 */
public class CloseCommand implements Command {
    private Game game;

    public CloseCommand(Game game) {
        this.game = game;
    }

    @Override
    public void execute() {
        this.game.close();
    }
}
