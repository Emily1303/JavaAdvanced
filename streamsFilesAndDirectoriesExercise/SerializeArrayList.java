package streamsFilesAndDirectoriesExercise;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SerializeArrayList {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        List<Double> list = new ArrayList<>();
        list.add(3.4);
        list.add(5.5);
        list.add(4.67);
        list.add(13.4);

        ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("list.ser"));
        outputStream.writeObject(list);

        ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("list.ser"));
        List list1 = (List) inputStream.readObject();

        for (Object l : list1) {
            System.out.println(l);
        }

        outputStream.close();
        inputStream.close();
    }
}
