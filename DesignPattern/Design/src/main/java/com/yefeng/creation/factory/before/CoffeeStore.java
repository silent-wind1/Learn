package com.yefeng.creation.factory.before;

/**
 * 咖啡工厂
 */
public class CoffeeStore {
    public Coffee orderCoffee(String type) {
        Coffee coffee = null;
        if(type.equals("american")) {
            coffee = new AmericanCoffee();
        }else if (type.equals("latte")) {
            coffee = new LatteCoffee();
        }
        coffee.addMilk();
        coffee.addSugar();
        return coffee;
    }
}
