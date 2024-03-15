package me.liujixiang;

import me.liujixiang.core.Plugin;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ServiceLoader;

/**
 * @author jixiangup
 * @since 1.0.0
 */
public class PluginLoader {
    public static Plugin loadPlugin(String jarPath, String pluginName) {
        try {
            File pluginsFile = new File(jarPath);
            File[] listFiles = pluginsFile.listFiles((file, name) -> name.equals(pluginName + ".jar"));

            if (listFiles == null || listFiles.length == 0) {
                throw new RuntimeException("Plugin not found.");
            }

            File pluginJar = listFiles[0];

            URLClassLoader child = new URLClassLoader(new URL[]{pluginJar.toURI().toURL()}, PluginLoader.class.getClassLoader());

            ServiceLoader<Plugin> plugins = ServiceLoader.load(Plugin.class, child);
            return plugins.findFirst().orElseThrow(() -> new RuntimeException("插件 " + pluginName + " 不存在"));
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
