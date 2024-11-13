package com.test;

import com.test.model.MainTemplateConfig;

import java.io.File;
import java.io.IOException;
import freemarker.template.TemplateException;

public class MainGenerator {
    public static void main(String[] args) throws TemplateException, IOException {
        MainTemplateConfig mainTemplateConfig = new MainTemplateConfig();
        mainTemplateConfig.setAuthor("aaa");
        mainTemplateConfig.setLoop(false);
        mainTemplateConfig.setOutputText("求和结果：");
        doGenerate(mainTemplateConfig);
    }
    /**
     * 生成
     *
     * @param model 数据模型
     * @throws TemplateException
     * @throws IOException
     */
    public static void doGenerate(Object model) throws TemplateException, IOException {
        String projectPath = System.getProperty("user.dir");
        // 输入路径
        String inputPath = projectPath + File.separator + "generator-demo-projects" + File.separator + "acm-template";
        // 生成静态文件
        StaticGenerator.copyFilesByRecursive(inputPath, projectPath);
        // 生成动态文件
        String generatorBasicPath = projectPath + File.separator + "generator-basic";
        String inputDynamicFilePath = generatorBasicPath + File.separator + "src/main/resources/templates/MainTemplate.java.ftl";
        String outputDynamicFilePath = projectPath + File.separator + "acm-template/src/com/yupi/acm/MainTemplate.java";
        DynamicGenerator.doGenerate(inputDynamicFilePath, outputDynamicFilePath, model);
    }
}
