package streamsFilesAndDirectories;

import java.io.*;

public class CopyBytes {
    public static void main(String[] args) throws IOException {

        String path = "C:\\Users\\Емили\\Desktop\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";

        FileInputStream inputStream = new FileInputStream(path);
        FileOutputStream outputStream = new FileOutputStream("output.txt");
        PrintWriter printer = new PrintWriter(outputStream);

        int bytes = inputStream.read();

        while (bytes != -1) {
            if (bytes == 32) {
               printer.print((char) bytes);
            } else if (bytes == 10) {
                printer.print((char) bytes);
            } else {
                printer.print(bytes);
            }

            bytes = inputStream.read();
        }

        printer.close();
        inputStream.close();
        outputStream.close();
    }
}
