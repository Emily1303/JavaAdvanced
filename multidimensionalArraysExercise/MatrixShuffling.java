package multidimensionalArraysExercise;

import java.util.Arrays;
import java.util.Scanner;

public class MatrixShuffling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        String[][] matrix = new String[dimensions[0]][dimensions[1]];
        for (int r = 0; r < matrix.length; r++) {
            matrix[r] = scanner.nextLine().split("\\s+");
        }

        String input = scanner.nextLine();
        while (!input.equals("END")) {
            String[] inputLine = input.split("\\s+");

            boolean isValid = isInputValid(inputLine, dimensions[0], dimensions[1]);

            if (!isValid) {
                System.out.println("Invalid input!");
                input = scanner.nextLine();
                continue;
            } else {
                int row1 = Integer.parseInt(inputLine[1]);
                int col1 = Integer.parseInt(inputLine[2]);
                int row2 = Integer.parseInt(inputLine[3]);
                int col2 = Integer.parseInt(inputLine[4]);

                String previousElement = matrix[row1][col1];
                matrix[row1][col1] = matrix[row2][col2];
                matrix[row2][col2] = previousElement;

                printMatrix(matrix);
            }

            input = scanner.nextLine();
        }
    }

    private static boolean isInputValid (String[] input, int rows, int cols) {
        boolean isValid = false;

        if (input[0].equals("swap")) {
            isValid = true;
        } else {
            return isValid = false;
        }

        if (input.length == 5) {
            isValid = true;
        } else {
            return isValid = false;
        }

        for (int i = 1; i < input.length; i++) {
            int integer = Integer.parseInt(input[i]);

            if (i % 2 != 0) {
                if (integer >= 0 && integer < rows) {
                    isValid = true;
                } else {
                    return isValid = false;
                }
            } else {
                if (integer >= 0 && integer < cols) {
                    isValid = true;
                } else {
                    return isValid = false;
                }
            }
        }

        return isValid;
    }

    private static void printMatrix (String[][] matrix) {
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                System.out.print(matrix[r][c] + " ");
            }
            System.out.println();
        }
    }

}
