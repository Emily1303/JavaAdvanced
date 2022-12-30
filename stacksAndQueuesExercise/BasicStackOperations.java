package stacksAndQueuesExercise;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class BasicStackOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] commands = scanner.nextLine().split("\\s+");

        int[] numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        int numbersToPush = Integer.parseInt(commands[0]);
        int numbersToPop = Integer.parseInt(commands[1]);
        int numberToCheck = Integer.parseInt(commands[2]);

        ArrayDeque<Integer> newNumbersStack = new ArrayDeque<>();

        while (numbersToPush > 0) {
            for (int j = 0; j < numbers.length; j++) {
                int currentNumber = numbers[j];
                newNumbersStack.push(currentNumber);
                numbersToPush--;
            }
        }

        for (int i = 1; i <= numbersToPop; i++) {
            newNumbersStack.pop();
        }

        int minNumber = Integer.MAX_VALUE;
        boolean isPrintReady = false;

        if (newNumbersStack.contains(numberToCheck)) {
            isPrintReady = true;
        } else {
            for (int integer : newNumbersStack) {
                if (integer < minNumber) {
                    minNumber = integer;
                }
            }
        }

        if (!isPrintReady && !newNumbersStack.isEmpty()) {
            System.out.println(minNumber);
        } else if (isPrintReady) {
            System.out.println("true");
        } else if (newNumbersStack.isEmpty()) {
            System.out.println("0");
        }

    }
}
