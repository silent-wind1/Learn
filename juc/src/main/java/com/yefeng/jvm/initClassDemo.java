package com.yefeng.jvm;

/**
 * @Author: 叶枫
 * @Date: 2024/12/24/13:17
 * @Description:
 */
public class initClassDemo {
    public static int value = 24;

    static {
        value = 25;
    }

    public static void main(String[] args) {
        System.out.println(initClassDemo.value);
    }
}
