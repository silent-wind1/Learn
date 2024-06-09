package com.yefeng.structure.proxy.static_proxy;

/**
 * @author: yefeng 
 * @date: 2023/12/13 15:06
 * @description: 代理点类
 * @version: 1.0
 */
public class ProxyPoint implements SellTickets {
    private TrainStation trainStation = new TrainStation();
    @Override
    public void sell() {
        System.out.println("这里是协程为你抢票哦~请开会员享受加油包");
        trainStation.sell();
    }
}
