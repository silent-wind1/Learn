package com.yefeng.excel.demo.listener;

import cn.hutool.core.bean.BeanUtil;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.read.listener.ReadListener;
import com.yefeng.excel.demo.entity.Roster;
import com.yefeng.excel.demo.entity.WriteExcelData;

import static com.yefeng.excel.demo.ExcelReadDemo.*;


public class EmployeeSocialSecurityPlusDataListener<T> implements ReadListener<T> {
    @Override
    public void invoke(T data, AnalysisContext context) {
        WriteExcelData writeExcelData = new WriteExcelData();
        BeanUtil.copyProperties(data, writeExcelData);
        String key = writeExcelData.getName() + "-" + writeExcelData.getDepartment();
        Roster roster = ROSTERMap.get(key);
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

    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {}

}
