package com.yefeng.utils;

import java.io.File;

/**
 * 删除指定目录下，文件名称带有（1）的图片文件
 */
public class DeleteDuplicatePhotos {
    public static void main(String[] args) {

        String directoryPath = "I:\\照片\\回忆录";
        File directory = new File(directoryPath);

        if (!directory.exists() || !directory.isDirectory()) {
            System.out.println("目录不存在或不是有效的目录: " + directoryPath);
            System.exit(1);
        }

        File[] files = directory.listFiles();
        if (files == null) {
            System.out.println("无法读取目录内容");
            System.exit(1);
        }

        int deletedCount = 0;
        int totalCount = 0;

        for (File file : files) {
            if (file.isFile()) {
                String fileName = file.getName();
                if (fileName.contains("(1)") && isImageFile(fileName)) {
                    totalCount++;
                    if (file.delete()) {
                        System.out.println("已删除: " + fileName);
                        deletedCount++;
                    } else {
                        System.out.println("删除失败: " + fileName);
                    }
                }
            }
        }

        System.out.println("\n总计找到 " + totalCount + " 个带(1)的图片文件");
        System.out.println("成功删除 " + deletedCount + " 个文件");
    }

    private static boolean isImageFile(String fileName) {
        String lowerName = fileName.toLowerCase();
        return lowerName.endsWith(".jpg") ||
               lowerName.endsWith(".jpeg") ||
               lowerName.endsWith(".png") ||
               lowerName.endsWith(".gif") ||
               lowerName.endsWith(".bmp") ||
               lowerName.endsWith(".webp");
    }
}