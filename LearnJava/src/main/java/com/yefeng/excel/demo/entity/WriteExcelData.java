package com.yefeng.excel.demo.entity;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * 写入文件的内容
 */
@Data
public class WriteExcelData {
    /**
     * 序号
     */
    private Integer serialNumber;

    /**
     * 费用承担公司
     */
    private String costCompany;

    /**
     * 费用承担部门
     */
    private String costDepartment;

    /**
     * 实际部门
     */
    private String actualDepartment;

    /**
     * 职位
     */
    private String position;

    /**
     * 工号
     */
    private String employeeId;

    /**
     * 姓名
     */
    private String name;

    /**
     * 社保总合计
     */
    private BigDecimal socialSecurityTotal;

    /**
     * 社保单位合计
     */
    private BigDecimal socialSecurityCompanyTotal;

    /**
     * 社保个人合计
     */
    private BigDecimal socialSecurityPersonalTotal;

    /**
     * 养老保险单位交
     */
    private BigDecimal pensionInsuranceCompany;

    /**
     * 养老保险个人交
     */
    private BigDecimal pensionInsurancePersonal;

    /**
     * 工伤保险单位交
     */
    private BigDecimal workInjuryInsuranceCompany;

    /**
     * 工伤保险个人交
     */
    private BigDecimal workInjuryInsurancePersonal;

    /**
     * 失业保险单位交
     */
    private BigDecimal unemploymentInsuranceCompany;

    /**
     * 失业保险个人交
     */
    private BigDecimal unemploymentInsurancePersonal;

    /**
     * 基础医疗保险单位交
     */
    private BigDecimal basicMedicalInsuranceCompany;

    /**
     * 基础医疗保险个人交
     */
    private BigDecimal basicMedicalInsurancePersonal;

    /**
     * 生育保险单位交
     */
    private BigDecimal medicalInsuranceCompany;

    /**
     * 生育保险个人交
     */
    private BigDecimal medicalInsurancePersonal;

    /**
     * 公积金单位
     */
    private BigDecimal housingFundCompany;

    /**
     * 公积金个人
     */
    private BigDecimal housingFundPersonal;

    /**
     * 公积金合计
     */
    private BigDecimal housingFundTotal;

    /**
     * 部门
     */
    @ExcelIgnore
    private String department;

    /**
     * 备注
     */
    @ExcelIgnore
    private String remark;
}
