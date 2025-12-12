package com.yefeng.thread.create;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * 弥补了调用线程没有返回值的情况
 */
public class TestCallableAndFuture implements Callable<String> {

    public static void main(String[] args) throws Exception {
        Callable<String> callable = new TestCallableAndFuture();
        FutureTask<String> ft = new FutureTask<>(callable);
        FutureTask<String> lt = new FutureTask<>(callable);
        FutureTask<String> now = new FutureTask<>(callable);
        new Thread(ft, "未来").start();
        new Thread(lt, "过去").start();
        new Thread(now, "现在").start();
        // 使用 JDK 8 的 Lambda 创建线程
        new Thread(() -> System.out.println(Thread.currentThread().getName() + "在运行！")).start();

    }

    @Override
    public String call() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + "running");
        }
        return Thread.currentThread().getName();
    }
}
