package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class ScheduleService {
//    在一个特定的时间执行这个方法~ Timer
//    秒 分 时 日 月 周几~
    @Autowired
    AsyncService asyncService;

    @Scheduled(cron = "0/1   * * * * ?")
    public void hello() {
        System.out.println("hello");
        asyncService.hello();
    }
}
