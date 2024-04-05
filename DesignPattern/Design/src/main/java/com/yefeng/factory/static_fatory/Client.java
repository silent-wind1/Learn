package com.yefeng.factory.static_fatory;

import com.yefeng.factory.before.Coffee;
import com.yefeng.factory.before.CoffeeStore;

/**
 * 静态工厂模式
 */
public class Client {
    public static void main(String[] args) {
        CoffeeStore coffeeStore = new CoffeeStore();
        Coffee coffee = coffeeStore.orderCoffee("latte");
        System.out.println(coffee.getName());
    }
}
