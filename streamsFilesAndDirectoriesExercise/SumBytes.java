package streamsFilesAndDirectoriesExercise;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class SumBytes {
    public static void main(String[] args) throws IOException {

        String path = "src/resources/input.txt";

        FileReader reader = new FileReader(path);

        BufferedReader bufferedReader = new BufferedReader(reader);

        String line = bufferedReader.readLine();

        long totalSum = 0;

        while (line != null) {
            for (int i = 0; i < line.length(); i++) {
                int currentSymbol = line.charAt(i);
                totalSum += currentSymbol;
            }

            line = bufferedReader.readLine();
        }

        System.out.println(totalSum);

        reader.close();
        bufferedReader.close();
    }
}
