package setsAndMapsAdvancedExercise;

import java.util.Collections;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class PeriodicTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int compounds = Integer.parseInt(scanner.nextLine());

        Set<String> elements = new TreeSet<>();

        for (int i = 0; i < compounds; i++) {
            String[] input = scanner.nextLine().split("\\s+");

            Collections.addAll(elements, input);
        }

        elements.forEach(element -> System.out.print(element + " "));
    }
}
