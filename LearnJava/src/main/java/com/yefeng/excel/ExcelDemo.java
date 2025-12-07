package com.yefeng.excel;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.write.metadata.WriteSheet;

import static com.yefeng.excel.DataDemoListener.cachedDataList;

/**
 * @author wind
 * @description:
 * @date 2025/12/4 19:05
 */
public class ExcelDemo {

    public static void main(String[] args) {
        String fileName = "./社保.xlsx";
        EasyExcel.read(fileName, DataDemo.class, new DataDemoListener()).headRowNumber(2).sheet().doRead();

        String name = "./社保1.xlsx";
        String templateFileName = "./模板.xlsx";

        // 使用模板文件写入，会保留模板的前3行，从第4行开始追加数据
        try (ExcelWriter excelWriter = EasyExcel.write(name, DataDemo.class).withTemplate(templateFileName).build()) {
            WriteSheet writeSheet = EasyExcel.writerSheet().needHead(false).build();
            // 写入数据，会从模板文件的下一行开始（第4行）
            excelWriter.write(cachedDataList, writeSheet);
            // 关闭流
            excelWriter.finish();
        }
    }
}
