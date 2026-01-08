package com.yefeng.pool;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author wind
 * @description:
 * @date 2026/1/8 19:42
 */
public class ReentrantLockDemo {
    private static ReentrantLock lock = new ReentrantLock();
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            // 尝试获取锁
            System.out.println("Thread 1 try lock");
            if (!lock.tryLock()) {
                System.out.println("获取锁不成功");
            }
        }, "t1");

        lock.lock();
        System.out.println("上锁成功");
        t1.start();

    }
}
