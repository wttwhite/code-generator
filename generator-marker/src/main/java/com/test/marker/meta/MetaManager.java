package com.test.marker.meta;
import cn.hutool.core.io.resource.ResourceUtil;
import cn.hutool.json.JSONUtil;

// 之后获取 meta 对象信息，只需要调用 MetaManager.getMetaObject 方法即可，
// 相比每次都获取 JSON 文件并解析，提高了性能并简化代码。
public class MetaManager {

    //定义了 meta 属性，用于接受 JSON 配置。使用 volatile 关键字修饰，确保多线程环境下的可见性。
    private static volatile Meta meta;

    // 添加了一个私有构造函数，防止外部用 new 的方式创建出多个对象，破坏单例
    private MetaManager() {
        // 私有构造函数，防止外部实例化
    }

    // 定义了 getMetaObject 方法，用于获取 meta 对象。
    // 如果是首次获取，则执行 initMeta 方法来初始化 meta 对象；否则直接获取已有对象。
    // 此处使用 双检锁 进行并发控制，既保证了对象获取性能不会被锁影响，也能防止重复实例化。
    public static Meta getMetaObject() {
        if (meta == null) {
            synchronized (MetaManager.class) {
                if (meta == null) {
                    meta = initMeta();
                }
            }
        }
        return meta;
    }

    // 定义了 initMeta 方法，用于从 JSON 文件中获取对象属性并初始化 meta 对象。
    // 当然后续还可以执行对象校验、填充默认值等操作。
    private static Meta initMeta() {
        String metaJson = ResourceUtil.readUtf8Str("meta.json");
        Meta newMeta = JSONUtil.toBean(metaJson, Meta.class);
        Meta.FileConfig fileConfig = newMeta.getFileConfig();
        // todo 校验和处理默认值
        return newMeta;
    }
}