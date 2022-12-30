package streamsFilesAndDirectoriesExercise;

import java.io.*;

public class AllCapitals {
    public static void main(String[] args) throws IOException {

        String path = "src/resources/input.txt";

        FileReader reader = new FileReader(path);

        BufferedReader bufferedReader = new BufferedReader(reader);
        String line = bufferedReader.readLine();

        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("output.txt"));

        while (line != null) {
            String newLine = line.toUpperCase();
            bufferedWriter.write(newLine);
            bufferedWriter.newLine();

            line = bufferedReader.readLine();
        }

        reader.close();
        bufferedReader.close();
        bufferedWriter.close();
    }
}
