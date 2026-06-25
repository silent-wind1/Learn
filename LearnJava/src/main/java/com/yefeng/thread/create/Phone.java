package com.yefeng.thread.create;

import java.util.concurrent.TimeUnit;

/**
 * @author wind
 * @description: 问题：这样能被锁住吗？
 * @date 2026/6/25 16:17
 */
public class Phone {
    /**
     * 答案是锁不住，因为static方法存储在JVM方法区。
     * public static void call() {
     *     synchronized (Phone.class) {   // 锁 = Phone 的 Class 对象
     *         // ...方法体
     *     }
     * }
     */
    public static synchronized void call() {
        System.out.println(Thread.currentThread().getName()  + "is calling.....");
        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 下面这段代码类似于
     * public void send() {
     *     synchronized (this) {   // 锁 = 当前实例对象 phone
     *         // ...方法体
     *     }
     * }
     */
    public synchronized void send() {
        System.out.println(Thread.currentThread().getName()  + "is sending.....");
        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
