package com.sbt.lesson7.pluginmanager.plugins.my.com.plugin;

import com.sbt.lesson7.pluginmanager.Plugin;

public class MyLoader implements Plugin {
    @Override
    public void doUsefull() {
        System.out.println(this.getClass() + "plugin loaded successful!");
    }
}
