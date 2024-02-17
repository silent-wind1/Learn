package com.yefeng.thread.method;

public class TestThreadMethod {
    public static void ConstructionMethod() {
        // 常见的构造方法
        Thread thread = new Thread( new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        });
        thread.start();

        // 使用lambda表达式
        Thread lambda = new Thread(() -> System.out.println(Thread.currentThread().getName()));
        lambda.start();

        // 给一个线程指定名称
        Thread thread1 = new Thread( new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        }, "yefeng");
        thread1.start();

        // 创建一个线程组实例
        ThreadGroup tg = new ThreadGroup("线程组1");
        // 创建一个线程实例
        Thread thread2 = new Thread(tg,new Runnable() {

            @Override
            public void run() {
                // 如果不显式指定线程组，JVM 会将创建的线程归到当前线程所属的线程组中。
                System.out.println(Thread.currentThread().getThreadGroup().getName() + "：" + Thread.currentThread().getName());
            }
        }, "thread-demo");
        thread2.start();
    }

    public static void main(String[] args) {
        ConstructionMethod();
    }
}
