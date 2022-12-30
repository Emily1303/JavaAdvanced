package com.company;

import java.util.ArrayDeque;
import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> queue = new ArrayDeque<>();

        queue.offer(13);
        queue.offer(26);
        queue.offer(33);

        queue.poll();

        for (int integer : queue) {
            System.out.println(integer);
        }

    }
}
