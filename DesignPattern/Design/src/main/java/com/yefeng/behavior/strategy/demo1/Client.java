package com.yefeng.behavior.strategy.demo1;

import com.yefeng.behavior.strategy.demo1.pen.BluePen;
import com.yefeng.behavior.strategy.demo1.pen.GreenPen;

/**
 * 声依永
 */
public class Client {
    public static void main(String[] args) {
        Context context = new Context(new BluePen()); // 使用蓝色笔来画
        context.executeDraw(10, 0, 0);
        context = new Context(new GreenPen()); // 使用绿色笔来画
        context.executeDraw(10, 2, 0);
    }
}
