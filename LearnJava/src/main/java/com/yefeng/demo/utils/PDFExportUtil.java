package com.yefeng.demo.utils;

import cn.hutool.core.io.FileUtil;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * @author wind
 * @description: PDF 导出工具类，演示使用中文字体生成 PDF
 * @date 2026/6/26 10:05
 */
public class PDFExportUtil {

    public static void main(String[] args) {

        String fileDir = System.getProperty("user.dir") + "/tmp/pdf";

        // 从文件读取内容
        String content = FileUtil.readString(fileDir + "/demo.md", StandardCharsets.UTF_8);
        String fileName = "yefeng.pdf";
        String filePath = fileDir + "/" + fileName;

        // 创建目录
        FileUtil.mkdir(fileDir);

        try (PdfWriter writer = new PdfWriter(filePath);
             PdfDocument pdf = new PdfDocument(writer);
             Document document = new Document(pdf)) {

            // 加载微软雅黑（msyh.ttc 是字体集合，索引 0 为常规体）
            PdfFont chineseFont = PdfFontFactory.createFont(
                "C:/Windows/Fonts/msyh.ttc,0",
                PdfFontFactory.EmbeddingStrategy.PREFER_EMBEDDED
            );

            // document.setFont() 是整个文档的默认字体，paragraph.setFont() 是仅当前段落。
            document.setFont(chineseFont);
            Paragraph paragraph = new Paragraph(content);
            document.add(paragraph);

            System.out.println("PDF 生成成功: " + filePath);
        } catch (IOException e) {
            throw new RuntimeException("PDF 生成失败", e);
        }
    }
}
