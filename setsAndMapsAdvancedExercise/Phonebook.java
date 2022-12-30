package setsAndMapsAdvancedExercise;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Phonebook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<String, String> phonebook = new HashMap<>();

        while (!input.equals("search")) {
            String[] inputLine = input.split("-");
            String name = inputLine[0];
            String number = inputLine[1];

            if (phonebook.containsKey(name)) {
                phonebook.put(name, number);
            } else {
                phonebook.putIfAbsent(name, number);
            }

            input = scanner.nextLine();
        }

        input = scanner.nextLine();

        while (!input.equals("stop")) {
            boolean isFound = false;

            for (Map.Entry<String, String> entry : phonebook.entrySet()) {
                if (input.equals(entry.getKey())) {
                    isFound = true;
                    break;
                }
            }

            if (isFound) {
                System.out.printf("%s -> %s%n", input, phonebook.get(input));
            } else {
                System.out.printf("Contact %s does not exist.%n", input);
            }

            input = scanner.nextLine();
        }
    }
}
