package com.test;

import cn.hutool.core.io.FileUtil;

import java.io.File;

/**
 * 静态文件生成器
 */
public class StaticGenerator {
    public static void main(String[] args) {
        String projectPath = System.getProperty("user.dir");
//        System.out.println(projectPath); // E:\a-front\java\demo-generator
        String inputPath = projectPath + File.separator + "generator-demo-projects" + File.separator + "acm-template";
        String outputPath = projectPath;
        copyFilesByHutool(inputPath, outputPath);
    }
    /**
     *
     * @param srcPath 输入路劲
     * @param destPath 输出路径
     */
    public static void copyFilesByHutool(String srcPath, String destPath) {
        FileUtil.copy(srcPath, destPath, false);
    }
}
