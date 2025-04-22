package com.yefeng.thread.method.entity;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ThreadA extends Thread {

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            String time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS").format(new Date());
            System.out.println(time + " 当前线程：" + Thread.currentThread().getName() + "，正在运行");
        }
    }
}