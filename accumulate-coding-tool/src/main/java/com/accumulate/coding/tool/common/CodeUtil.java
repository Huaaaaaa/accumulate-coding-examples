package com.accumulate.coding.tool.common;

import com.accumulate.coding.common.exception.InvalidParamException;
import com.accumulate.coding.tool.constants.AppDataSourceConstants;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @ClassName CodeGenerateTool
 * @Description 代码生成器
 * @Date 2020/9/10  17:03
 */
@Component
public class CodeUtil {


    @Autowired
    private AppDataSourceConstants appDataSourceConstants;

    /**
     * 接受控制台输入
     *
     * @param inputName
     * @return
     */
    public String getInput(String inputName) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder tips = new StringBuilder("请输入");
        tips.append(inputName).append(":");
        if (scanner.hasNext()) {
            String input = scanner.next();
            if (!StringUtils.isEmpty(input)) {
                return input;
            }
        }
        throw new InvalidParamException("请输入正确的：" + inputName + "!");
    }

    /**
     * 获取配置
     *
     * @param project     工程名
     * @param packageName 包名
     * @return
     */
    public AutoGenerator getAutoGenerator(String project, String packageName) {
        //代码生成器
        AutoGenerator autoGenerator = new AutoGenerator();

        //1、全局配置
        GlobalConfig gc = new GlobalConfig();
        String projectPath = System.getProperty(project);
        gc.setOutputDir(projectPath + "/src/main/java");
        gc.setAuthor("me");
        gc.setOpen(false);
        gc.setSwagger2(true);
        autoGenerator.setGlobalConfig(gc);

        //2、数据源配置
        DataSourceConfig dc = new DataSourceConfig();
        dc.setUrl(appDataSourceConstants.getUrl());
        dc.setDriverName(appDataSourceConstants.getDriverClassName());
        dc.setUsername(appDataSourceConstants.getUserName());
        dc.setPassword(appDataSourceConstants.getPassword());
        autoGenerator.setDataSource(dc);

        //3、包配置
        PackageConfig pc = new PackageConfig();
        pc.setModuleName(getInput("模块名"));
        pc.setParent(packageName);
        autoGenerator.setPackageInfo(pc);

        //4、自定义配置
        InjectionConfig ic = new InjectionConfig() {
            @Override
            public void initMap() {

            }
        };

        //生成mapper
        String templatePath = "/templates/mapper.xml.ftl";
        // 自定义输出配置
        List<FileOutConfig> focList = new ArrayList<>();
        // 自定义配置会被优先输出
        focList.add(new FileOutConfig(templatePath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
                return projectPath + "/src/main/resources/mapper/" + pc.getModuleName()
                        + "/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
            }
        });
        ic.setFileOutConfigList(focList);
        autoGenerator.setCfg(ic);

        //5、配置模板
        TemplateConfig templateConfig = new TemplateConfig();

        // 配置自定义输出模板:指定自定义模板路径，注意不要带上.ftl/.vm, 会根据使用的模板引擎自动识别
        // templateConfig.setEntity("templates/entity2.java");
        // templateConfig.setService();
        // templateConfig.setController();
        templateConfig.setXml(null);
        autoGenerator.setTemplate(templateConfig);

        //6、策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        strategy.setSuperEntityClass("你自己的父类实体,没有就不用设置!");
        strategy.setEntityLombokModel(true);
        strategy.setRestControllerStyle(true);
        // 公共父类
        strategy.setSuperControllerClass("你自己的父类控制器,没有就不用设置!");
        // 写于父类中的公共字段
        strategy.setSuperEntityColumns("id");
        strategy.setInclude(getInput("表名，多个英文逗号分割").split(","));
        strategy.setControllerMappingHyphenStyle(true);
        strategy.setTablePrefix(pc.getModuleName() + "_");
        autoGenerator.setStrategy(strategy);
        autoGenerator.setTemplateEngine(new FreemarkerTemplateEngine());
        return autoGenerator;
    }
}
