package com.yefeng.statemachine.controller;

import com.yefeng.statemachine.service.FileService;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wind
 * @description:
 * @date 2025/8/21 19:59
 */
@RestController
@RequestMapping("/file")
public class FileController {
    @Resource
    private FileService fileService;
    @PostMapping("/download-zip")
    public void downloadZip(HttpServletResponse response) {
        fileService.downloadZip(response);
    }
}
