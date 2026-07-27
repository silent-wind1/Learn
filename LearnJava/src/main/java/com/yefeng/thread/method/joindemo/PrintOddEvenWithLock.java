package com.yefeng.thread.method.joindemo;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author wind
 * @description: Java两个线程交替打印奇偶数用 ReentrantLock + Condition 实现
 * @date 2026/6/29 21:08
 */
public class PrintOddEvenWithLock {
    private static int count = 0;
    private static final ReentrantLock lock = new ReentrantLock();
    private static final Condition even = lock.newCondition();
    private static final Condition odd = lock.newCondition();

    public static void main(String[] args) {
        new Thread(() -> {
            lock.lock();
            try {
                while(count < 100) {
                    while(count % 2 == 1) {
                        even.await();
                    }
                    System.out.println(Thread.currentThread().getName() + ":" + count++);
                    // 唤醒奇数线程
                    odd.signal();
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }finally {
                lock.unlock();
            }
        }, "偶数线程").start();

        new Thread(() -> {
            lock.lock();
            try {
                while(count < 100) {
                    while(count % 2 == 0) {
                        odd.await();
                    }
                    System.out.println(Thread.currentThread().getName() + ":" + count++);
                    // 唤醒偶数线程
                    even.signal();
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }finally {
                lock.unlock();
            }
        }, "奇数线程").start();
    }

}
