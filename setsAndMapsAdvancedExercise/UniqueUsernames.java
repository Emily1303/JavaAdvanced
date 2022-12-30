package setsAndMapsAdvancedExercise;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class UniqueUsernames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int insertions = Integer.parseInt(scanner.nextLine());

        Set<String> usernames = new LinkedHashSet<>();

        for (int i = 1; i <= insertions; i++) {
            String input = scanner.nextLine();

            usernames.add(input);
        }

        usernames.forEach(element -> System.out.println(element));
    }
}
