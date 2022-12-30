package stacksAndQueuesExercise;

import java.util.ArrayDeque;
import java.util.Scanner;

public class RecursiveFibonacci {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());

        ArrayDeque<Long> stackFibonacci = new ArrayDeque<>();

        stackFibonacci.push(0l);
        stackFibonacci.push(1l);

        for (int i = 1; i <= number; i++) {
            long poppedNumber1 = stackFibonacci.pop();
            long poppedNumber2 = stackFibonacci.pop();

            stackFibonacci.push(poppedNumber1);
            stackFibonacci.push(poppedNumber1 + poppedNumber2);
        }

        System.out.println(stackFibonacci.peek());
    }
}
