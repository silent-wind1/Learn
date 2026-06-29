package com.yefeng.thread.method.joindemo;

/**
 * @author wind
 * @description: 用两个线程，一个输出字母，一个输出数字，交替输出 1A2B3C4D...26Z
 *
 * 【实现思路】
 *  join() 的语义是"等目标线程执行完"，本方案利用这一特性实现两个线程的严格交替：
 *  - 主线程每轮创建 2 个新线程
 *  - 数字线程先 start + join（必须等它跑完才能继续）
 *  - 字母线程再 start + join（必须等它跑完才能进入下一轮）
 *  这样从时间维度上锁死了"先数字后字母"的执行顺序。
 *
 * 【输出】
 *  1A2B3C4D5E6F7G8H9I10J11K12L13M14N15O16P17Q18R19S20T21U22V23W24X25Y26Z
 *
 * 【为什么不用 synchronized + wait/notify】
 *  原始版本试图用 synchronized(this) + notifyAll 协调两个长生命周期线程，
 *  但存在三个致命 bug：
 *  1. 每次循环都 new 一个新实例，synchronized(this) 锁的是不同对象，互斥失效
 *  2. notifyAll 没有对应的 wait()，唤醒了一个根本不存在的等待者
 *  3. 没有任何状态标志位标记"轮到谁打印"
 *
 * 【优缺点】
 *  ✅ 优点：逻辑最直白，绝对不会出现乱序
 *  ❌ 缺点：每轮创建 2 个线程，26 轮共 52 个短生命周期线程，开销较大
 *  💡 替代方案：wait/notify 或 ReentrantLock+Condition 可用 2 个长生命周期线程实现
 *
 * @date 2026/6/29 15:29
 */
public class Print1A2B3CUsingJoin {

    public static void main(String[] args) {
        // 循环 26 轮，每轮打印一对"数字 + 字母"
        for (int i = 0; i < 26; i++) {
            try {
                // 数字从 1 开始（题目要求 1A2B...），字母从 'A' 开始
                int num = i + 1;
                char c = (char) ('A' + i);

                // ========== 第 1 步：启动数字线程并 join 等待 ==========
                Thread t1 = new Thread(() -> System.out.print(num));
                t1.start();
                // 等数字线程打印完，主线程在此阻塞
                t1.join();

                // ========== 第 2 步：启动字母线程并 join 等待 ==========
                Thread t2 = new Thread(() -> System.out.print(c));
                t2.start();
                // 等字母线程打印完，主线程在此阻塞
                t2.join();
            } catch (InterruptedException e) {
                // join 期间主线程被中断时，恢复中断标志并抛运行时异常
                Thread.currentThread().interrupt();
                throw new RuntimeException(e);
            }
        }
    }
}
