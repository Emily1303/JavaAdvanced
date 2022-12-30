package functionalProgramming;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class SortEvenNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(", ");

        Predicate<Integer> predicate = n -> n % 2 == 0;

        System.out.println(Arrays.stream(input).map(Integer::parseInt).
                filter(predicate).map(String::valueOf).collect(Collectors.joining(", ")));

        System.out.println(Arrays.stream(input).map(Integer::parseInt).filter(predicate)
                .sorted(Integer::compareTo).map(String::valueOf).collect(Collectors.joining(", ")));
    }
}
