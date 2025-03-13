package com.yefeng.jdk17.demo;


public sealed abstract class Shape permits Circle, Rectangle {
    public abstract double calculateArea();
}