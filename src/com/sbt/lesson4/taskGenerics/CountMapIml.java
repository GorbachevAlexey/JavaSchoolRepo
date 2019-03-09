package com.sbt.lesson4.taskGenerics;

import java.util.HashMap;
import java.util.Map;

public class CountMapIml<T> implements CountMap<T> {

    private final Map<T, Integer> map;

    public CountMapIml() {
        map = new HashMap<>();
    }

    // добавляет элемент в этот контейнер.
    @Override
    public void add(T t) {
        if (map.containsKey(t)) {
            map.put(t, map.get(t) + 1);
        } else {
            map.put(t, 1);
        }
    }

    //Возвращает количество добавлений данного элемента
    @Override
    public int getCount(T t) {
        return map.getOrDefault(t, 0);
    }

    //Удаляет элемент и контейнера и возвращает количество его добавлений(до удаления)
    @Override
    public int remove(T t) {
        int count = 0;
        if (map.containsKey(t)) {
            count = map.get(t);
        }
        if (count == 0) {
            return 0;
        } else if (count == 1) {
            map.remove(t);
        } else {
            map.put(t, count - 1);
        }
        return count;
    }

    //количество разных элементов
    @Override
    public int size() {
        return map.size();
    }

    //Добавить все элементы из source в текущий контейнер, при совпадении ключей, суммировать значения
    @Override
    public void addAll(CountMap<? extends T> source) {
        for (T t : source.toMap().keySet()) {
            map.put(t, map.get(t) + source.toMap().get(t));
        }
    }

    //Вернуть java.util.Map. ключ - добавленный элемент, значение - количество его добавлений
    @Override
    public Map<T, Integer> toMap() {
        return map;
    }

    //Тот же самый контракт как и toMap(), только всю информацию записать в destination
    @Override
    public void toMap(Map<? super T, Integer> destination) {
        destination.putAll(map);
    }
}
