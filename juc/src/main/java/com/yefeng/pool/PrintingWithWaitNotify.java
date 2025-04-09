package com.yefeng.pool;

/**
 * @Author: 叶枫
 * @Date: 2025/04/09/21:38
 * @Description:
 */
public class PrintingWithWaitNotify {
    private static final Object lock = new Object();
    private static int number = 1;
    private static final int MAX_NUMBER = 100;

    public static void main(String[] args) {
        Thread oddThread = new Thread(new OddPrinter());
        Thread evenThread = new Thread(new EventPrinter());

        oddThread.start();
        evenThread.start();
    }
    static class OddPrinter implements Runnable {
        @Override
        public void run() {
            while (number <= MAX_NUMBER) {
                synchronized (lock) {
                    if (number % 2 == 0) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    } else {
                        System.out.println(number);
                        number++;
                        lock.notify();
                    }
                }
            }
        }
    }

    static class EventPrinter implements Runnable {
        @Override
        public void run() {
            while (number <= MAX_NUMBER) {
                synchronized (lock) {
                    if (number % 2 == 1) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    } else {
                        System.out.println(number);
                        number++;
                        lock.notify();
                    }
                }
            }
        }
    }
}
