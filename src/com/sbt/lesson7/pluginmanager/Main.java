package com.sbt.lesson7.pluginmanager;

import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {
        Path currentPath = Paths.get("D:\\study\\SBT\\javaschool\\testsbt\\out\\production\\testsbt\\com\\sbt\\lesson7\\pluginmanager\\plugins");
        String current = currentPath.toAbsolutePath().toString();

        PluginManager pluginManager = new PluginManager(current);
        Plugin firstPlugin = pluginManager.load("first", "com.plugin.FirstPlugin");
    }
}
