package com.yefeng.pool;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class OddEvenPrinter {
    private static int count = 1;
    private static final ReentrantLock lock = new ReentrantLock();
    private static final Condition oddCondition = lock.newCondition();
    private static final Condition evenCondition = lock.newCondition();

    public static void main(String[] args) {
        Thread oddThread = new Thread(() -> {
            while (count <= 100) {
                lock.lock();
                try {
                    if (count % 2 == 1) {
                        System.out.println("奇数线程: " + count);
                        count++;
                        evenCondition.signal(); // 精准唤醒偶数线程
                    } else {
                        oddCondition.await();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        });

        Thread evenThread = new Thread(() -> {
            while (count <= 100) {
                lock.lock();
                try {
                    if (count % 2 == 0) {
                        System.out.println("偶数线程: " + count);
                        count++;
                        oddCondition.signal(); // 精准唤醒奇数线程
                    } else {
                        evenCondition.await();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        });

        oddThread.start();
        evenThread.start();
    }
}