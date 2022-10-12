//package com.yefeng;
//
//import com.baomidou.mybatisplus.core.mapper.BaseMapper;
////import com.baomidou.mybatisplus.generator.FastAutoGenerator;
////import com.baomidou.mybatisplus.generator.config.OutputFile;
//import com.baomidou.mybatisplus.generator.config.TemplateConfig;
//import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
//
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.List;
//import java.util.function.Consumer;
//
//public class NewYefengCode {
//    public static void main(String[] args) {
//        List<String> tables = new ArrayList<>();
//        tables.add("p_user");
//        tables.add("p_question");
//        tables.add("p_answer");
//        tables.add("p_correct");
//
//        FastAutoGenerator.create("jdbc:mysql://localhost:3306/xpa", "root", "123456")
//                .globalConfig(builder -> {
//                    builder.author("叶枫")               //作者
//                            .outputDir(System.getProperty("user.dir") + "/src/main/java")    //输出路径(写到java目录)
//                            .enableSwagger()           //开启swagger
//                            .commentDate("yyyy-MM-dd"); //调整时间格式
//                })
//                .packageConfig(builder -> {
//                    builder.parent("com.xp")
//                            .moduleName("practice")
//                            .entity("entity")
//                            .service("service")
//                            .serviceImpl("service.impl")
//                            .controller("controller")
//                            .mapper("mapper")
//                            .xml("mapper")
//                            .pathInfo(Collections.singletonMap(OutputFile.mapper, System.getProperty("user.dir") + "\\src\\main\\resources\\mapper"));
//                })
//
//                // 策略配置
//                .strategyConfig(builder -> {
//                    builder.addInclude("test1") // 设置需要生成的表名
//                            .addTablePrefix("t_", "c_") // 设置过滤表前缀
//                            .serviceBuilder()   // service 配置策略
//                            .formatServiceFileName("%sService")
//                            .formatServiceImplFileName("%sServiceImpl")
//                            .entityBuilder()
//                            .enableLombok() // 开启Lombok
//                            .logicDeleteColumnName("deleted")   // 说明逻辑删除（软删除）是哪个字段
//                            .enableTableFieldAnnotation()   // 属性上加说明注解
//                            .controllerBuilder()    // controller 策略配置
//                            .formatFileName("%sController")
//                            .enableRestStyle()  // 开启 RestController
//                            .mapperBuilder()    //mapper 策略配置
//                            .superClass(BaseMapper.class)   // 继承哪个父类
//                            .formatMapperFileName("%sMapper")
//                            .enableMapperAnnotation()   // @mapper 开启
//                            .formatXmlFileName("%sMapper"); // xml 名
//
//                })
//                .templateConfig(new Consumer<TemplateConfig.Builder>() {
//                    @Override
//                    public void accept(TemplateConfig.Builder builder) {
//                        // 实体类使用我们自定义模板
//                        builder.entity("templates/myentity.java");
//                    }
//                })
//                .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
//                .execute();
//    }
//
//}
