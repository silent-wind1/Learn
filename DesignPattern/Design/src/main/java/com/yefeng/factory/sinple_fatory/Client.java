package com.yefeng.factory.sinple_fatory;

import com.yefeng.factory.before.Coffee;
import com.yefeng.factory.before.CoffeeStore;

/**
 * 简单工厂模式
 */
public class Client {
    public static void main(String[] args) {
        com.yefeng.factory.before.CoffeeStore coffeeStore = new CoffeeStore();
        Coffee coffee = coffeeStore.orderCoffee("latte");
        System.out.println(coffee.getName());
    }
}
