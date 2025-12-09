package com.yefeng.crawler.entity;

import lombok.Data;

@Data
public class SurveyResult {
    private String templateName;
    private String templateGuidance;
    private String skin;
    private boolean answerAgain;
}