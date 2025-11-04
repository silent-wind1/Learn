package com.yefeng.json;

public class JsonConversionExample {
    
    public static void main(String[] args) {
        String json = "{\n" +
                "  \"conditions\": {\n" +
                "    \"min_star_rating\": 2,\n" +
                "    \"performance_threshold\": 0.5\n" +
                "  },\n" +
                "  \"reward_tiers\": [\n" +
                "    {\n" +
                "      \"min_quantity\": 5000,\n" +
                "      \"unit_price\": 1\n" +
                "    },\n" +
                "    {\n" +
                "      \"min_quantity\": 10000,\n" +
                "      \"unit_price\": 2\n" +
                "    },\n" +
                "    {\n" +
                "      \"min_quantity\": 50000,\n" +
                "      \"unit_price\": 3\n" +
                "    },\n" +
                "    {\n" +
                "      \"min_quantity\": 150000,\n" +
                "      \"unit_price\": 4\n" +
                "    },\n" +
                "    {\n" +
                "      \"min_quantity\": 400000,\n" +
                "      \"unit_price\": 5\n" +
                "    }\n" +
                "  ]\n" +
                "}";

        // 使用您的工具类进行转换
        AwardRule awardRule = JsonUtils.fromJson(json, AwardRule.class);
        
        // 输出转换结果
        System.out.println("转换结果:");
        System.out.println(awardRule);
        
        // 访问具体字段
        System.out.println("\n详细字段:");
        System.out.println("最低星级要求: " + awardRule.getConditions().getMinStarRating());
        System.out.println("业绩阈值: " + awardRule.getConditions().getPerformanceThreshold());
        
        System.out.println("\n奖励阶梯:");
        for (RewardTier tier : awardRule.getRewardTiers()) {
            System.out.println("销量≥" + tier.getMinQuantity() + "盒，单价:" + tier.getUnitPrice() + "元");
        }
        
        // 反向转换测试
        String backToJson = JsonUtils.toJson(awardRule);
        System.out.println("\n反向转换JSON:");
        System.out.println(backToJson);
    }
}