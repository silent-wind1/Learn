package com.yefeng.thread.method.joindemo;

/**
 * @author wind
 * @description: Java两个线程交替打印奇偶数
 * @date 2026/6/29 20:53
 */
public class PrintOddEven {
    private static int count = 0;
    private static final Object lock = new Object();

    public static void main(String[] args) {
        new Thread(() -> {
            while (count < 100) {
                synchronized (lock) {
                    if (count % 2 == 1) {
                        System.out.println(Thread.currentThread().getName() + ":" + count++);
                    }
                }
            }
        }, "奇数线程").start();

        new Thread(() -> {
            while (count < 100) {
                synchronized (lock) {
                    if (count % 2 == 0) {
                        System.out.println(Thread.currentThread().getName() + ":" + count++);
                    }
                }
            }
        }, "偶数线程").start();
    }
}
