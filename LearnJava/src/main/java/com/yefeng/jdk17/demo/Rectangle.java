package com.yefeng.jdk17.demo;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 继承 Shape 实现 calculateArea 方法
 * 并且 Rectangle 也可以控制，只有 RightRectangle 类可以继承它
 */
@Data
@EqualsAndHashCode(callSuper = true)
public sealed class Rectangle extends Shape permits RightRectangle {
    private final double length;
    private final double width;

    public double calculateArea() {
        return length * width;
    }
}