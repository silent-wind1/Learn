package com.yefeng.excel;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.write.metadata.WriteSheet;

import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static com.yefeng.excel.DataDemoListener.cachedDataList;

/**
 * @author wind
 * @description:
 * @date 2025/12/4 19:05
 */
public class ExcelDemo {

    public static void main(String[] args) {
//        String fileName = "./社保.xlsx";
//        EasyExcel.read(fileName, DataDemo.class, new DataDemoListener()).headRowNumber(2).sheet().doRead();
//
//        String name = "./社保1.xlsx";
//        String templateFileName = "./模板.xlsx";
//
//
//        EasyExcel.write(name, DataDemo.class).withTemplate(templateFileName).needHead(false).sheet().build();

        List<String> SPECIAL_EXCEL = List.of("社保缴费明细.xlsx", "公积金缴费明细.xlsx");
        String date = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyyMM"));
        System.out.println(LocalDate.now());
        System.out.println(YearMonth.now());
        String now = YearMonth.now().format(DateTimeFormatter.ofPattern("yyyyMM"));
        System.out.println(now);

        String path = String.format("D:/各地区社保公积金数据表/%s/附件/深圳-深圳市同仁科技实业有限公司-社保缴费明细.xlsx", date );
        System.out.println(path);
        String socialPath = "D:/各地区社保公积金数据表/202512/附件/深圳-深圳市同仁科技实业有限公司-社保缴费明细.xlsx";
        String fileName = socialPath.substring(socialPath.lastIndexOf("/") + 1);
        String[] name = fileName.split("-");
        if(SPECIAL_EXCEL.stream().anyMatch(name[name.length - 1]::equals)) {
            System.out.println(name[name.length - 1]);
        }

    }
}
