package stacksAndQueuesExercise;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class MaximumElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int commands = Integer.parseInt(scanner.nextLine());

        ArrayDeque<Integer> numbersStack = new ArrayDeque<>();

        for (int i = 1; i <= commands; i++) {
            int[] inputLine = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt).toArray();

            int firstCommand = inputLine[0];
            switch (firstCommand) {
                case 1:
                    int newNumber = inputLine[1];
                    numbersStack.push(newNumber);
                    break;
                case 2:
                    numbersStack.pop();
                    break;
                case 3:
                    int maxNumber = Integer.MIN_VALUE;
                    for (int integer : numbersStack) {
                        if (integer > maxNumber) {
                            maxNumber = integer;
                        }
                    }

                    System.out.println(maxNumber);
                    break;
            }
        }
    }
}
