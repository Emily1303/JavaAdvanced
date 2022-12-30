package multidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class CompareMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensionsMatrix1 = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        int rows1 = dimensionsMatrix1[0];
        int cols1 = dimensionsMatrix1[1];

        int[][] matrix1 = new int[rows1][cols1];

        for (int r = 0; r < rows1; r++) {
            matrix1[r] = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt).toArray();
        }

        int[] dimensionMatrix2 = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        int rows2 = dimensionMatrix2[0];
        int cols2 = dimensionMatrix2[1];

        int[][] matrix2 = new int[rows2][cols2];

        for (int r = 0; r < rows2; r++) {
            matrix2[r] = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt).toArray();
        }

        boolean areMatricesEqual = compareTwoMatrices(matrix1, matrix2, cols1, cols2);

        if (areMatricesEqual) {
            System.out.println("equal");
        } else {
            System.out.println("not equal");
        }
    }

    private static boolean compareTwoMatrices(int[][] matrix1, int[][] matrix2, int cols1, int cols2) {
        boolean areEqual = true;

        if (matrix1.length != matrix2.length || cols1 != cols2) {
            return areEqual = false;
        }

        for (int r = 0; r < matrix1.length; r++) {
            for (int c = 0; c < matrix1[r].length; c++) {
                int currentMatrix1Element = matrix1[r][c];
                int currentMatrix2Element = matrix2[r][c];

                if (currentMatrix1Element != currentMatrix2Element) {
                    areEqual = false;
                }
            }
        }

        return areEqual;
    }
}
