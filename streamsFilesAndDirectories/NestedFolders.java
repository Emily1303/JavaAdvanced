package streamsFilesAndDirectories;

import java.io.File;
import java.util.ArrayDeque;

public class NestedFolders {
    public static void main(String[] args) {

        String path = "C:\\Users\\Емили\\Desktop\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\Files-and-Streams";

        File root = new File(path);

        int counter = 0;

        ArrayDeque<File> queue = new ArrayDeque<>();

        queue.offer(root);
        while (!queue.isEmpty()) {
            File currentFile = queue.poll();
            File[] files = currentFile.listFiles();

            for (File f : files) {
                if (f.isDirectory()) {
                    queue.offer(f);
                }
            }

            System.out.println(currentFile.getName());
            counter++;
        }

        System.out.println(counter + " folders");
    }
}
