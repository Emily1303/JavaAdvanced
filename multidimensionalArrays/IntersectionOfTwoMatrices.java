package multidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class IntersectionOfTwoMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine());
        int cols = Integer.parseInt(scanner.nextLine());

        String[][] matrixA = new String[rows][cols];
        String[][] matrixB = new String[rows][cols];

        filingMatrices(scanner, matrixA);
        filingMatrices(scanner, matrixB);

        String[][] matrixC = new String[rows][cols];
        filingTheThirdMatrix(rows, cols, matrixA, matrixB, matrixC);

        for (int r = 0; r < matrixC.length; r++) {
            for (int c = 0; c < matrixC[r].length; c++) {
                System.out.print(matrixC[r][c] + " ");
            }
            System.out.println();
        }
    }

    private static void filingMatrices(Scanner scanner, String[][] matrix) {
        for (int r = 0; r < matrix.length; r++) {
            matrix[r] = scanner.nextLine().split("\\s+");
        }
    }

    private static void filingTheThirdMatrix (int rows, int cols, String[][] matrixA, String[][] matrixB, String[][] matrixC) {
        for (int r = 0; r < matrixC.length; r++) {
            for (int c = 0; c < matrixC[r].length; c++) {
                String currentElementMatrixA = matrixA[r][c];
                String currentElementMatrixB = matrixB[r][c];

                if (currentElementMatrixA.equals(currentElementMatrixB)) {
                    matrixC[r][c] = currentElementMatrixA;
                } else {
                    matrixC[r][c] = "*";
                }
            }
        }
    }
}
