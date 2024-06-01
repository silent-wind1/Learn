package com.yefeng.behavior.strategy.demo2.promotion;

/**
 * 满减促销策略
 *      满 100 减 20
 */
public class ManJianPromotionStrategy implements PromotionStrategy {

    @Override
    public void doPromotion() {
        System.out.println("满减促销 , 满 100 减 20");
    }
}
