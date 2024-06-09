package com.yefeng.creation.singleton.demo1;

/**
 * 饿汉式：静态变量创建类的对象
 */
public class Singleton {
    private Singleton() {
    }

    private final static Singleton instance = new Singleton();

    public static Singleton getInstance() {
        return instance;
    }
}
