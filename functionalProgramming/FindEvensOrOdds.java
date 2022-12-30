package functionalProgramming;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FindEvensOrOdds {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] bounds = scanner.nextLine().split("\\s+");

        int start = Integer.parseInt(bounds[0]);
        int end = Integer.parseInt(bounds[1]);

        List<Integer> numbers = IntStream.rangeClosed(start, end).boxed().collect(Collectors.toList());

        String condition = scanner.nextLine();

        Predicate<Integer> predicate = getEvenOrOddNumbersOnly(condition);
        Consumer<Integer> consumer = n -> System.out.print(n + " ");

        numbers.stream().filter(predicate).forEach(consumer);
    }

    private static Predicate<Integer> getEvenOrOddNumbersOnly (String condition) {
        switch (condition) {
            case "even":
                return n -> n % 2 == 0;
            case "odd":
                return n -> n % 2 != 0;
        }

        return null;
    }
}
