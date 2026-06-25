package com.yefeng.thread.create;

/**
 * @author wind
 * @description:
 * @date 2026/6/25 16:07
 */
public class PhoneDemo {

    public static void main(String[] args) {
        Phone phone = new Phone();
        new Thread(() -> {
            phone.send();
        }, "wind").start();
        new Thread(()-> {
            phone.call();
        }, "aurora").start();
    }

}
