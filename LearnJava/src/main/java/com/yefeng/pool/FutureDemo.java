package com.yefeng.pool;

import java.util.concurrent.*;

/**
 * @author 叶枫
 * @version 1.0
 * @date 2024/10/2 1:47
 * @description:
 */
public class FutureDemo {
    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                2,
                5,
                10L,
                TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<>(10));
        // 创建异步执行任务:
        CompletableFuture<String> cf = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("task started...");
            return "执行成功";
        });
        // 如果执行成功:
        cf.thenAccept((result) -> {
            System.out.println("price: " + result);
        });

        Future<String> future = executor.submit(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println("i = " + i);
            }
            return "执行成功";
        });
        try {

            for (int i = 0; i < 10; i++) {
                System.out.println("j = " + i);
            }
            String s = future.get();
            System.out.println(s);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        executor.shutdown();
    }
}
