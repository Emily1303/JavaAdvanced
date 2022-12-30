package functionalProgrammingExercise;

import java.util.Arrays;
import java.util.OptionalInt;
import java.util.Scanner;
import java.util.function.Function;

public class CustomMinFunction {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] input = Arrays.stream(scanner.nextLine().split("\\s+")).
                mapToInt(Integer::parseInt).toArray();

        Function<int[], Integer> min = n -> {
            Arrays.stream(input).map(p -> {
                int minNumber = Integer.MAX_VALUE;
                if (p < minNumber) {
                    minNumber = p;
                }
                return minNumber;
            }).forEach(System.out::println);

            return null;
        };
    }
}
