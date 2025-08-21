package com.yefeng.statemachine.service;

import jakarta.servlet.http.HttpServletResponse;

public interface FileService {
    void downloadZip(HttpServletResponse response);
}
