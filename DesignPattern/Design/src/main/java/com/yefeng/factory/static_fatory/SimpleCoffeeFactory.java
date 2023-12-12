package com.yefeng.factory.static_fatory;

import com.yefeng.factory.sinple_fatory.AmericanCoffee;
import com.yefeng.factory.sinple_fatory.Coffee;
import com.yefeng.factory.sinple_fatory.LatteCoffee;

public class SimpleCoffeeFactory {

    public static Coffee createCoffee(String type) {
        Coffee coffee = null;
        if("americano".equals(type)) {
            coffee = new AmericanCoffee();
        } else if("latte".equals(type)) {
            coffee = new LatteCoffee();
        }
        return coffee;
    }
}