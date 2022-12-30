package functionalProgramming;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.UnaryOperator;

public class AddVAT {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(", ");

        UnaryOperator<Double> operator = n -> n * 1.20;
        Consumer<Double> consumer = n -> System.out.printf("%.2f%n", n);

        System.out.println("Prices with VAT:");
        Arrays.stream(input).map(Double::parseDouble).map(operator).forEach(consumer);

    }
}
