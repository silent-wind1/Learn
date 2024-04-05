package com.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class AsyncService {
    //  告诉Spring这是一个异步方法
    @Async
    public void hello() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.fillInStackTrace();
        }
        System.out.println("数据处理总.....");
    }
}
