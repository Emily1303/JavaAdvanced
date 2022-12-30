package multidimensionalArrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class WrongMeasurements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine());

        int[][] matrix = new int[rows][];
        for (int r = 0; r < matrix.length; r++) {
            matrix[r] = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt).toArray();
        }

        int[] positionWrongNumbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        int wrongNumber = matrix[positionWrongNumbers[0]][positionWrongNumbers[1]];

        printNewMatrix(matrix, wrongNumber);
    }

    private static void printNewMatrix(int[][] matrix, int wrongNumber) {
        int sum = 0;

        List<int[]> newNumber = new ArrayList<>();

        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                int currentNumber = matrix[r][c];
                if (currentNumber == wrongNumber) {
                   sum = findNewNumber(matrix, r, c);
                   int[] number = new int[3];
                   number[0] = sum;
                   number[1] = r;
                   number[2] = c;
                   newNumber.add(number);
                }
            }
        }

        fillNewNumbers(matrix, newNumber);
    }

    private static int findNewNumber(int[][] matrix, int row, int col) {
        int sumNewNumber = 0;
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                r = row;
                c = col;

                int wrong = matrix[row][col];
                if (r + 1 < matrix.length && matrix[r + 1][c] != wrong) {
                    sumNewNumber += matrix[r + 1][c];
                }

                if (r - 1 >= 0 && r - 1 < matrix.length && matrix[r - 1][c] != wrong) {
                    sumNewNumber += matrix[r - 1][c];
                }

                if (c + 1 < matrix[r].length && matrix[r][c + 1] != wrong) {
                    sumNewNumber += matrix[r][c + 1];
                }

                if (c - 1 >= 0 && c - 1 < matrix[r].length && matrix[r][c - 1] != wrong) {
                    sumNewNumber += matrix[r][c - 1];
                }

                return sumNewNumber;
            }
        }
        return sumNewNumber;
    }

    private static void fillNewNumbers(int[][] matrix, List<int[]> newNumbers) {
        for (int[] array : newNumbers) {
            int row = array[1];
            int col = array[2];
            int sum = array[0];

            matrix[row][col] = sum;
        }

        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                System.out.printf("%d ", matrix[r][c]);
            }
            System.out.println();
        }
    }
}
