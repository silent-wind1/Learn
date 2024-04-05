package com.yefeng.Strategy;

public class Client {
    public static void main(String[] args) {
        Context context = new Context(new BluePen()); // 使用绿色笔来画
        context.executeDraw(10, 0, 0);
    }
}
