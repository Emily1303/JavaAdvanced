package setsAndMapsAdvancedExercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class UserLogs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<String, Map<String, Integer>> userNames = new TreeMap<>();

        while (!input.equals("end")) {
            String[] inputLine = input.split("\\s+");
            String ip = inputLine[0].split("=")[1];
            String user = inputLine[2].split("=")[1];

            if (!userNames.containsKey(user)) {
                userNames.put(user, new LinkedHashMap<>());
            }

            if (!userNames.get(user).containsKey(ip)) {
                userNames.get(user).put(ip, 1);
            } else {
                int value = userNames.get(user).get(ip);
                userNames.get(user).put(ip, value + 1);
            }

            input = scanner.nextLine();
        }

        for (var entry : userNames.entrySet()) {
            System.out.printf("%s: %n", entry.getKey());

            StringBuilder stringBuilder = new StringBuilder();
            for (var secondEntry : entry.getValue().entrySet()) {
                stringBuilder.append(String.format("%s => %d, ", secondEntry.getKey(), secondEntry.getValue()));
            }

            String output = stringBuilder.substring(0, stringBuilder.length() - 2);
            System.out.println(output + ".");
        }


    }
}
