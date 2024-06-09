package com.yefeng.behavior.strategy.demo2.promotion;

/**
 * 促销策略接口
 * 所有的促销策略 , 都要实现该接口
 */
public interface PromotionStrategy {
    /**
     * 促销活动
     */
    void doPromotion();
}