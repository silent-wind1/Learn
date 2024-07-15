package com.yefeng.database;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author: 叶枫
 * @Date: 2024/06/16/20:41
 * @Description: 数据源上下文类
 */
@Slf4j
public class DBContext {
    private static final ThreadLocal<DBTypeEnum> dbContext = new ThreadLocal<>();
    private static final AtomicInteger counter = new AtomicInteger(-1);
    public static void set(DBTypeEnum dbType) {
        dbContext.set(dbType);
    }

    public static DBTypeEnum get() {
        log.info("dbContext==>{}", dbContext.get());
        return dbContext.get();
    }

    public static void master() {
        set(DBTypeEnum.MASTER);
        log.info("切换到master库");
    }

    public static void slave() {
        //  读库负载均衡(轮询方式)
        int index = counter.getAndIncrement() % 2;
        log.info("slave库访问线程数==>{}", counter.get());
        if (counter.get() > 9999) {
            counter.set(-1);
        }
        if (index == 0) {
            set(DBTypeEnum.SLAVE1);
            log.info("切换到SLAVE1库");
        } else {
            set(DBTypeEnum.SLAVE2);
            log.info("切换到SLAVE2库");
        }
    }
}


