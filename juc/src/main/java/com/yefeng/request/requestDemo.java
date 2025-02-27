package com.yefeng.request;

import cn.hutool.http.HttpUtil;

public class requestDemo {
    public static void main(String[] args) {
        String url = "http://rpa.bosc-platform.com:8888/rpa/taxApply/123" + "?code=" + "code";
        String response = HttpUtil.get(url);
        if (response == null) {
            System.out.println("请求失败");
        }
        System.out.println(response);




    }
}
