package com.yefeng.factory.sinple_fatory;


/**
 * 咖啡工厂
 */
public class CoffeeStore {
    public Coffee orderCoffee(String type) {
        SimpleCoffeeFactory simpleCoffeeFactory = new SimpleCoffeeFactory();
        Coffee coffee = simpleCoffeeFactory.createCoffee(type);
        coffee.addSugar();
        coffee.addMilk();
        return coffee;
    }
}
