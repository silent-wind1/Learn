package com.yefeng.behavior.strategy.demo1.pen;

/**
 * 绘画策略接口
 * 所有的颜色的笔类 , 都要实现该接口
 */
public interface Strategy {
    void draw(int radius, int x, int y);
}
