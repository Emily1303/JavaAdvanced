package streamsFilesAndDirectoriesExercise;

import java.io.*;
import java.util.Set;

public class CountCharacterTypes {
    public static void main(String[] args) throws IOException {

        String path = "src/resources/input.txt";

        BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
        String line = bufferedReader.readLine();

        Set<Character> vowelsTable = Set.of('a', 'e', 'i', 'o', 'u');
        Set<Character> punctuation = Set.of('!', ',', '.', '?');

        int sumVowels = 0;
        int sumPunctuation = 0;
        int sumOtherSymbols = 0;

        while (line != null) {
            for (int i = 0; i < line.length(); i++) {
                char currentSymbol = line.charAt(i);

                if (vowelsTable.contains(currentSymbol)) {
                    sumVowels++;
                } else if (punctuation.contains(currentSymbol)) {
                    sumPunctuation++;
                } else if (currentSymbol != ' ') {
                    sumOtherSymbols++;
                }
            }

            line = bufferedReader.readLine();
        }

        PrintWriter printer = new PrintWriter("output.txt");
        printer.println("Vowels: " + sumVowels);
        printer.println("Other symbols: " + sumOtherSymbols);
        printer.println("Punctuation: " + sumPunctuation);

        bufferedReader.close();
        printer.close();
    }
}
