package com.sbt.lesson6.cache;

import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String, Double> cache = new HashMap<>();
        Calculator calc = (Calculator) Proxy.newProxyInstance(
                ClassLoader.getSystemClassLoader(),
                new Class[]{Calculator.class},
                new MyHandler(new CalculatorImpl(), cache)
        );

        System.out.println(calc.eval("2 2"));
        System.out.println(calc.eval("2.5 3.5"));
        System.out.println(calc.eval("3.14 3.14"));
        System.out.println(calc.eval("3.14 3.14"));
        System.out.println(calc.eval("2.7 2.7"));
        System.out.println(calc.eval("2 2"));
        System.out.println(calc.eval("2.7 2.7"));
    }
}

