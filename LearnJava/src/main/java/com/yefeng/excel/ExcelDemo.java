package com.yefeng.excel;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.enums.CellExtraTypeEnum;

/**
 * @author wind
 * @description:
 * @date 2025/12/4 19:05
 */
public class ExcelDemo {
    public static void main(String[] args) {
        // 写法1：JDK8+ ,不用额外写一个DemoDataListener
        // since: 3.0.0-beta1
        String fileName = "./社保.xlsx";
        // 这里默认每次会读取100条数据 然后返回过来 直接调用使用数据就行
        // 具体需要返回多少行可以在`PageReadListener`的构造函数设置
        // 指定表头行数为2（因为Excel有两行表头）
        EasyExcel.read(fileName, DataDemo.class, new DataDemoListener())
                // 需要读取合并单元格信息 默认不读取
                .extraRead(CellExtraTypeEnum.MERGE)
                .sheet()
                .doRead();

    }
}
