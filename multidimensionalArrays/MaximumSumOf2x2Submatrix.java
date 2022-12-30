package multidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class MaximumSumOf2x2Submatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt).toArray();

        int[][] matrix = new int[dimensions[0]][dimensions[1]];

        for (int r = 0; r < matrix.length; r++) {
            matrix[r] = Arrays.stream(scanner.nextLine().split(", "))
                    .mapToInt(Integer::parseInt).toArray();
        }

        int sum = theBiggestSum(matrix);

        System.out.println(sum);
    }

    private static int theBiggestSum (int[][] matrix) {
        int biggestSum = Integer.MIN_VALUE;
        int sumOfElements = 0;

        int[][] newMatrix = new int[2][2];

        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                if (r + 1 < matrix.length && c + 1 < matrix[r].length) {
                    sumOfElements = matrix[r][c] + matrix[r][c + 1]
                            + matrix[r + 1][c] + matrix[r + 1][c+ 1];

                    if (sumOfElements > biggestSum) {
                        biggestSum = sumOfElements;

                        newMatrix[0][0] = matrix[r][c];
                        newMatrix[0][1] = matrix[r][c + 1];
                        newMatrix[1][0] = matrix[r + 1][c];
                        newMatrix[1][1] = matrix[r + 1][c + 1];
                    }

                }
            }
        }

        printMatrix(newMatrix);
        return biggestSum;
    }

    private static void printMatrix (int[][] matrix) {
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                System.out.printf("%d ", matrix[r][c]);
            }
            System.out.println();
        }
    }
}
