package com.yefeng.behavior.strategy.demo2;

import com.yefeng.behavior.strategy.demo2.promotion.PromotionStrategy;

/**
 * 促销活动
 */
public class PromotionActivity {
    /**
     * 促销策略 , 通过构造器注入
     */
    private PromotionStrategy promotionStrategy;

    public PromotionActivity(PromotionStrategy promotionStrategy) {
        this.promotionStrategy = promotionStrategy;
    }

    /**
     * 执行促销策略
     */
    public void executePromotionStrategy() {
        this.promotionStrategy.doPromotion();
    }
}
