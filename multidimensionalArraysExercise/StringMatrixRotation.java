package multidimensionalArraysExercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StringMatrixRotation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String rotation = scanner.nextLine();
        int rotationNumber = Integer.parseInt(rotation.split("[()]")[1]);
        int angle = rotationNumber % 360;

        List<String> inputLine = new ArrayList<>();
        String input = scanner.nextLine();
        while (!input.equals("END")) {
            inputLine.add(input);
            input = scanner.nextLine();
        }

        int rows = inputLine.size();
        int cols = Integer.MIN_VALUE;
        for (String item : inputLine) {
            if (item.length() > cols) {
                cols = item.length();
            }
        }

        char[][] matrix = new char[rows][cols];
        for (int r = 0; r < matrix.length; r++) {
            String word = inputLine.get(r);
            for (int c = 0; c < matrix[r].length; c++) {
                if (c < word.length()) {
                    matrix[r][c] = inputLine.get(r).charAt(c);
                } else {
                    matrix[r][c] = ' ';
                }
            }
        }

        switch (angle) {
            case 0:
                for (int r = 0; r < matrix.length; r++) {
                    for (int c = 0; c < matrix[r].length; c++) {
                        System.out.print(matrix[r][c]);
                    }
                    System.out.println();
                }
                break;
            case 90:
                for (int c = 0; c < cols; c++) {
                    for (int r = rows - 1; r >= 0; r--) {
                        System.out.print(matrix[r][c]);
                    }
                    System.out.println();
                }
                break;
            case 180:
                for (int r = rows - 1; r >= 0; r--) {
                    for (int c = cols - 1; c >= 0; c--) {
                        System.out.print(matrix[r][c]);
                    }
                    System.out.println();
                }
                break;
            case 270:
                for (int c = cols - 1; c >= 0 ; c--) {
                    for (int r = 0; r < rows; r++) {
                        System.out.print(matrix[r][c]);
                    }
                    System.out.println();
                }
                break;
        }
    }
}
