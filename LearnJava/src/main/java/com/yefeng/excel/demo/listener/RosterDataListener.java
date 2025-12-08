package com.yefeng.excel.demo.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.read.listener.ReadListener;
import com.yefeng.excel.demo.entity.Roster;

import static com.yefeng.excel.demo.ExcelReadDemo.ROSTERMap;


public class RosterDataListener implements ReadListener<Roster> {

    @Override
    public void invoke(Roster data, AnalysisContext context) {
        ROSTERMap.put(data.getName() + "-" + data.getCostDepartment(), data);
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {}
}
