package com.yefeng.jdk17.demo;

import lombok.Data;

@Data
public final class Rectangle extends Shape {
    private final double length;
    private final double width;

    public double calculateArea() {
        return length * width;
    }
}