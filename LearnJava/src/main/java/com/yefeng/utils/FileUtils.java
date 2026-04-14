package com.yefeng.utils;

import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;

/**
 * @author wind
 * @description:
 * @date 2026/4/14 22:40
 */
@Slf4j
public class FileUtils {

    /**
     * 保存文件到指定路径，按年月日树形结构保存
     *
     * @param file     待保存的文件
     * @param basePath 基础保存路径
     * @return 保存后的文件绝对路径
     * @throws IOException 如果创建目录失败或文件保存失败
     */
    public String saveFileToLocal(File file, String basePath) throws IOException {
        LocalDateTime now = LocalDateTime.now();
        String year = String.valueOf(now.getYear());
        String month = String.format("%02d", now.getMonthValue());
        String day = String.format("%02d", now.getDayOfMonth());

        File dir = new File(basePath, year + File.separator + month + File.separator + day);
        if (!dir.exists() && !dir.mkdirs()) {
            throw new IOException("创建上传目录失败: " + dir.getAbsolutePath());
        }

        String originalFilename = file.getName();
        String extension = "";
        if (originalFilename.contains(".")) {
            extension = originalFilename.substring(originalFilename.lastIndexOf("."));
        }

        // 文件名格式: yyyyMMddHHmmss + 原始扩展名
        String savedName = String.format("%04d%02d%02d%02d%02d%02d", now.getYear(), now.getMonthValue(), now.getDayOfMonth(), now.getHour(), now.getMinute(), now.getSecond()) + extension;

        File dest = new File(dir, savedName);
        java.nio.file.Files.copy(file.toPath(), dest.toPath());
        log.info("文件保存成功: {} -> {}", originalFilename, dest.getAbsolutePath());
        return dest.getAbsolutePath();
    }

}
