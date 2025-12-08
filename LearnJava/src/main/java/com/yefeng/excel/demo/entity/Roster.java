package com.yefeng.excel.demo.entity;

import lombok.Data;

@Data
public class Roster {
    /**
     * 公积金主体
     */
    private String providentFundEntity;

    /**
     * 姓名
     */
    private String name;

    /**
     * 工号
     */
    private String employeeId;

    /**
     * 岗位
     */
    private String position;

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
}
