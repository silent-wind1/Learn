package com.yefeng.excel.demo;

import cn.hutool.core.bean.BeanUtil;
import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.write.metadata.style.WriteCellStyle;
import com.alibaba.excel.write.metadata.style.WriteFont;
import com.alibaba.excel.write.style.HorizontalCellStyleStrategy;
import com.yefeng.excel.demo.entity.EmployeeSocialSecurity;
import com.yefeng.excel.demo.entity.EmployeeSocialSecurityPlus;
import com.yefeng.excel.demo.entity.Roster;
import com.yefeng.excel.demo.entity.WriteExcelData;
import com.yefeng.excel.demo.listener.EmployeeSocialSecurityPlusDataListener;
import com.yefeng.excel.demo.listener.RosterDataListener;

import java.io.File;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

/**
 * Excel 合并 Demo
 */
public class ExcelReadDemo {
    public static final AtomicInteger INDEX = new AtomicInteger(1);
    public static final List<WriteExcelData> DATA = new ArrayList<>();
    public static final Map<String, Roster> ROSTERMap = new HashMap<>(680);

    public static void main(String[] args) {
        List<String> SPECIAL_REGIONS = List.of("陕西", "惠州", "深圳", "西安", "韶关");
        List<String> SPECIAL_EXCEL = List.of("深圳-深圳市同仁科技实业有限公司-社保缴费明细.xlsx", "深圳-深圳市同仁科技实业有限公司-公积金缴费明细.xlsx");
        String date = YearMonth.now().format(DateTimeFormatter.ofPattern("yyyyMM"));
        String directoryPath = "D:/各地区社保公积金数据表/202512/附件";
        List<String> excelFiles = findExcelFile(directoryPath);

        if (excelFiles == null) {
            System.out.println("目录下没有Excel文件");
            return;
        }

        // 读取花名册
        readRosterExcel();

        for (String filePath : excelFiles) {
            // 获取文件名
            String fileName = filePath.substring(filePath.lastIndexOf("\\") + 1);
            if (SPECIAL_EXCEL.stream().anyMatch(fileName::equals)) {
                System.out.println("跳过这个Excel后面特殊处理" + filePath);
                continue;
            }
            if (SPECIAL_REGIONS.stream().anyMatch(filePath::contains)) {
                EasyExcel.read(filePath, EmployeeSocialSecurityPlus.class, new EmployeeSocialSecurityPlusDataListener<EmployeeSocialSecurityPlus>()).headRowNumber(4).sheet(0).doRead();
            } else {
                EasyExcel.read(filePath, EmployeeSocialSecurity.class, new EmployeeSocialSecurityPlusDataListener<EmployeeSocialSecurity>()).headRowNumber(4).sheet(0).doRead();
            }
        }
        // 合并数据
        String socialPath = String.format("D:/各地区社保公积金数据表/%s/附件/深圳-深圳市同仁科技实业有限公司-社保缴费明细.xlsx", date);
        String housingPath = String.format("D:/各地区社保公积金数据表/%s/附件/深圳-深圳市同仁科技实业有限公司-公积金缴费明细.xlsx", date);
        mergedExcel(socialPath, housingPath);
        // 写入到 Excel
        writeExcel();
    }

    /**
     * 判断文件是否为Excel文件
     *
     * @param file 文件对象
     * @return 是否为Excel文件
     */
    private static boolean isExcelFile(File file) {
        String fileName = file.getName().toLowerCase();
        return fileName.endsWith(".xls") || fileName.endsWith(".xlsx") || fileName.endsWith(".xlsm") || fileName.endsWith(".xlt");
    }


