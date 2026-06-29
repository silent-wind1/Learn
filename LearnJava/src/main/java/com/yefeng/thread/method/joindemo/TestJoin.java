package com.yefeng.thread.method.joindemo;


/**
 *  join: 把某一个线程加入到当前线程的执行流程中。
 *  当某一个程序执行流中调用了其他线程的join()方法，调用线程暂停执行，直到被join()方法加入的join线程执行完成为止。
 */
public class TestJoin implements Runnable {
    public static void main(String[] args) throws InterruptedException {
        TestJoin testJoin = new TestJoin();
        Thread thread = new Thread(testJoin);
        thread.start();

        for (int i = 0; i < 205; i++) {
            // 如果i等于200，main方法就结束了，而子线程还没运行完，使用join等待这个线程结束
            if (i == 200) {
                //  join 方法会等待线程结束
                thread.join();
            }
            System.out.println("main" + i);
        }
    }

    @Override
    public void run() {
        for (int i = 0; i < 300; i++) {
            System.out.println("VIP来了" + i);
        }
    }
}
