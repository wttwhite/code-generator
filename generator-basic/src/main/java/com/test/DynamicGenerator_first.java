package com.test;

import com.test.model.MainTemplateConfig;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class DynamicGenerator_first {
    public static void main(String[] args) throws IOException, TemplateException {
        // new 出 Configuration 对象，参数为 FreeMarker 版本号
        Configuration configuration = new Configuration(Configuration.VERSION_2_3_32);
        // 指定模板文件所在的路径
        String projectPath = System.getProperty("user.dir") + File.separator + "generator-basic";
        String inputPath = projectPath + File.separator + "src/main/resources/templates";
        configuration.setDirectoryForTemplateLoading(new File(inputPath));
        // configuration.setDirectoryForTemplateLoading(new File("src/main/resources/templates"));
        // 设置模板文件使用的字符集
        configuration.setDefaultEncoding("utf-8");
        // 创建模板对象，加载指定模板
        Template template = configuration.getTemplate("MainTemplate.java.ftl");
        // 创建数据模型
        MainTemplateConfig mainTemplateConfig = new MainTemplateConfig();
        mainTemplateConfig.setAuthor("wtt");
        // 不使用循环
        mainTemplateConfig.setLoop(false);
        mainTemplateConfig.setOutputText("求和结果:");
        // 生成
        Writer out = new FileWriter("MainTemplate.java");
        template.process(mainTemplateConfig, out);
        // 生成文件后别忘了关闭哦
        out.close();
    }
}
