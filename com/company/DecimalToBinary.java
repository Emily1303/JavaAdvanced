package com.company;

import java.util.ArrayDeque;
import java.util.Scanner;

public class DecimalToBinary {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int decimalNumber = Integer.parseInt(scanner.nextLine());

        ArrayDeque<Integer> binaryNumber = new ArrayDeque<>();

        while (decimalNumber != 0) {
            binaryNumber.push(decimalNumber % 2);
            decimalNumber /= 2;
        }

        while (!binaryNumber.isEmpty()) {
            System.out.print(binaryNumber.pop());
        }
    }
}
