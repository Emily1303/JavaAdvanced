package streamsFilesAndDirectoriesExercise;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class SumLines {
    public static void main(String[] args) throws IOException {

        String path = "src/resources/input.txt";

        FileReader reader = new FileReader(path);
        BufferedReader bufferedReader = new BufferedReader(reader);

        String line = bufferedReader.readLine();

        while (line != null) {
            int sum = 0;

            for (int i = 0; i < line.length(); i++) {
                int currentSymbol = line.charAt(i);
                sum += currentSymbol;
            }

            System.out.println(sum);

            line = bufferedReader.readLine();
        }

        reader.close();
        bufferedReader.close();
    }
}
