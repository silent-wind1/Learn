package com.yefeng.jdk17.demo;


/**
 * 只允许 Circle 和 Rectangle 继承
 */
public sealed abstract class Shape permits Circle, Rectangle {
    public abstract double calculateArea();
}