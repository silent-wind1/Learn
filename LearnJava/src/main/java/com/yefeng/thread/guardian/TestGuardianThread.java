package com.yefeng.thread.guardian;

/**
 * 守护线程: 如果所有的前台线程都死亡，后台线程会自动死亡。当整个JVM中只存在后台线程，那么程序就没有运行的必要了，整个JVM就退出了。
 */
public class TestGuardianThread {
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(1000);

                } catch (Exception e) {
                    // TODO: handle exception
                }
                System.out.println("我是子线程(用户线程)");
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
