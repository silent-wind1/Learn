package com.yefeng.flink;

import com.ververica.cdc.connectors.mysql.source.MySqlSource;
import com.ververica.cdc.connectors.mysql.table.StartupOptions;
import com.ververica.cdc.debezium.JsonDebeziumDeserializationSchema;
import org.apache.flink.api.common.eventtime.WatermarkStrategy;
import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;

/**
 * @author wind
 * @description: Flink CDC 代码示例
 * @date 2026/7/16 17:03
 */
public class FlinkMain {
    public static void main(String[] args) throws Exception {
            // 1. 创建环境
            StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
            env.setParallelism(1);

            // 3. 构建 MySQL CDC Source
            MySqlSource<String> mySqlSource = MySqlSource.<String>builder()
                    .serverTimeZone("Asia/Shanghai")
                    .hostname("127.0.0.1")        // 数据库地址 // ⚠️ 坑点2：务必使用真实 IP，不要无脑写 localhost
                    .port(3306)                   // 端口
                    .databaseList("new_taizhan")   // 监控的数据库
                    .tableList("new_taizhan.sys_user") // 监控的表 (库名.表名)
                    .username("root")             // 用户名
                    .password("123456")    // 替换为你的密码！！！

                    // initial(): 第一次启动时，读取全量数据，然后切换到 Binlog。
                    // latest(): 只读取启动之后的新变更。
                    .startupOptions(StartupOptions.initial())
                    .deserializer(new JsonDebeziumDeserializationSchema()) // 将变更数据转为 JSON 字符串
                    .build();

            // 4.读取数据
            DataStreamSource<String> source = env.fromSource(
                    mySqlSource, WatermarkStrategy.noWatermarks(), "MySQL CDC Source"
            );

            // 打印
            source.print();

            // 执行
            env.execute();
    }
}
