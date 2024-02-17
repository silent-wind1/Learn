package com.yefeng.thread.method;

public class TestJoin implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 300; i++) {
            System.out.println("VIP来了" + i);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        TestJoin testJoin = new TestJoin();
        Thread thread = new Thread(testJoin);
        thread.start();

        for (int i = 0; i < 205; i++) {
            // 如果i等于200，main方法就结束了，而子线程还没运行完，使用join等待这个线程结束
            if (i == 200) {
                thread.join();
            }
            System.out.println("main" + i);
        }
    }
}
