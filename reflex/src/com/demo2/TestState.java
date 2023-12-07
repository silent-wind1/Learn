package com.demo2;

public class TestState {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("////");
        });

//        观察状态
        Thread.State state = thread.getState();
        System.out.println(state); // New

//        观察启动后
        thread.start(); // 启动线程
        state = thread.getState();
        System.out.println(state); // Run

        while (state != Thread.State.TERMINATED) {
            Thread.sleep(100);
            state = thread.getState(); // 更新线程状态
            System.out.println(state); // 输出状态
        }
    }
}
