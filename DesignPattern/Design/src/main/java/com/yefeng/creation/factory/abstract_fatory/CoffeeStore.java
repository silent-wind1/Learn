package com.yefeng.creation.factory.abstract_fatory;


import com.yefeng.creation.factory.sinple_fatory.Coffee;

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
