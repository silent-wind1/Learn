package com.yefeng.str;

import cn.hutool.json.JSONUtil;
import com.yefeng.demo.study.dto.GoodItems;

/**
 * Json转换成对象
 */
public class JsonToObject {
    public static void main(String[] args) {
        String json = "{\"goodId\":\"123456\"}";
        GoodItems goodItems = JSONUtil.toBean(json, GoodItems.class);
        System.out.println(goodItems.getGoodId());
    }
}
