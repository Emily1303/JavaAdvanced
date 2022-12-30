package streamsFilesAndDirectories;

import java.io.File;

public class ListFiles {
    public static void main(String[] args) {

        String path = "C:\\Users\\Емили\\Desktop\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\Files-and-Streams";
        File file = new File(path);

        File[] files = file.listFiles();

        for (File f : files) {
            if (!f.isDirectory()) {
                System.out.printf("%s: [%s]%n", f.getName(), f.length());
            }
        }

    }
}
