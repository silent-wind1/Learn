package com.yefeng.structure.proxy.jdk_proxy;

import com.yefeng.structure.proxy.static_proxy.SellTickets;

public class Client {
    public static void main(String[] args) {
        ProxyFactor proxyFactor = new ProxyFactor();
        SellTickets sellTickets = proxyFactor.getProxyObject();
        sellTickets.sell();
    }
}
