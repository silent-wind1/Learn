package com.yefeng.excel;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ContentLoopMerge;
import lombok.Data;

/**
 * @author wind
 * @description:
 * @date 2025/12/4 19:05
 */
@Data
public class DataDemo {
    @ExcelProperty(value = "序号", index = 0)
    private String id;
    @ExcelProperty(value = "姓名", index = 1)
    private String name;
    @ExcelProperty(value = {"公积金", "总计"})
    private String socialTotal;
    @ExcelProperty(value = {"公积金", "企业"})
    private String socialCompany;
    @ExcelProperty(value = {"公积金", "个人"})
    private String socialPerson;
    @ExcelProperty(value = {"养老", "总计"})
    private String ylTotal;
    @ExcelProperty(value = {"养老", "企业"})
    private String ylCompany;
    @ExcelProperty(value = {"养老", "个人"})
    private String ylPerson;
}