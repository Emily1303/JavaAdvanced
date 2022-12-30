package com.company;

import java.util.ArrayDeque;
import java.util.Scanner;

public class MathPotato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] names = scanner.nextLine().split("\\s+");
        int times = Integer.parseInt(scanner.nextLine());

        ArrayDeque<String> namesQueue = new ArrayDeque<>();

        for (int i = 0; i < names.length; i++) {
            String currentName = names[i];
            namesQueue.offer(currentName);
        }

        int cycle = 1;
        while (namesQueue.size() > 1) {
            for (int i = 1; i < times; i++) {
                String polledName = namesQueue.poll();
                namesQueue.offer(polledName);
            }

            if (cycle % 2 != 0) {
                System.out.println("Removed " + namesQueue.poll());
            } else {
                System.out.println("Prime " + namesQueue.peek());
            }

            cycle++;
        }

        System.out.println("Last is " + namesQueue.poll());
    }
}
