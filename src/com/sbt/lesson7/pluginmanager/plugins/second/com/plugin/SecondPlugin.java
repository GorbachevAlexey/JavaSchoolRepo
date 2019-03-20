package com.sbt.lesson7.pluginmanager.plugins.second.com.plugin;

import com.sbt.lesson7.pluginmanager.Plugin;

public class SecondPlugin implements Plugin {
    @Override
    public void doUsefull() {
        System.out.println(this.getClass() + "plugin loaded successful!");
    }
}
