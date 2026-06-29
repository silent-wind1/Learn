package com.yefeng.thread.method.joindemo;

/**
 * @author wind
 * @description: 三个线程分别打印 A，B，C，要求这三个线程一起运行，打印 10 次，输出形如“ABCABCABC....”的字符串。
 * @date 2026/6/29 14:56
 */
public class PrintABCUsingLock {
    private static int num = 0;
    private static final Object lock = new Object();

    public static void main(String[] args) {
        new Thread(() -> print('A', 0), "A").start();
        new Thread(() -> print('B', 1), "B").start();
        new Thread(() -> print('C', 2), "C").start();
    }

    private static void print(char ch, int target) {
        for (int i = 0; i < 10; i++) {
            synchronized (lock) {
                // ✅  用 while 防止虚假唤醒
                while (num != target) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                System.out.print(ch);
                num = (num + 1) % 3;  // 切到下一个
                lock.notifyAll();     // ✅  唤醒所有等待线程
            }
        }
    }
}
