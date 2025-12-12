package com.yefeng.jdk17.demo;

/**
 * non-sealed 表示开放继承，任何类都可以继承 RightRectangle 类
 */
public non-sealed class RightRectangle extends Rectangle {
    public RightRectangle(double length, double width) {
        super(length, width);
    }
}
