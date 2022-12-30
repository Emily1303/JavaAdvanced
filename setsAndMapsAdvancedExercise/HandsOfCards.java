package setsAndMapsAdvancedExercise;

import java.util.*;

public class HandsOfCards {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<String, Set<String>> cardsPerPerson = new LinkedHashMap<>();

        while (!input.equals("JOKER")) {
            String[] inputLine = input.split(": ");
            String name = inputLine[0];
            String[] cards = inputLine[1].split(", ");

            cardsPerPerson.putIfAbsent(name, new HashSet<>());
            Collections.addAll(cardsPerPerson.get(name), cards);

            input = scanner.nextLine();
        }

        cardsPerPerson.keySet().forEach((key) ->
                System.out.printf("%s: %d%n", key, calculatePoints(cardsPerPerson, key)));
    }

    private static int calculatePoints(Map<String, Set<String>> cardsPerPerson, String name) {
        int sumOfAllPoints = 0;

        for (String card : cardsPerPerson.get(name)) {
            String type = card.substring(card.length() - 1);
            String power = card.substring(0, card.length() - 1);
            sumOfAllPoints = sumOfAllPoints + getPointsByPower(power) * getPointsByType(type);
        }

        return sumOfAllPoints;
    }

    private static int getPointsByPower (String power) {
        int points = 0;

        switch (power) {
            case "2":
                points = 2;
                break;
            case "3":
                points = 3;
                break;
            case "4":
                points = 4;
                break;
            case "5":
                points = 5;
                break;
            case "6":
                points = 6;
                break;
            case "7":
                points = 7;
                break;
            case "8":
                points = 8;
                break;
            case "9":
                points = 9;
                break;
            case "10":
                points = 10;
                break;
            case "J":
                points = 11;
                break;
            case "Q":
                points = 12;
                break;
            case "K":
                points = 13;
                break;
            case "A":
                points = 14;
                break;
        }

        return points;
    }

    private static int getPointsByType (String type) {
        int points = 0;

        switch (type) {
            case "S":
                points = 4;
                break;
            case "H":
                points = 3;
                break;
            case "D":
                points = 2;
                break;
            case "C":
                points = 1;
                break;
        }

        return points;
    }
}
