package com.company;

import java.util.ArrayDeque;
import java.util.Scanner;

public class SimpleCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        String[] inputLine = input.split("\\s+");

        ArrayDeque<Integer> calculator = new ArrayDeque<>();

        for (int i = 0; i < inputLine.length; i++) {
            String currentSymbol = inputLine[i];
            int currentNumber = 0;
            if (!currentSymbol.equals("+") && !currentSymbol.equals("-")) {
                currentNumber = Integer.parseInt(currentSymbol);
                calculator.push(currentNumber);
            } else {
                int peekedNumber = calculator.peek();
                calculator.pop();
                if (currentSymbol.equals("+")) {
                    if (i + 1 < inputLine.length) {
                        currentNumber = Integer.parseInt(inputLine[i + 1]);
                        int newNumber = peekedNumber + currentNumber;
                        calculator.push(newNumber);
                        i += 1;
                    } else {
                        break;
                    }
                } else {
                    if (i + 1 < inputLine.length) {
                        currentNumber = Integer.parseInt(inputLine[i + 1]);
                        int newNumber1 = peekedNumber - currentNumber;
                        calculator.push(newNumber1);
                        i += 1;
                    } else {
                        break;
                    }
                }

            }

        }

        for (int integer : calculator) {
            System.out.println(integer);
        }

    }
}
