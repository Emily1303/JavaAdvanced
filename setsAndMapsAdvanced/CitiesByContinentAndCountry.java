package setsAndMapsAdvanced;

import java.util.*;

public class CitiesByContinentAndCountry {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int iterations = Integer.parseInt(scanner.nextLine());

        Map<String, LinkedHashMap<String, List<String>>> continents = new LinkedHashMap<>();

        for (int i = 1; i <= iterations; i++) {
            String[] input = scanner.nextLine().split("\\s+");

            String continent = input[0];
            String country = input[1];
            String city = input[2];

            if (!continents.containsKey(continent)) {
                continents.putIfAbsent(continent, new LinkedHashMap<>());
            }

            if (!continents.get(continent).containsKey(country)) {
                continents.get(continent).putIfAbsent(country, new ArrayList<>());
            }

            continents.get(continent).get(country).add(city);
        }

        for (Map.Entry<String, LinkedHashMap<String, List<String>>> entry : continents.entrySet()) {
            System.out.printf("%s:%n", entry.getKey());
            for (Map.Entry<String, List<String>> doubleEntry : entry.getValue().entrySet()) {
                System.out.printf("  %s -> ", doubleEntry.getKey());
                printList(doubleEntry.getValue());
                System.out.println();
            }

        }

    }

    public static void printList (List<String> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            System.out.print(list.get(i) + ", ");
        }

        System.out.print(list.get(list.size() - 1));
    }
}
