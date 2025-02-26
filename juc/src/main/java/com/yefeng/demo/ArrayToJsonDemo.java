package com.yefeng.demo;

import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONUtil;

public class ArrayToJsonDemo {
    public static void main(String[] args) {
        String arrayImg = "[\"F_1894687464601227264\",\"F_1894678794367328256\",\"F_1894681772188475392\",\"F_1894687464345374720\",\"F_1894687464475398144\"]";
        JSONArray objects = JSONUtil.parseArray(arrayImg);
        for (Object object : objects) {
            System.out.println(object.toString());
        }
    }
}
