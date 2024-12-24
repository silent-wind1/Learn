package com.yefeng.thread.creitical;

public class Demo {
    static int counter = 0;
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 5000; i++) {
//                counter++;
                incrementCounter();
            }
        }, "t1");
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 5000; i++) {
//                counter--;
                decrementCounter();
            }
        }, "t2");
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(counter);
    }

    private static void incrementCounter() {
        synchronized (Demo.class) {
            counter++;
        }
    }

    private static void decrementCounter() {
        synchronized (Demo.class) {
            counter--;
        }
    }
}
