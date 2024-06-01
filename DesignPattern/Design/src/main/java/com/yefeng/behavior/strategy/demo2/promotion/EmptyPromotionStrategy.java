package com.yefeng.behavior.strategy.demo2.promotion;

/**
 * 空的促销策略
 * 为了防止空指针
 */
public class EmptyPromotionStrategy implements PromotionStrategy {
    @Override
    public void doPromotion() {
        System.out.println("原价出售");
    }
}
