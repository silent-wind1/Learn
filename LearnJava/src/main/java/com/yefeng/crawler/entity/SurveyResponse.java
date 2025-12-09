package com.yefeng.crawler.entity;

import lombok.Data;

@Data
public class SurveyResponse {
    private int code;
    private String error;
    private SurveyResult result;
    private Object total;  // 使用Object类型，因为可能是null
    private int succ;
}