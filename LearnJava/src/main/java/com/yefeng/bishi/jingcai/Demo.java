package com.yefeng.bishi.jingcai;

/**
 * 深圳彩京笔试题
 * @Author: 叶枫
 * @Date: 2025/04/22/20:48
 * @Description: 考点在于run()是普通方法调用
 */
public class Demo {
    public static void main(String[] args) {
        Thread thread = new Thread() {
            public void run() {
                pong();
            }
        };

        // 根本没有开新线程 所以 pong() 会在当前主线程里先执行完，然后再打印 ping。
        thread.run();
        System.out.print("ping");
        System.out.println(thread.getPriority()); // 返回线程的优先级
    }

    private static void pong() {
        System.out.print("pong");
    }
}
