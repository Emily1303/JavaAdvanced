package multidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class PrintDiagonalsOfSquareMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int dimensions = Integer.parseInt(scanner.nextLine());
        int[][] matrix = new int[dimensions][dimensions];

        for (int r = 0; r < matrix.length; r++) {
            matrix[r] = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt).toArray();
        }

        findTheDiagonals(matrix, dimensions);
    }

    private static void findTheDiagonals(int[][] matrix, int dimensions) {
        int[] firstDiagonal = new int[dimensions];
        int[] secondDiagonal = new int[dimensions];

        int row = 0;
        int col = 0;

        while (row >= 0 && row < matrix.length && col >= 0 && col < matrix[row].length) {
            for (int i = 0; i < firstDiagonal.length; i++) {
                firstDiagonal[i] = matrix[row][col];

                row++;
                col++;
            }
        }

        row = dimensions - 1;
        col = 0;

        while (row >= 0 && row <= matrix.length - 1 && col >= 0 && col < matrix[row].length) {
            for (int i = 0; i < secondDiagonal.length; i++) {
                secondDiagonal[i] = matrix[row][col];

                row--;
                col++;
            }
        }

        printDiagonal(firstDiagonal);
        printDiagonal(secondDiagonal);
    }

    private static void printDiagonal (int[] diagonal) {
        for (int i = 0; i < diagonal.length; i++) {
            System.out.printf("%d ", diagonal[i]);
        }
        System.out.println();
    }
}
