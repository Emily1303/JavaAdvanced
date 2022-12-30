package streamsFilesAndDirectories;

import java.io.*;

public class WriteEveryThirdLine {
    public static void main(String[] args) throws IOException {

        String path = "C:\\Users\\Емили\\Desktop\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";

        FileInputStream inputStream = new FileInputStream(path);

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String line = bufferedReader.readLine();

        int counter = 1;

        FileOutputStream outputStream = new FileOutputStream("output.txt");
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream));

        while (line != null) {
            if (counter % 3 == 0) {
                writer.write(line);
                writer.newLine();
            }

            counter++;
            line = bufferedReader.readLine();
        }

        writer.flush();
        writer.close();
        bufferedReader.close();
        inputStream.close();
        outputStream.close();
    }
}
