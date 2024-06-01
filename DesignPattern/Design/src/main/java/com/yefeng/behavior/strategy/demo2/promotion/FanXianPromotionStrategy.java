package com.yefeng.behavior.strategy.demo2.promotion;

/**
 * 返现促销策略
 * 购买后返优惠券
 */
public class FanXianPromotionStrategy implements PromotionStrategy {

    @Override
    public void doPromotion() {
        System.out.println("返现促销 , 返优惠券 10 元");
    }
}
