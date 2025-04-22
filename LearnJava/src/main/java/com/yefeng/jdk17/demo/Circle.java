package com.yefeng.jdk17.demo;

import lombok.Data;

@Data
public final class Circle extends Shape {
    private final double radius;

    public double calculateArea() {
        return Math.PI * radius * radius;
    }
}