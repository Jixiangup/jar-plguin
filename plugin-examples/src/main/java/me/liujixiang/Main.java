package me.liujixiang;

import me.liujixiang.core.Plugin;

/**
 * @author jixiangup
 * @since 1.0.0
 */
public class Main {
    public static void main(String[] args) {
        Plugin plugin = PluginLoader.loadPlugin("/IdeaProjects/jar-plguin/plugins", "doris-sink-plugin-1.0.0");
        String sink = plugin.sink("这是执行参数");
        System.out.println(sink);
    }
}
