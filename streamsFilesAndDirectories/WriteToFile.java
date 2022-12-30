package streamsFilesAndDirectories;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Set;

public class WriteToFile {
    public static void main(String[] args) throws IOException {

        String path = "C:\\Users\\Емили\\Desktop\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";

        FileInputStream inputStream = new FileInputStream(path);
        int bytes = inputStream.read();

        Set<Character> isSkipped = Set.of(',', '.', '!', '?');

        FileOutputStream outputStream = new FileOutputStream("output.txt");

        while (bytes != -1) {
            char symbol = (char) bytes;

            if (!isSkipped.contains(symbol)) {
                outputStream.write(symbol);
            }

            bytes = inputStream.read();
        }

        inputStream.close();
        outputStream.close();
    }
}
