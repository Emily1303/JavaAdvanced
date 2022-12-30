package multidimensionalArraysExercise;

import java.util.Scanner;

public class FillTheMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(", ");

        int dimensions = Integer.parseInt(input[0]);
        String pattern = input[1];

        int[][] matrix = new int[dimensions][dimensions];

        switch (pattern) {
            case "A":
                fillingMatrixA(matrix, dimensions);
                break;
            case "B":
                fillingMatrixB(matrix, dimensions);
                break;
        }
    }

    private static void fillingMatrixA(int[][] matrix, int dimensions) {
        int counter = 1;

        for (int c = 0; c < dimensions; c++) {
            for (int r = 0; r < dimensions; r++) {
                matrix[r][c] = counter;
                counter++;
            }
        }

        printMatrix(matrix);
    }

    private static void fillingMatrixB(int[][] matrix, int dimnesions) {
        int counter = 1;

        for (int c = 0; c < dimnesions; c++) {
            if (c % 2 == 0) {
                for (int r = 0; r < dimnesions; r++) {
                    matrix[r][c] = counter;
                    counter++;
                }
            } else {
                for (int r = matrix.length - 1; r >= 0 ; r--) {
                    matrix[r][c] = counter;
                    counter++;
                }
            }

        }

        printMatrix(matrix);
    }

    private static void printMatrix (int[][] matrix) {
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                System.out.print(matrix[r][c] + " ");
            }
            System.out.println();
        }
    }
}
