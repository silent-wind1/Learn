package com.yefeng.thread.method.joindemo;

/**
 * @author wind
 * @description: 三个线程分别打印 A，B，C，要求这三个线程一起运行，打印 10 次，输出形如“ABCABCABC....”的字符串。
 * @date 2026/6/29 15:23
 */
public class PrintABCUsingJoin {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            printABC();
        }
    }

    private static void printABC() {
        try {
            Thread a = new Thread(() -> System.out.print("A"));
            Thread b = new Thread(() -> System.out.print("B"));
            Thread c = new Thread(() -> System.out.print("C"));
            a.start();
            a.join();
            b.start();
            b.join();
            c.start();
            c.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
