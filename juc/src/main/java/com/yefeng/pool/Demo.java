package com.yefeng.pool;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.CompletableFuture;

/**
 * @Author: 叶枫
 * @Date: 2024/12/27/21:14
 * @Description:
 */
public class Demo {
    public static void main(String[] args) {
        CompletableFuture future = CompletableFuture.supplyAsync(()->{
            System.out.println("投放和清洗制作米饭的材料");
            return "干净的没有新冠病毒的大米";
        }).thenAcceptAsync(result->{
            System.out.println("通电，设定模式，开始煮米饭");
        }).thenRunAsync(()->{
            System.out.println("米饭做好了，可以吃了");
        });

        // 获取当前日期
        LocalDate currentDate = LocalDate.now();
        // 格式化日期为 "YYYY-MM" 格式
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM");
        String formattedDate = currentDate.format(formatter);

        // 输出结果
        System.out.println("当前日期: " + formattedDate);
    }
}
