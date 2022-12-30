package multidimensionalArraysExercise;

import java.util.Arrays;
import java.util.Scanner;

public class MatrixOfPalindromes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] input = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        int rows = input[0];
        int cols = input[1];

        String[][] matrix = new String[rows][cols];

        fillingTheMatrix(matrix);
    }

    private static void fillingTheMatrix (String[][] matrix) {
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                char firstAndLast = (char) ('a' + r);
                char middle = (char) ('a' + r + c);

                matrix[r][c] = "" + firstAndLast + middle + firstAndLast;
            }
        }

        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                System.out.print(matrix[r][c] + " ");
            }
            System.out.println();
        }
    }
}
