package multidimensionalArraysExercise;

import java.util.Arrays;
import java.util.Scanner;

public class Crossfire {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        int rows = dimensions[0];
        int cols = dimensions[1];

        Integer[][] matrix = new Integer[rows][cols];
        int counter = 1;

        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                matrix[r][c] = counter;
                counter++;
            }
        }

        String input = scanner.nextLine();
        while (!input.equals("Nuke it from orbit")) {
            String[] inputLine = input.split("\\s+");
            int row = Integer.parseInt(inputLine[0]);
            int col = Integer.parseInt(inputLine[1]);
            int radius = Integer.parseInt(inputLine[2]);

            printNewMatrix(matrix, row, col, radius);
            input = scanner.nextLine();
        }

        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                if (matrix[r][c] != null) {
                    System.out.print(matrix[r][c] + " ");
                }
            }
            System.out.println();
        }
    }

    private static void printNewMatrix(Integer[][] matrix, int row, int col, int radius) {
        for (int rad = 1; rad <= radius; rad++) {
            if (row + rad < matrix.length) {
                matrix[row + rad][col] = null;
            }

            if (matrix[row][col] == null) {
                col++;
            }

            if (col + rad < matrix[row].length) {
                matrix[row][col + rad] = null;
            }
        }

        for (int rad1 = radius; rad1 > 0; rad1--) {
            if (row - rad1 >= 0) {
                matrix[row - rad1][col] = null;
            }

            if (col - rad1 >= 0) {
                matrix[row][col - rad1] = null;
            }

        }

        matrix[row][col] = null;

    }
}
