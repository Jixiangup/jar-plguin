package me.liujixiang.plugin;

import me.liujixiang.core.Plugin;

/**
 * @author jixiangup
 * @since 1.0.0
 */
public class DorisSinkPlugin implements Plugin {
    @Override
    public String sink(String payload) {
        System.out.println("这是请求负载: " + payload);
        return "我是Doris插件。。。";
    }
}
