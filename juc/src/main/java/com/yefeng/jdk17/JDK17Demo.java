package com.yefeng.jdk17;

/**
 * @Author: 叶枫
 * @Date: 2025/03/06/23:07
 * @Description:
 */
public class JDK17Demo {
    public static void main(String[] args) {
        String name = "JDK17Demo";
        formmatter(name);

        Object obj = "Hello, Java 17!";

        // 使用 JDK 17 语法的 instanceof 模式匹配
        if (obj instanceof String s) {
            // s 直接作为 String 类型变量使用
            System.out.println("字符串长度: " + s.length());
        } else {
            System.out.println("不是字符串类型");
        }
    }

    private static void formmatter(Object name) {
        String message = "Hello";
        if (name instanceof String s) {
            message = String.format("%s %s", message, name);
        }
        System.out.println(message);
    }
}
