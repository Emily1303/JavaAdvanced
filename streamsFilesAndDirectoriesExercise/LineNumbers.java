package streamsFilesAndDirectoriesExercise;

import java.io.*;

public class LineNumbers {
    public static void main(String[] args) throws IOException {

        String path = "src/resources/inputLineNumbers.txt";

        BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
        String line = bufferedReader.readLine();

        int counter = 1;

        PrintWriter printer = new PrintWriter("output.txt");

        while (line != null) {
            printer.println(counter + ". " + line);
            counter++;

            line = bufferedReader.readLine();
        }

        bufferedReader.close();
        printer.close();
    }
}
