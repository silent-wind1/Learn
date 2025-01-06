package com.yefeng.web.controller;

import com.yefeng.web.config.AliyunApiConfig;
import org.apache.http.HttpResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author: 叶枫
 * @Date: 2024/12/11/21:36
 * @Description:
 */
@RestController
@RequestMapping("/card")
public class CardController {
    @Resource
    private AliyunApiConfig aliyunApiConfig;

    @GetMapping("/getInfo")
    public String getInfo(@RequestParam("name") String name, @RequestParam String idCard) {
        // 调用阿里云身份证验证功能
        HttpResponse response = AliyunHttpUtils.VerificationIdCard(aliyunApiConfig.getAppcode(), parameterMap.get("realName").toString(), parameterMap.get("idCard").toString());
        //获取response的body
        ApiResponse apiResponse = AliyunHttpUtils.JsonToJavaBean(response);
        return null;
    }
}
