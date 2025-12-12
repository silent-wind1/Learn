package com.yefeng.jdk17.demo;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 继承 Shape 实现 calculateArea 方法
 * 加上 final 表示 到这个类为止，不能再被继承了
 */
@Data
@EqualsAndHashCode(callSuper = true)
public final class Circle extends Shape {
    private final double radius;

    public double calculateArea() {
        return Math.PI * radius * radius;
    }
}