package streamsFilesAndDirectoriesExercise;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyAPicture {
    public static void main(String[] args) throws IOException {

        String path = "src/streamsFilesAndDirectoriesExercise/img.jpg";

        FileInputStream inputStream = new FileInputStream(path);
        FileOutputStream outputStream = new FileOutputStream("picture-copy.jpg");

        byte[] buffer = new byte[1024];

        while (inputStream.read(buffer) != -1) {
            outputStream.write(buffer);
        }

        inputStream.close();
        outputStream.close();
    }
}
