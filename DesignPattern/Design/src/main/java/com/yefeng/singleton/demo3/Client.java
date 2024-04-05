package com.yefeng.singleton.demo3;

public class Client {
    public static void main(String[] args) {
        Singleton instance = Singleton.getSingleton();
        Singleton instance1 = Singleton.getSingleton();
        System.out.println(instance1 == instance);
    }
}
