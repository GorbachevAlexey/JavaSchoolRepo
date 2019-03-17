package com.sbt.lesson6;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class Main {
    public static void main(String[] args) {
        Week week = new Week();
        Class<?> clazz = week.getClass();
        System.out.println("================Class methods, include parent methods================");
        System.out.println(clazz.getName());
        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println(method);
        }

        Class<?> tmpClazz = clazz.getSuperclass();
        while (tmpClazz != null) {
            methods = tmpClazz.getDeclaredMethods();
            for (Method method : methods) {
                System.out.println(method);
            }
            tmpClazz = tmpClazz.getSuperclass();
        }

        System.out.println("================Getters================");
        System.out.println(clazz.getName());
        methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            if (method.getName().substring(0, 3).contains("get")) {
                System.out.println(method);
            }
        }

        try {
            checkStrings(week);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public static <T> void checkStrings(T type) throws IllegalAccessException {
        Class<?> clazz = type.getClass();
        System.out.println("================checkStrings================");
        System.out.println(clazz.getName());
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            int fieldModifier = field.getModifiers();
            field.setAccessible(true);
            if (Modifier.isStatic(fieldModifier)
                    && Modifier.isFinal(fieldModifier)
                    && field.getType().getName().equals(String.class.getName())) {
                if (field.get(type).equals(field.getName())) {
                    System.out.println(field + " - true");
                } else {
                    System.out.println(field + " - false");
                }
            }
        }
    }
}
