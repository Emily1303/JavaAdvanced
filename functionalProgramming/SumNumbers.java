package functionalProgramming;

import java.util.Arrays;
import java.util.Scanner;

public class SumNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(", ");

        long count = Arrays.stream(input).count();

        long sum = Arrays.stream(input).mapToInt(Integer::parseInt).sum();

        System.out.println("Count = " + count);
        System.out.println("Sum = " + sum);
    }
}
