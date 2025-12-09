package com.yefeng.crawler;

import cn.hutool.json.JSONUtil;
import com.yefeng.crawler.entity.SurveyResponse;

public class ApiDemo {
    public static void main(String[] args) {
        try {
            // 使用OkHttp
            OkHttpApiCaller okHttpCaller = new OkHttpApiCaller();
            int i = 10000;
            while (i < 15635) {
                String url = String.format("https://dm.njcedu.com/prs/answer/getTemplateGuidanceById?id=%s", i);
                String result = okHttpCaller.get(url);
                if(result == null) {
                    i++;
                    continue;
                }
                SurveyResponse bean = JSONUtil.toBean(result, SurveyResponse.class);
                if(bean.getCode() == 0) {
                    System.out.println(url);
                    System.out.println("学校名称为: " + bean.getResult().getTemplateName());
                }
                i++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
