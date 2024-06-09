package com.yefeng.behavior.strategy.demo2;

import com.yefeng.behavior.strategy.demo2.factory.PromotionStrategyFactory;
import com.yefeng.behavior.strategy.demo2.promotion.PromotionStrategy;

public class Main {
    public static void main(String[] args) {
        // 获取促销策略
        PromotionStrategy promotionStrategy = PromotionStrategyFactory.getPromotionStrategy(PromotionStrategyFactory.PromotionKey.FANXIAN);
        // 创建促销活动 , 并执行促销策略
        PromotionActivity promotionActivity = new PromotionActivity(promotionStrategy);
        // 执行促销策略
        promotionActivity.executePromotionStrategy();
    }
}
