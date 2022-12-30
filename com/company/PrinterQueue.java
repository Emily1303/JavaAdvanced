package com.company;

import java.util.ArrayDeque;
import java.util.Scanner;

public class PrinterQueue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        ArrayDeque<String> printerQueue = new ArrayDeque<>();

        String currentFile = null;
        while (!input.equals("print")) {
            if (input.equals("cancel")) {
                if (printerQueue.isEmpty()) {
                    System.out.println("Printer is on standby");
                } else {
                    System.out.println("Canceled " + printerQueue.poll());
                }

            } else {
                currentFile = input;
                printerQueue.offer(currentFile);
            }

            input = scanner.nextLine();
        }

        for (String item : printerQueue) {
            System.out.println(item);
        }
    }
}
