package com.example.zhou.config;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.core.enums.SqlMethod;
import com.baomidou.mybatisplus.core.injector.AbstractMethod;
import com.baomidou.mybatisplus.core.injector.DefaultSqlInjector;
import com.baomidou.mybatisplus.core.injector.ISqlInjector;
import com.baomidou.mybatisplus.core.metadata.TableInfo;
import com.baomidou.mybatisplus.core.parser.SqlInfo;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.sql.SqlScriptUtils;
import com.baomidou.mybatisplus.extension.parsers.DynamicTableNameParser;
import com.baomidou.mybatisplus.extension.plugins.OptimisticLockerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.example.zhou.utils.BeanUtil;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.executor.keygen.Jdbc3KeyGenerator;
import org.apache.ibatis.executor.keygen.KeyGenerator;
import org.apache.ibatis.executor.keygen.NoKeyGenerator;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlSource;
import org.apache.ibatis.reflection.MetaObject;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.annotation.MapperScans;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@EnableTransactionManagement
@Configuration
@MapperScans({@MapperScan(value = "com.example.**.mapper")})
public class MybatisPlusConfig {
    private static ThreadLocal<Map<String, String>> tableNameThreadLocal = new ThreadLocal<>();

    @Bean
    public OptimisticLockerInterceptor optimisticLockerInterceptor() {
        return new OptimisticLockerInterceptor();
    }

    /**
     * @param beanClass
     * @param newTable
     */
    public static void setTableName(Class beanClass, String newTable) {
        TableName tableNameObj = (TableName) beanClass.getAnnotation(TableName.class);
        if (tableNameObj != null) {
            Map<String, String> map = tableNameThreadLocal.get();
            if (map == null) {
                map = new HashMap<>();
                tableNameThreadLocal.set(map);
            }
            String orignTable = tableNameObj.value();
            map.put(orignTable, newTable);

            BeanUtil.getBean(MybatisPlusConfig.class).dynamicTableNameParser().getTableNameHandlerMap().put(orignTable, (metaObject, sql, tableName) -> {
                if (tableNameThreadLocal.get() != null) {
                    tableName = StringUtils.defaultString(tableNameThreadLocal.get().get(orignTable), tableName);
                }
                return tableName;
            });
        }
    }

    @Bean
    public DynamicTableNameParser dynamicTableNameParser() {
        DynamicTableNameParser dynamicTableNameParser = new DynamicTableNameParser() {
            @Override
            public SqlInfo parser(MetaObject metaObject, String sql) {
                if (CollectionUtils.isEmpty(getTableNameHandlerMap())) {
                    return SqlInfo.newInstance().setSql(sql);
                } else {
                    return super.parser(metaObject, sql);
                }
            }
        };
        dynamicTableNameParser.setTableNameHandlerMap(new HashMap<>());
        return dynamicTableNameParser;
    }


    @Bean
    public PaginationInterceptor paginationInterceptor() {
        PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
        paginationInterceptor.setSqlParserList(Collections.singletonList(dynamicTableNameParser()));
        return paginationInterceptor;
    }

    @Bean
    public ISqlInjector sqlInjector() {
        return new DefaultSqlInjector() {
            @Override
            public List<AbstractMethod> getMethodList(Class<?> mapperClass) {
                List<AbstractMethod> methodList = super.getMethodList(mapperClass);
                methodList.removeIf(e -> e instanceof com.baomidou.mybatisplus.core.injector.methods.Insert);
                methodList.add(new Insert());
                return methodList;
            }
        };
    }

    /**
     * 自定义id生成，Bean中配置@TableId(value = "id", type = IdType.INPUT)
     * 不填id的时候，会自动生成，填了id就用填的id
     */
    public class Insert extends AbstractMethod {

        @Override
        public MappedStatement injectMappedStatement(Class<?> mapperClass, Class<?> modelClass, TableInfo tableInfo) {
            KeyGenerator keyGenerator = new NoKeyGenerator();
            SqlMethod sqlMethod = SqlMethod.INSERT_ONE;
            String columnScript = SqlScriptUtils.convertTrim(tableInfo.getAllInsertSqlColumnMaybeIf(),
                    LEFT_BRACKET, RIGHT_BRACKET, null, COMMA);
            String valuesScript = SqlScriptUtils.convertTrim(tableInfo.getAllInsertSqlPropertyMaybeIf(null),
                    LEFT_BRACKET, RIGHT_BRACKET, null, COMMA);
            String keyProperty = null;
            String keyColumn = null;
            // 表包含主键处理逻辑,如果不包含主键当普通字段处理
            if (StringUtils.isNotBlank(tableInfo.getKeyProperty())) {
                keyGenerator = new Jdbc3KeyGenerator();
                keyProperty = tableInfo.getKeyProperty();
                keyColumn = tableInfo.getKeyColumn();
            }
            String sql = String.format(sqlMethod.getSql(), tableInfo.getTableName(), columnScript, valuesScript);
            SqlSource sqlSource = languageDriver.createSqlSource(configuration, sql, modelClass);
            return this.addInsertMappedStatement(mapperClass, modelClass, sqlMethod.getMethod(), sqlSource, keyGenerator, keyProperty, keyColumn);
        }
    }
}
