package com.sbt.lesson3.task2057;

import java.io.IOException;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        List<Integer> list = new ArrayList<>();
        List<Integer> outputList = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            int current = scanner.nextInt();
            if (current == 1) {
                list.add(scanner.nextInt());
            } else {
                Collections.sort(list);
                outputList.add(list.get(0));
                list.remove(0);
            }
        }

        for (Integer output : outputList) {
            System.out.println(output);
        }
    }
}

