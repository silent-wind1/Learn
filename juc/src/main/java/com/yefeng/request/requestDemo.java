package com.yefeng.request;

import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;

public class requestDemo {
    public static void main(String[] args) {
        String url = "http://rpa.bosc-platform.com:8888/rpa/getMsg/123?type=code";
        String response = HttpUtil.get(url);
//        response = null;
        JSONObject jsonObject = JSONUtil.parseObj(response);
        if(jsonObject.isEmpty()) {
            System.out.println("json 为空");
        }
        if (response == null) {
            System.out.println("请求失败");
        }
        System.out.println(response);




    }
}
