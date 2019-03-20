package com.sbt.lesson7.pluginmanager.plugins.first.com.plugin;

import com.sbt.lesson7.pluginmanager.Plugin;

public class FirstPlugin implements Plugin {
    @Override
    public void doUsefull() {
        System.out.println(this.getClass() + "plugin loaded successful!");
    }
}
