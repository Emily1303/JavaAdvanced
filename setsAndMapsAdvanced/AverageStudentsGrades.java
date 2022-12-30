package setsAndMapsAdvanced;

import java.util.*;
import java.util.function.DoublePredicate;

public class AverageStudentsGrades {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int iterations = Integer.parseInt(scanner.nextLine());

        Map<String, List<Double>> students = new TreeMap<>();

        for (int i = 1; i <= iterations; i++) {
            String[] input = scanner.nextLine().split("\\s+");

            double grade = Double.parseDouble(input[1]);

            if (students.containsKey(input[0])) {
                students.get(input[0]).add(grade);
            } else {
                students.putIfAbsent(input[0], new ArrayList<>());
                students.get(input[0]).add(grade);
            }
        }

        for (Map.Entry<String, List<Double>> entry : students.entrySet()) {
            System.out.printf("%s -> ", entry.getKey());
            for (double grade : students.get(entry.getKey())) {
                System.out.printf("%.2f ", grade);
            }
            double average = findTheAverageGrade(students.get(entry.getKey()));

            System.out.printf("(avg: %.2f)", average);

            System.out.println();
        }

    }

    public static double findTheAverageGrade (List<Double> list) {
        double sum = 0;

        for (double grade : list) {
            sum += grade;
        }

        return sum / list.size();
    }
}
