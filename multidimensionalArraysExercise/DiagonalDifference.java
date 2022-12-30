package multidimensionalArraysExercise;

import java.util.Arrays;
import java.util.Scanner;

public class DiagonalDifference {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());

        int[][] matrix = new int[size][size];
        for (int r = 0; r < matrix.length; r++) {
            matrix[r] = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt).toArray();
        }

        int firstSum = sumOfFirstDiagonal(matrix, size);
        int secondSum = sumSecondDiagonal(matrix, size);

        int diff = Math.abs(firstSum - secondSum);

        System.out.println(diff);
    }

    private static int sumOfFirstDiagonal(int[][] matrix, int size) {
        int sum = 0;

        for (int index = 0; index < size; index++) {
            sum = sum + matrix[index][index];
        }

        return sum;
    }

    private static int sumSecondDiagonal (int[][] matrix, int size) {
        int sum = 0;
        int col = 0;

        for (int r = matrix.length - 1; r >= 0; r--) {
            sum = sum + matrix[r][col];
            col++;
        }

        return sum;
    }
}
