package com.yefeng.guardian;

public class TestGuardianThread {
    public static void main(String[] args) {
        Thread t1 = new Thread(new Runnable() {

            public void run() {
                while (true) {
                    try {
                        Thread.sleep(1000);

                    } catch (Exception e) {
                        // TODO: handle exception
                    }
                    System.out.println("我是子线程(用户线程)");
                }
            }
        });
        // 标识当前方法为守护线程，一定要在启动线程前设置为守护线程
        t1.setDaemon(true);
        //启动线程
        t1.start();

        //相当与主线程
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(300);
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("main:i:" + i);
        }
        System.out.println("主线程执行完毕...");
    }
}
