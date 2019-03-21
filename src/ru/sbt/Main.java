package ru.sbt;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;


public class Main {
    public static void main(String[] args) {
        try {
            Path currentPath = Paths.get(".");
            String current = currentPath.toAbsolutePath().toString();

            PluginManager pluginManager = new PluginManager(current + "\\plugins");

//            Plugin printer = pluginManager.load("Another","ru.plugin.AnotherPlugin");
//            printer.doUsefull();

            Plugin anotherPlugin = pluginManager.load("PluginManager","ru.plugin.PluginManager");
            anotherPlugin.doUsefull();


        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | IOException e) {
            e.printStackTrace();
        }
    }
}
