package com.yefeng.demo;

import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONUtil;

import java.util.ArrayList;
import java.util.List;

public class ArrayToJsonDemo {
    public static void main(String[] args) {
        String invoiceIds = "[\"F_1894687464601227264\",\"F_1894678794367328256\",\"F_1894681772188475392\",\"F_1894687464345374720\",\"F_1894687464475398144\"]";
        JSONArray objects = JSONUtil.parseArray(invoiceIds);
        List<String> news = new ArrayList<>();
        List<String> olds = new ArrayList<>();
        // F_开头表示旧图片id
        for (Object s : objects) {
            String value = s.toString();
            if (value.startsWith("F_")) {
                olds.add(value.replace("F_", ""));
            } else {
                news.add(value);
            }
        }
        List<String> list = new ArrayList<>();
        list.add("1894687464601227264");
        list.add("1894678794367328256");

        for (String tinvoiceFile : list) {
            if(!olds.contains(tinvoiceFile)) {
                System.out.println("进行删除操作");
            }
        }
    }
}
