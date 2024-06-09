package com.yefeng.structure.proxy.static_proxy;

/**
 * @author: yefeng 
 * @description: 测试类
 * @date: 2023/12/13 15:14
 * @version: 1.0
 */
public class Client {
    public static void main(String[] args) {
        ProxyPoint proxyPoint = new ProxyPoint();
        proxyPoint.sell();
        System.out.println(proxyPoint.getClass().getClassLoader());
        System.out.println(proxyPoint.getClass().getInterfaces());
    }
}
