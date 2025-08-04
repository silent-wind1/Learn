package com.yefeng.code;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.FileWriter;

public class JsonToMarkdownJackson {
    public static void main(String[] args) {
        try {
            // 1. 读取JSON文件
            ObjectMapper mapper = new ObjectMapper();
            JsonNode rootNode = mapper.readTree(new File("E:\\study\\Learn\\LearnJava\\src\\main\\java\\com\\yefeng\\code\\input.json"));

            // 2. 提取content
            String content = rootNode.path("data").path("content").asText();

            // 3. 写入Markdown
            try (FileWriter writer = new FileWriter("E:\\study\\Learn\\LearnJava\\src\\main\\java\\com\\yefeng\\code\\output.md")) {
                writer.write(content);
                System.out.println("Markdown文件生成成功: output.md");
            }
        } catch (Exception e) {
            System.err.println("处理失败: " + e.getMessage());
        }
    }
}