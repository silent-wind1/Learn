package com.yefeng.excel;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ContentLoopMerge;
import lombok.Data;

/**
 * @author wind
 * @description: 模拟实体类
 * @date 2025/12/4 19:05
 */
@Data
public class DataDemo {
    private String id;
    private String name;
    private String socialTotal;
    private String socialCompany;
    private String socialPerson;
    private String ylTotal;
    private String ylCompany;
    private String ylPerson;
}