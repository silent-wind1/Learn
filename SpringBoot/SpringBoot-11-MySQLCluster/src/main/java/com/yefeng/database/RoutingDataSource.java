package com.yefeng.database;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
/**
 * @Author: 叶枫
 * @Date: 2024/06/16/20:40
 * @Description: 路由数据源
 */
public class RoutingDataSource extends AbstractRoutingDataSource {
    @Override
    protected Object determineCurrentLookupKey() {
        return DBContext.get();
    }
}
