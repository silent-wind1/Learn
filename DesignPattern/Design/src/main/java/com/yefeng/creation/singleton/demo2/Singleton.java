package com.yefeng.creation.singleton.demo2;

/**
 * 饿汉式：静态代码块 创建类的对象
 */
public class Singleton {
    private Singleton() {}

    private static Singleton singleton;

    static {
        singleton = new Singleton();
    }

    public static Singleton getInstance() {
        return singleton;
    }
}
