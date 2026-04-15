package com.yefeng.utils;

import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
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
        Files.copy(file.toPath(), dest.toPath());
        log.info("文件保存成功: {} -> {}", originalFilename, dest.getAbsolutePath());
        return dest.getAbsolutePath();
    }

    public static void main(String[] args) {
        FileUtils fileUtils = new FileUtils();

        // 创建测试文件
        File testFile = new File("test.txt");
        try {
           Files.writeString(testFile.toPath(), "Hello, this is a test file.");

            // 测试保存文件
            String savedPath = fileUtils.saveFileToLocal(testFile, "F:/temp/upload");
            System.out.println("文件已保存到: " + savedPath);

            // 验证文件是否存在
            File savedFile = new File(savedPath);
            if (savedFile.exists()) {
                System.out.println("文件保存成功！");
                System.out.println("文件大小: " + savedFile.length() + " bytes");
                System.out.println("文件内容: " + Files.readString(savedFile.toPath()));
            }

            // 清理测试文件
            testFile.delete();
        } catch (IOException e) {
            System.err.println("文件保存失败: " + e.getMessage());
            e.printStackTrace();
        }
    }

}
