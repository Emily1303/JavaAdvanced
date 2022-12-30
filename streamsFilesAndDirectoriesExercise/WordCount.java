package streamsFilesAndDirectoriesExercise;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class WordCount {
    public static void main(String[] args) throws IOException {

        String firstPath = "src/resources/words.txt";

        BufferedReader bufferedReader = new BufferedReader(new FileReader(firstPath));
        String words = bufferedReader.readLine();
        String[] wordsLine = words.split(" ");

        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < wordsLine.length; i++) {
            String currentWord = wordsLine[i];
            map.put(currentWord, 0);
        }

        String secondPath = "src/resources/text.txt";
        Scanner scanner = new Scanner(new FileReader(secondPath));
        String current = scanner.next().toLowerCase();

        while (scanner.hasNext()) {
            if (map.containsKey(current)) {
                int value = map.get(current);
                map.put(current, value + 1);
            }

            current = scanner.next();
        }

        PrintWriter printer = new PrintWriter(new FileWriter("results.txt"));

        map.entrySet().stream().sorted((left, right) -> right.getValue().compareTo(left.getValue()))
                .forEach(element -> printer.println(element.getKey() + " - " + element.getValue()));

        printer.close();
        bufferedReader.close();
    }
}
