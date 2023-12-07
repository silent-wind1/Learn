package com.demo1;

public class TestThread2 implements Runnable{
    @Override
    public void run() {
//      run 方法线程体
        for (int i = 0; i < 200; i++) {
            System.out.println("我在看代码---" + i);
        }
    }

    public static void main(String[] args) {
//      创建runnable接口的实现类对象
        TestThread2 testThread2 = new TestThread2();
//      创建线程程对象，通过线程对象来开启我们的线程，代理
        new Thread(testThread2).start();
        for (int i = 0; i < 200; i++) {
            System.out.println("我在学多线程--" + i);
        }
    }
}
