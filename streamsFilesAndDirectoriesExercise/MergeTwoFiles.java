package streamsFilesAndDirectoriesExercise;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class MergeTwoFiles {
    public static void main(String[] args) throws IOException {

        Path path1 = Paths.get("src/resources/inputOne.txt");
        List<String> list1 = Files.readAllLines(path1);

        Path path2 = Paths.get("src/resources/inputTwo.txt");
        List<String> list2 = Files.readAllLines(path2);

        Files.write(Paths.get("output.txt"), list1);
        Files.write(Paths.get("output.txt"), list2, StandardOpenOption.APPEND);
    }
}
