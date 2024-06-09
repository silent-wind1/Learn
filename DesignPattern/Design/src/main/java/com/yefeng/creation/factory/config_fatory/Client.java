package com.yefeng.creation.factory.config_fatory;


public class Client {
    public static void main(String[] args) {
        Coffee coffee = CoffeeFactory.createCoffee("latte");
        System.out.println(coffee.getName());
    }
}
