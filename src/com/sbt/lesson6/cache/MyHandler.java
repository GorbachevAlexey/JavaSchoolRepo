package com.sbt.lesson6.cache;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Map;

public class MyHandler implements InvocationHandler {

    private final Object delegate;
    private final Map<String, Double> cache;

    public MyHandler(Object delegate, Map<String, Double> cache) {
        this.delegate = delegate;
        this.cache = cache;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //Проверяем, если в кэше уже вычисленное значение
        if (cache.containsKey((String) args[0])) {
            System.out.print("Результат получен из кэша: ");
            return cache.get((String) args[0]);
        }
        //Иначе вычисляем его
        Object result = method.invoke(delegate, args);
        //И заносим в кэш
        cache.put((String) args[0], (Double) result);
        System.out.print("Результат сохранен в кэше: ");
        return result;
    }
}
