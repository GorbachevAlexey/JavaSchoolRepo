package com.sbt.lesson4.taskPECS;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CollectionUtils {
    public static <T> void addAll(List<? extends T> source, List<? super T> destination) {
        destination.addAll(source);
    }

    public static <T> List<T> newArrayList() {
        return new ArrayList<>();
    }

    public static <T> int indexOf(List<? extends T> source, T t) {
        return source.indexOf(t);
    }

    public static <T> List<T> limit(List<? extends T> source, int size) {
        return new ArrayList<>(source.subList(0, size));
    }

    public static <T> void add(List<? super T> source, T t) {
        source.add(t);
    }

    public static <T> void removeAll(List<? super T> removeFrom, List<? extends T> c2) {
        for (T t : c2) {
            removeFrom.remove(t);
        }
    }

    //true если первый лист содержит все элементы второго
    public static <T> boolean containsAll(List<T> c1, List<T> c2) {
        return c1.containsAll(c2);
    }

    //true если первый лист содержит хотя-бы 1 второго
    public static <T> boolean containsAny(List<T> c1, List<T> c2) {
        for (T t : c2) {
            if (c1.contains(t)) {
                return true;
            }
        }
        return false;
    }

    //Возвращает лист, содержащий элементы из входного листа в диапазоне от min до max.
    // Элементы сравнивать через Comparable.
    // Прмер range(Arrays.asList(8,1,3,5,6, 4), 3, 6) вернет {3,4,5,6}
    public static<T extends Comparable<T>> List<T> range(List<? extends T> list, T min, T max) {
        Collections.sort(list);
        return new ArrayList<>(list.subList(list.indexOf(min), list.indexOf(max) + 1));
        }

    //Возвращает лист, содержащий элементы из входного листа в диапазоне от min до max.
    // Элементы сравнивать через Comparable.
    // Прмер range(Arrays.asList(8,1,3,5,6, 4), 3, 6) вернет {3,4,5,6}
    public static<T extends  Comparable<T>> List range(List<? extends T> list, T min, T max, Comparator<? super T> comparator) {
        list.sort(comparator);
        return new ArrayList<>(list.subList(list.indexOf(min), list.indexOf(max) + 1));
    }

}
