package com.yefeng.behavior.strategy.demo1.pen;

/**
 * 蓝色笔 类： 画一个圆圈
 */
public class BluePen implements Strategy {
    @Override
    public void draw(int radius, int x, int y) {
        System.out.println("用蓝色笔画图，radius:" + radius + ", x:" + x + ", y:" + y);
    }
}  