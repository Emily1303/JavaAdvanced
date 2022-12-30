package streamsFilesAndDirectoriesExercise;

import java.io.File;
import java.util.ArrayDeque;

public class GetFolderSize {
    public static void main(String[] args) {

        File root = new File("src/resources/Exercises Resources");

        ArrayDeque<File> queue = new ArrayDeque<>();

        queue.offer(root);

        long sum = 0;
        while (!queue.isEmpty()) {
            File current = queue.poll();

            File[] files = current.listFiles();
            for (File f : files) {
                if (f.isDirectory()) {
                    queue.offer(f);
                } else {
                    sum += f.length();
                }
            }

        }

        System.out.println("Folder size: " + sum);
    }
}
