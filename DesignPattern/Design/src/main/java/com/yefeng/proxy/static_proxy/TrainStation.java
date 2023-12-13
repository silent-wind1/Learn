package com.yefeng.proxy.static_proxy;

/**
 * @author: yefeng
 * @date: 2023/12/13 14:57
 * @description: 火车类
 * @version: 1.0
 */
public class TrainStation implements SellTickets{
    @Override
    public void sell() {
        System.out.println("火车站买票");
    }
}
