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
        
        System.out.println("\n奖励阶梯:");
        long total = 50001;
        for (RewardTier tier : awardRule.getRewardTiers()) {
            if(total >= tier.getMinQuantity()){
                System.out.println("最低数量: " + tier.getMinQuantity() + ", 单价: " + tier.getUnitPrice());
            } else {
                System.out.println("退出循环了");
                break;
            }
        }

    }
}