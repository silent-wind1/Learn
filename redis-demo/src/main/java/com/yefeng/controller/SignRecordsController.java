package com.yefeng.controller;

import com.yefeng.service.SignRecordsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.time.LocalDateTime;

/**
 * @Author: 叶枫
 * @Date: 2025/05/22/15:19
 * @Description:
 */
@RestController
@RequestMapping("/sign-records/")
public class SignRecordsController {
    @Resource
    private SignRecordsService signRecordsService;

    @GetMapping("add")
    public void addSignRecords(){
        String userId = "1234";
        LocalDateTime current_time = LocalDateTime.now();
        signRecordsService.addSignRecords(userId,current_time.toString());
    }
}
