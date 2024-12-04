package com.test.marker.generator.file;

import cn.hutool.core.io.FileUtil;

/**
 * 静态文件生成器
 */
public class StaticGenerator {
    /**
     * 拷贝文件 （Hutool实现，会将输入目录完整拷贝到输出目录下）
     * @param srcPath 输入路劲
     * @param destPath 输出路径
     */
    public static void copyFilesByHutool(String srcPath, String destPath) {
        FileUtil.copy(srcPath, destPath, false);
    }
}
