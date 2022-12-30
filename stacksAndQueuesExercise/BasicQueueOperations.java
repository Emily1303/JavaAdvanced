package stacksAndQueuesExercise;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class BasicQueueOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] commands = scanner.nextLine().split("\\s+");

        int[] numbersToAdd = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        int numbersToOffer = Integer.parseInt(commands[0]);
        int numbersToPoll = Integer.parseInt(commands[1]);
        int numberToCheck = Integer.parseInt(commands[2]);

        ArrayDeque<Integer> numbersQueue = new ArrayDeque<>();

        while (numbersToOffer > 0) {
            for (int i = 0; i < numbersToAdd.length; i++) {
                int currentNumber = numbersToAdd[i];
                numbersQueue.offer(currentNumber);
                numbersToOffer--;
            }
        }

        for (int i = 1; i <= numbersToPoll; i++) {
            numbersQueue.poll();
        }

        boolean numberFound = false;
        if (numbersQueue.contains(numberToCheck)) {
            numberFound = true;
            System.out.println("true");
        } else if (numbersQueue.isEmpty()){
            System.out.println("0");
        } else {
            int minNumber = Collections.min(numbersQueue);
            System.out.println(minNumber);
        }

    }
}
