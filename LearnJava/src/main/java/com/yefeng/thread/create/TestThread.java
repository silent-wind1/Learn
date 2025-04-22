package com.yefeng.thread.create;

// 创建线程方式一：继承Thread类，重写run()方法，调用start开启线程
public class TestThread extends Thread {
    public static void main(String[] args) {
//        main创建线程，主线程
//        创建一个线程对象
        TestThread testThread = new TestThread();
//        调用start()方法开启线程
        testThread.start();
        for (int i = 0; i < 200; i++) {
            System.out.println("我在学习多线程---" + i);
        }
    }

    @Override
    public void run() {
//      run 方法线程体
        for (int i = 0; i < 200; i++) {
            System.out.println("我在看代码---" + i);
        }
    }
}