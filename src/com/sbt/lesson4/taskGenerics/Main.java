package com.sbt.lesson4.taskGenerics;

public class Main {
    public static void main(String[] args) {
        CountMap<Integer> map = new CountMapIml<>();

        map.add(10);
        map.add(10);
        map.add(5);
        map.add(6);
        map.add(5);
        map.add(10);

        int count = map.getCount(5); // 2
        System.out.println(count);
        count = map.getCount(6); // 1
        System.out.println(count);
        count = map.getCount(10); // 3
        System.out.println(count);
    }
}