    /**
     * 查找某个文件下的所有 Excel 文件
     *
     * @param filePath 文件目录
     * @return Excel文件路径集合
     */
    private static List<String> findExcelFile(String filePath) {
        List<String> excelFiles = new ArrayList<>();

        File directory = new File(filePath);
        // 获取目录下所有文件和文件夹
        File[] files = directory.listFiles();
        if (files == null) {
            System.out.println("文件目录为空");
            return null;
        }

        // 遍历文件，筛选Excel文件
        for (File file : files) {
            if (file.isFile() && isExcelFile(file)) {
                excelFiles.add(file.getPath());
            }
        }
        return excelFiles;
    }

    private static void readRosterExcel() {
        // 读取花名册Excel文件
        String rosterPath = "D:/部门.xlsx";
        EasyExcel.read(rosterPath, Roster.class, new RosterDataListener()).headRowNumber(1).sheet(0).doRead();
    }


    /**
     * Excel写入
     */
    private static void writeExcel() {
        String name = "D:/" + YearMonth.now() + "社保公积金汇总.xlsx";
        String templateFileName = "D:/社保公积金汇总表.xlsx";

        // 创建字体样式 - 设置为宋体
        WriteFont writeFont = new WriteFont();
        writeFont.setFontName("宋体");
        writeFont.setFontHeightInPoints((short) 11);

        // 创建单元格样式
        WriteCellStyle writeCellStyle = new WriteCellStyle();
        writeCellStyle.setWriteFont(writeFont);

        // 创建水平样式处理器
        HorizontalCellStyleStrategy styleStrategy = new HorizontalCellStyleStrategy(null, writeCellStyle);

        EasyExcel.write(name, WriteExcelData.class).withTemplate(templateFileName).sheet().needHead(false)  // 不生成标题
                .registerWriteHandler(styleStrategy).doWrite(DATA);

    }

    /**
     *
     * 合并 Excel 数据
     *
     * @param socialPath  社保文件路径
     * @param housingPath 公积金文件路径
     */
    private static void mergedExcel(String socialPath, String housingPath) {
        // 读取社保数据
        List<EmployeeSocialSecurityPlus> socialList = EasyExcel.read(socialPath, EmployeeSocialSecurityPlus.class, null).headRowNumber(4).sheet().doReadSync();

        // 读取公积金数据
        List<EmployeeSocialSecurityPlus> housingList = EasyExcel.read(housingPath, EmployeeSocialSecurityPlus.class, null).headRowNumber(4).sheet().doReadSync();

        // 创建公积金数据的查找映射
        Map<String, EmployeeSocialSecurityPlus> housingMap = housingList.stream().collect(Collectors.toMap(housing -> housing.getName() + "-" + housing.getDepartment(), housing -> housing));

        socialList.stream()
                .filter(social -> housingMap.containsKey(social.getName() + "-" + social.getDepartment()))
                .forEach(social -> {
                    EmployeeSocialSecurityPlus housing = housingMap.get(social.getName() + "-" + social.getDepartment());
                    social.setHousingFundCompany(housing.getHousingFundCompany());
                    social.setHousingFundPersonal(housing.getHousingFundPersonal());
                    social.setHousingFundTotal(housing.getHousingFundTotal());

                    copyWriteExcelData(social);
                });
    }

    /**
     * 将数据复制到 writeExcelData 对象中
     *
     * @param data 数据
     * @param <T>  泛型
     */
    public static <T> void copyWriteExcelData(T data) {
        WriteExcelData writeExcelData = new WriteExcelData();
        BeanUtil.copyProperties(data, writeExcelData);
        String rosterKey = writeExcelData.getName() + "-" + writeExcelData.getDepartment();
        Roster roster = ROSTERMap.get(rosterKey);
        if (roster != null) {
            writeExcelData.setSerialNumber(INDEX.getAndIncrement());
            writeExcelData.setCostCompany(roster.getCostCompany());
            writeExcelData.setCostDepartment(roster.getCostDepartment());
            writeExcelData.setActualDepartment(roster.getActualDepartment());
            writeExcelData.setPosition(roster.getPosition());
            writeExcelData.setEmployeeId(roster.getEmployeeId());
        }

        DATA.add(writeExcelData);
    }
}
