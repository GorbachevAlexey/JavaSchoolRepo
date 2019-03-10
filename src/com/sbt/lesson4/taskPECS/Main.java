package com.sbt.lesson4.taskPECS;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(8,1,3,5,6,4);
        List<Integer> list2 = CollectionUtils.range(list,3,6);
        System.out.println(list2);

    }
}
