package com.zzz.mpgeneratorcodedemo.common;


import com.baomidou.mybatisplus.generator.FastAutoGenerator;

import com.baomidou.mybatisplus.generator.config.*;

import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;


import java.util.Arrays;

import java.util.Collections;

import java.util.List;


/**
 * @Description:MP代码生成器
 **/

public class GeneratorCode {

    static final String URL = "jdbc:mysql://60.204.186.79:10426/genshin_tool?serverTimezone=UTC";


    public static void main(String[] args) {

        String projectPath = System.getProperty("user.dir");//获取项目路径

        FastAutoGenerator.create(URL, "genshin_tool", "S8RemGn3PBDE2emz")
                //全局配置
                .globalConfig((scanner, builder) -> {
                    builder.author("author")
                            .dateType(DateType.ONLY_DATE) //设置日期格式为Date
                            .outputDir(projectPath + "/src/main/java")//输出路径
                            .enableSwagger()//开启swagger3
                            .fileOverride()//覆盖文件
                            .disableOpenDir();//不打开文件夹

                })

                //包名配置
                .packageConfig((scanner, builder) -> {
                    builder.parent("com.zzz.mpgeneratordemo")
                            .service("service")
                            .serviceImpl("service.impl")
                            .controller("controller")
                            .entity("entity")
                            .mapper("mapper");

                })

                //策略配置
                .strategyConfig((scanner, builder) -> {
                    builder.addInclude(getTables(scanner.apply("请输入表名，多个英文逗号分隔？所有输入 all")))
                            .addTablePrefix("t_")//表前缀
                            .serviceBuilder().formatServiceFileName("%sService")//去掉Service的 "I" 前缀
                            .controllerBuilder().enableRestStyle()//restful开启
                            .enableHyphenStyle()//url改变 例如：index_id_1
                            .entityBuilder().enableLombok();

                })

                // 模板配置
                .templateConfig((scanner, builder) -> {
                    builder.disable(TemplateType.ENTITY)
                            .entity("/templates/entity.java")
                            .service("/templates/service.java")
                            .serviceImpl("/templates/serviceImpl.java")
                            .mapper("/templates/mapper.java")
                            .xml("/templates/mapper.xml")
                            .controller("/templates/controller.java")
                            .build();
                })

                .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                //执行
                .execute();

    }


    // 处理 all 情况

    protected static List<String> getTables(String tables) {
        return "all".equals(tables) ? Collections.emptyList() : Arrays.asList(tables.split(","));
    }


}