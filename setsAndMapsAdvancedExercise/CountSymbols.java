package setsAndMapsAdvancedExercise;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class CountSymbols {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<Character, Integer> occurrences = new TreeMap<>();

        for (int i = 0; i < input.length(); i++) {
            char currentSymbol = input.charAt(i);

            if (!occurrences.containsKey(currentSymbol)) {
                occurrences.putIfAbsent(currentSymbol, 1);
            } else {
                int numberOcc = occurrences.get(currentSymbol);
                occurrences.put(currentSymbol, numberOcc + 1);
            }
        }

        occurrences.forEach((key, value) -> System.out.printf("%c: %d time/s%n", key, value));
    }
}
