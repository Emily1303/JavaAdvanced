package setsAndMapsAdvancedExercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class PopulationCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<String, Map<String, Integer>> countriesMap = new LinkedHashMap<>();

        while (!input.equals("report")) {
            String[] inputLine = input.split("\\|");
            String city = inputLine[0];
            String country = inputLine[1];
            int populationPerCity = Integer.parseInt(inputLine[2]);

            if (!countriesMap.containsKey(country)) {
                countriesMap.put(country, new LinkedHashMap<>());
            }

            countriesMap.get(country).put(city, populationPerCity);

            input = scanner.nextLine();
        }

        Map<String, Integer> populationCountries = new LinkedHashMap<>();

        for (int i = 0; i < countriesMap.size(); i++) {
            for (String c : countriesMap.keySet()) {
                int totalPopulationByCountry = getPopulationPerCountry(countriesMap, c);

                populationCountries.put(c, totalPopulationByCountry);
            }

        }

        populationCountries.entrySet().stream().sorted((n1, n2) -> n2.getValue().compareTo(n1.getValue()))
                .forEach(e -> {
                    System.out.printf("%s (total population: %d)%n", e.getKey(), e.getValue());
                    countriesMap.get(e.getKey()).entrySet().stream().sorted((n1, n2) -> n2.getValue().compareTo(n1.getValue()))
                            .forEach(e1 -> System.out.printf("=>%s: %d%n", e1.getKey(), e1.getValue()));
                });

    }

    private static int getPopulationPerCountry (Map<String, Map<String, Integer>> countries, String country) {
        int population = 0;

        for (var entry : countries.get(country).entrySet()) {
            population += entry.getValue();
        }

        return population;
    }
}
