package com.yefeng.behavior.template;

public class Main {
    public static void main(String[] args) {
        // 把大象放到冰箱
        Fridge elephantFridge = new ElephantFridge();
        elephantFridge.store();

        System.out.println();

        // 把鱼放到冰箱
        Fridge fishFridge = new FishFridge();
        fishFridge.store();
    }
}