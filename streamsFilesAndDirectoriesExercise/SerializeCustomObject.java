package streamsFilesAndDirectoriesExercise;

import java.io.*;

public class SerializeCustomObject {

    static class Course implements Serializable {

        String name;
        int numberOfStudents;
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Course course = new Course();
        course.name = "SoftUni";
        course.numberOfStudents = 13;

        ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("course.ser"));
        outputStream.writeObject(course);

        ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("course.ser"));
        Course courseObject = (Course) inputStream.readObject();

        System.out.println(courseObject.name);
        System.out.println(courseObject.numberOfStudents);

        outputStream.close();
        inputStream.close();
    }
}
