package stacksAndQueuesExercise;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class ReverseNumbersWithAStack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] numbers = scanner.nextLine().split("\\s+");

        ArrayDeque<String> reversedNumbers = new ArrayDeque<>();

        for (int i = 0; i < numbers.length; i++) {
            String currentNumber = numbers[i];
            reversedNumbers.push(currentNumber);
        }

        while (!reversedNumbers.isEmpty()) {
            System.out.print(reversedNumbers.pop() + " ");
        }
    }
}
