package com.yefeng.jdk17.demo;

/**
 * @Author: 叶枫
 * @Date: 2025/03/09/22:35
 * @Description: 主函数
 */
public class MainDemo {
    public static void main(String[] args) {
        Shape shape = new Rectangle(10, 20);
        double v = shape.calculateArea();
        System.out.println(v);
    }
}
