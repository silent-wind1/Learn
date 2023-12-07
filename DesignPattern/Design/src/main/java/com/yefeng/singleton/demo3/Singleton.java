package com.yefeng.singleton.demo3;

/**
 * 懒汉式：
 */
public class Singleton {
    public Singleton() {
    }

    private static Singleton singleton;

    public static Singleton getSingleton() {
        if(singleton == null) {
            singleton = new Singleton();
        }
        return singleton;
    }

}
