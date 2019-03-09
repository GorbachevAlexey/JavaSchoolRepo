package com.sbt.lesson3.task2057;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        List<Integer> outputList = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            int current = scanner.nextInt();
            if (current == 1) {
                pq.add(scanner.nextInt());
            } else
                outputList.add(pq.poll());
        }

        for (Integer output : outputList) {
            System.out.println(output);
        }
    }
}

