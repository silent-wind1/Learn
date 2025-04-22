package com.yefeng.thread.create;

// 多个线程同时操作同一个对象
// 买火车票的例子
public class TestThreadBuyTicket implements Runnable {
    private int tickNumber = 10; // 票数

    public static void main(String[] args) {
        TestThreadBuyTicket testThread4 = new TestThreadBuyTicket();
        new Thread(testThread4, "小明").start();
        new Thread(testThread4, "teacher").start();
        new Thread(testThread4, "黄牛").start();
    }

    @Override
    public void run() {
        while (true) {
            if (tickNumber <= 0) {
                break;
            }
//            模拟延时
            try {
                Thread.sleep(200);
            } catch (Exception ex) {
                ex.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName() + "拿到了" + tickNumber-- + "票");
        }
    }
}