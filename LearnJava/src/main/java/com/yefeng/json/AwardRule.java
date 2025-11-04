package com.yefeng.json;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/**
 * 奖励规则主对象
 */
public class AwardRule {
    @SerializedName("conditions")
    private Conditions conditions;
    
    @SerializedName("reward_tiers")
    private List<RewardTier> rewardTiers;

    // 构造方法
    public AwardRule() {}
    
    public AwardRule(Conditions conditions, List<RewardTier> rewardTiers) {
        this.conditions = conditions;
        this.rewardTiers = rewardTiers;
    }

    // Getter和Setter
    public Conditions getConditions() {
        return conditions;
    }

    public void setConditions(Conditions conditions) {
        this.conditions = conditions;
    }

    public List<RewardTier> getRewardTiers() {
        return rewardTiers;
    }

    public void setRewardTiers(List<RewardTier> rewardTiers) {
        this.rewardTiers = rewardTiers;
    }

    @Override
    public String toString() {
        return "AwardRule{" +
                "conditions=" + conditions +
                ", rewardTiers=" + rewardTiers +
                '}';
    }
}

/**
 * 条件对象
 */
class Conditions {
    @SerializedName("min_star_rating")
    private int minStarRating;
    
    @SerializedName("performance_threshold")
    private double performanceThreshold;

    // 构造方法
    public Conditions() {}
    
    public Conditions(int minStarRating, double performanceThreshold) {
        this.minStarRating = minStarRating;
        this.performanceThreshold = performanceThreshold;
    }

    // Getter和Setter
    public int getMinStarRating() {
        return minStarRating;
    }

    public void setMinStarRating(int minStarRating) {
        this.minStarRating = minStarRating;
    }

    public double getPerformanceThreshold() {
        return performanceThreshold;
    }

    public void setPerformanceThreshold(double performanceThreshold) {
        this.performanceThreshold = performanceThreshold;
    }

    @Override
    public String toString() {
        return "Conditions{" +
                "minStarRating=" + minStarRating +
                ", performanceThreshold=" + performanceThreshold +
                '}';
    }
}

/**
 * 奖励阶梯对象
 */
class RewardTier {
    @SerializedName("min_quantity")
    private int minQuantity;
    
    @SerializedName("unit_price")
    private int unitPrice;

    // 构造方法
    public RewardTier() {}
    
    public RewardTier(int minQuantity, int unitPrice) {
        this.minQuantity = minQuantity;
        this.unitPrice = unitPrice;
    }

    // Getter和Setter
    public int getMinQuantity() {
        return minQuantity;
    }

    public void setMinQuantity(int minQuantity) {
        this.minQuantity = minQuantity;
    }

    public int getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(int unitPrice) {
        this.unitPrice = unitPrice;
    }

    @Override
    public String toString() {
        return "RewardTier{" +
                "minQuantity=" + minQuantity +
                ", unitPrice=" + unitPrice +
                '}';
    }
}