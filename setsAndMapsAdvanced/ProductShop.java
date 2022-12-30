package setsAndMapsAdvanced;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class ProductShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<String, LinkedHashMap<String, Double>> shops = new TreeMap<>();

        while (!input.equals("Revision")) {
            String[] inputLine = input.split(", ");
            double price = Double.parseDouble(inputLine[2]);

            if (!shops.containsKey(inputLine[0])) {
                shops.putIfAbsent(inputLine[0], new LinkedHashMap<>());
            }

            shops.get(inputLine[0]).put(inputLine[1], price);

            input = scanner.nextLine();
        }

        for (Map.Entry<String, LinkedHashMap<String, Double>> entry : shops.entrySet()) {
            System.out.printf("%s->%n", entry.getKey());
            for (Map.Entry<String, Double> doubleEntry : shops.get(entry.getKey()).entrySet()) {
                System.out.printf("Product: %s, Price: %.1f%n", doubleEntry.getKey(), doubleEntry.getValue());
            }

        }

    }
}
