package com.yefeng.factory.static_fatory;


import com.yefeng.factory.sinple_fatory.Coffee;

/**
 * 咖啡工厂
 */
public class CoffeeStore {
    public Coffee orderCoffee(String type) {
        Coffee coffee = SimpleCoffeeFactory.createCoffee(type);
        coffee.addSugar();
        coffee.addMilk();
        return coffee;
    }
}
