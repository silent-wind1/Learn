package com.yefeng.statemachine.service.impl;

import com.yefeng.statemachine.service.FileService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.File;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * @author wind
 * @description:
 * @date 2025/8/21 19:59
 */
@Slf4j
@Service
public class FileServiceImpl implements FileService {
    @Override
    public void downloadZip(HttpServletResponse response) {
        List<String> fileList = List.of("1.png", "2.jpg", "3.png", "4.png", "5.png", "Java-本科.pdf");
        // 生成带日期的文件名
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
        String fileName = "file_" + timestamp + ".zip";
        // 对文件名进行处理编码（处理中文）
        String encode = URLEncoder.encode(fileName, StandardCharsets.UTF_8).replaceAll("\\+", "%20");
        // 设置响应头
        response.setContentType("application/zip");
        response.setHeader("Content-Disposition", "attachment; filename=\"" + encode + "\"");
        // 创建zip文件
        try (ZipOutputStream zipOut = new ZipOutputStream(response.getOutputStream())) {
            for (String filePath : fileList) {
                filePath = "H:/file" + File.separator + filePath;
                File file = new File(filePath);
                if (file.exists() && !file.isDirectory()) {
                    // 使用原始文件名
                    zipOut.putNextEntry(new ZipEntry(file.getName()));
                    // 复制文件内容
                    Files.copy(file.toPath(), zipOut);
                    zipOut.closeEntry();
                }
            }
            // 确保所有数据写入
            zipOut.finish();
        } catch (Exception e) {
            log.error("downloadZip error:{}", e.getMessage());
        }
    }
}
