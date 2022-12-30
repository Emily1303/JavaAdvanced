package com.company;

import java.util.ArrayDeque;
import java.util.Scanner;

public class HotPotato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String names = scanner.nextLine();
        int times = Integer.parseInt(scanner.nextLine());

        ArrayDeque<String> allPeople = new ArrayDeque<>();

        String[] inputLine = names.split("\\s+");
        for (int i = 0; i < inputLine.length; i++) {
            String currentName = inputLine[i];
            allPeople.offer(currentName);
        }

        while (allPeople.size() != 1) {
            for (int i = 1; i <= times; i++) {
                String polledName = allPeople.poll();
                if (i == times) {
                    System.out.println("Removed " + polledName);
                } else {
                    allPeople.offer(polledName);
                }

            }
        }

        String lastName = allPeople.peek();
        System.out.println("Last is " + lastName);
    }
}
