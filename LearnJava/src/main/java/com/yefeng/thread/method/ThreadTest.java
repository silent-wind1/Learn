package com.yefeng.thread.method;

import com.yefeng.thread.method.entity.ThreadA;
import com.yefeng.thread.method.entity.ThreadB;

public class ThreadTest {

    public static void main(String[] args) {
        ThreadA threadA = new ThreadA();
        ThreadB threadB = new ThreadB();

        // 线程默认优先级为 5，如果不手动指定，那么线程优先级具有继承性
        threadA.setPriority(10);
        threadA.start();
        threadB.setPriority(1);
        threadB.start();

        // 如果单独调用run()方法，不能启动线程，会像调用普通的成员方法一样
//        threadA.run();
//        threadB.run();
    }
}