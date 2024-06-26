package com.yefeng.structure.proxy.jdk_proxy;

import com.yefeng.structure.proxy.static_proxy.SellTickets;
import com.yefeng.structure.proxy.static_proxy.TrainStation;

import java.lang.reflect.Proxy;

public class ProxyFactor {
    private final TrainStation trainStation = new TrainStation();

    public SellTickets getProxyObject() {
        return (SellTickets) Proxy.newProxyInstance(
                trainStation.getClass().getClassLoader(),
                trainStation.getClass().getInterfaces(),
                (proxy, method, args) -> {
                    System.out.println("帮你写可以啊，但是要给小费哦~");
                    Object invoke = method.invoke(trainStation, args);
                    System.out.println("东西写好了，但是还需要交点加班费");
                    return invoke;
                }
        );
    }
}
