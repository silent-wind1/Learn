package com.yefeng.thread.method;

public class TestStop implements Runnable {
    private boolean flag = true;

    public static void main(String[] args) {
        TestStop testStop = new TestStop();
        new Thread(testStop).start();
        for (int i = 0; i < 100000; i++) {
            if (i == 99999) {
//              调用stop方法切换标志位，让线程停止
                testStop.stop();
                System.out.println("线程该停止了");
            }

        }
    }

    @Override
    public void run() {
        int i = 0;
        while (flag) {
            System.out.println("run.....Thread" + i++);
        }
    }

    public void stop() {
        this.flag = false;
    }
}
