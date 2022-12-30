package streamsFilesAndDirectories;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class ReadFile {
    public static void main(String[] args) throws IOException {

        String path = "C:\\Users\\Емили\\Desktop\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";

        FileInputStream inputStream = new FileInputStream(path);

        Scanner scanner = new Scanner(inputStream);

        int bytes = inputStream.read();

        while (bytes != -1) {
            System.out.printf("%s ", Integer.toBinaryString(bytes));

            bytes = inputStream.read();
        }

        inputStream.close();
    }
}
