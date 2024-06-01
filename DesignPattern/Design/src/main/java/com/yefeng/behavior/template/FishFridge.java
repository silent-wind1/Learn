package com.yefeng.behavior.template;

public class FishFridge extends Fridge {
    @Override
    void put() {
        System.out.println("把鱼放进冰箱");
    }

    @Override
    protected boolean needColdStorage() {
        // 需要冷藏存储
        return true;
    }
}