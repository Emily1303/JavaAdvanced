package com.company;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistoryUpgrade {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        String currentUrl = null;
        String nextUrl = null;

        ArrayDeque<String> historyStack = new ArrayDeque<>();
        ArrayDeque<String> historyQueue = new ArrayDeque<>();

        while (!input.equals("Home")) {
            if (input.equals("back")) {
                if (historyStack.isEmpty()) {
                    System.out.println("no previous URLs");
                    input = scanner.nextLine();
                    continue;
                } else {
                    historyQueue.offer(currentUrl);
                    currentUrl = historyStack.pop();
                }

            } else if (input.equals("forward")) {
                if (historyQueue.isEmpty()) {
                    System.out.println("no next URLs");
                    input = scanner.nextLine();
                    continue;
                } else {
                    currentUrl = historyQueue.poll();
                }

            } else {
                if (currentUrl != null) {
                    historyStack.push(currentUrl);
                }

               currentUrl = input;
            }

            System.out.println(currentUrl);
            input = scanner.nextLine();
        }
    }
}
