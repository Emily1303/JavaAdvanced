package multidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class PositionsOf {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        int rows = dimensions[0];
        int cols = dimensions[1];

        int[][] matrix = new int[rows][cols];
        for (int r = 0; r < rows; r++) {
            matrix[r] = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt).toArray();
        }

        int numberToCheck = Integer.parseInt(scanner.nextLine());

        findTheNumber(matrix, numberToCheck);

    }

    private static void findTheNumber (int[][] matrix, int number) {
        boolean notFound = true;

        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                int currentNumber = matrix[r][c];

                if (currentNumber == number) {
                    notFound = false;
                    System.out.printf("%d %d", r, c);
                    System.out.println();
                }
            }
        }

        if (notFound) {
            System.out.println("not found");
        }
    }
}
