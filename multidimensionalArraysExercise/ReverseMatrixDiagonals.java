package multidimensionalArraysExercise;

import java.util.Arrays;
import java.util.Scanner;

public class ReverseMatrixDiagonals {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        int rows = dimensions[0];
        int cols = dimensions[1];

        int[][] matrix = new int[rows][cols];

        for (int r = 0; r < matrix.length; r++) {
            matrix[r] = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt).toArray();
        }

        printMatrixDiagonalsReversed(matrix, rows, cols);
    }

    private static void printMatrixDiagonalsReversed(int[][] matrix, int rows, int cols) {
        System.out.println(matrix[rows - 1][cols - 1]);

        int c = cols - 2;
        int start = cols - 2;
        for (int r = rows - 1; r >= 0; r--) {
            if (c >= cols) {
                start--;
                c = start;
                r = rows;

                System.out.println();
            } else if (c < matrix[r].length){
                if (r == 0) {
                    r = rows;
                }

                if (c < cols && r == 0) {
                    break;
                }

                System.out.print(matrix[r][c] + " ");
                c++;
            }

        }
    }
}
