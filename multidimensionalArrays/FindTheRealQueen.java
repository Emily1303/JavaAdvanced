package multidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class FindTheRealQueen {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[][] matrix = new String[8][8];

        for (int r = 0; r < matrix.length; r++) {
            matrix[r] = scanner.nextLine().split("\\s+");
        }

        findTheQueen(matrix);
    }

    private static void findTheQueen(String[][] matrix) {
        boolean stopProgram = false;
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                String currentElement = matrix[r][c];

                if (currentElement.equals("q")) {
                    boolean foundQueen = searchThroughThePositions(matrix, r, c);

                    if (foundQueen) {
                        System.out.printf("%d %d", r, c);
                        stopProgram = true;
                        break;
                    }
                }
            }

            if (stopProgram) {
                break;
            }

        }
    }

    private static boolean searchThroughThePositions(String[][] matrix, int row, int col) {
        boolean realQueen = true;

        for (int c = 0; c < matrix[row].length; c++) {
            String currentElement = matrix[row][c];
            if (currentElement.equals("q") && c != col) {
                return realQueen = false;
            }
        }

        for (int r = 0; r < matrix.length; r++) {
            String currentElement = matrix[r][col];
            if (currentElement.equals("q") && r != row) {
                return realQueen = false;
            }
        }

        int r = row;
        int c = col;

        while (r >= 0 && r < matrix.length && c >= 0 && c < matrix[r].length) {
            String currentElement = matrix[r][c];
            if (currentElement.equals("q") && r != row && c != col) {
                return realQueen;
            } else {
                r--;
                c--;
            }
        }

        r = row;
        c = col;

        while (r >= row && r < matrix.length && c >= col && c < matrix[r].length) {
            String currentElement4 = matrix[r][c];
            if (currentElement4.equals("q") && r != row && c != col) {
                return realQueen;
            } else {
                r++;
                c++;
            }
        }

        r = row;
        c = col;

        while (r >= 0 && r <= matrix.length - 1 && c >= 0 && c < matrix[r].length) {
            String element = matrix[r][c];
            if (element.equals("q") && r != row && c != col) {
                return realQueen;
            } else {
                r++;
                c--;
            }
        }

        r = row;
        c = col;

        while (r >= 0 && r < matrix.length && c >= 0 && c < matrix[r].length) {
            String element1 = matrix[r][c];
            if (element1.equals("q") && r != row && c != col) {
                return realQueen;
            } else {
                r--;
                c++;
            }
        }

        return realQueen;
    }
}
