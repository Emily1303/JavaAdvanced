package streamsFilesAndDirectories;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class SortLines {
    public static void main(String[] args) throws IOException {

        Path path = Paths.get("C:\\Users\\Емили\\Desktop\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt");

        List<String> lines = Files.lines(path).sorted().collect(Collectors.toList());

        Files.write(Paths.get("output.txt"), lines);

    }
}
