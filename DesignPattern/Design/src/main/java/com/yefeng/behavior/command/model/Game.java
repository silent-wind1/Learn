package com.yefeng.behavior.command.model;

/**
 * 该类与命令执行的具体逻辑相关
 */
public class Game {
    private String name;

    public Game(String name) {
        this.name = name;
    }

    public void open() {
        System.out.println(this.name + " 开放");
    }

    public void close() {
        System.out.println(this.name + " 关闭");
    }
}
