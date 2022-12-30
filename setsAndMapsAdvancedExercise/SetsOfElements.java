package setsAndMapsAdvancedExercise;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class SetsOfElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        Set<Integer> firstSet = new LinkedHashSet<>();
        Set<Integer> secondSet = new LinkedHashSet<>();

        for (int f = 0; f < dimensions[0]; f++) {
            firstSet.add(Integer.parseInt(scanner.nextLine()));
        }

        for (int s = 0; s < dimensions[1]; s++) {
            secondSet.add(Integer.parseInt(scanner.nextLine()));
        }

        firstSet.retainAll(secondSet);

        firstSet.forEach(element -> System.out.print(element + " "));
    }
}
