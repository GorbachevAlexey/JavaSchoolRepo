package com.sbt.lesson7.pluginmanager;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class PluginManager {

    private final String pluginRootDirectory;

    public PluginManager(String pluginRootDirectory) {
        this.pluginRootDirectory = pluginRootDirectory;
    }

    public Plugin load(String pluginName, String pluginClassName) {
        Plugin plugin = null;
        try {
            URL[] url = {new File(pluginRootDirectory + "\\" + pluginName + "\\").toURI().normalize().toURL()};
            System.out.println(url[0].toString());
            MyLoader myloader = new MyLoader(url);
            plugin = (Plugin) myloader.loadClass(pluginClassName).newInstance();
        } catch (MalformedURLException | IllegalAccessException | InstantiationException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return plugin;
    }

}
