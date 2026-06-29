package com.yefeng.thread.method.joindemo;

/**
 * @author wind
 * @description: 线程要求:一条只能打印0，一条只能打印1, 循环打印100次交互输出， 01010101010101010101
 * @date 2026/6/29 15:23
 */
public class Print01UsingJoin {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            print01();
        }
    }

    private static void print01() {
        try {
            Thread a = new Thread(() -> System.out.print("0"));
            Thread b = new Thread(() -> System.out.print("1"));
            a.start();
            a.join();
            b.start();
            b.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
