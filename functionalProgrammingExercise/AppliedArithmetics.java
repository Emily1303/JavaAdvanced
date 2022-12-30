package functionalProgrammingExercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class AppliedArithmetics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");
        List<Integer> list = Arrays.stream(input).map(Integer::parseInt).collect(Collectors.toList());

        String command = scanner.nextLine();
        while (!command.equals("end")) {
            UnaryOperator<Integer> operator = getNewNumbers(command);

            if (operator != null) {
                list = list.stream().map(operator).collect(Collectors.toList());
            }

            command = scanner.nextLine();
        }

        Consumer<Integer> consumer = n -> System.out.print(n + " ");
        list.forEach(consumer);
    }

    private static UnaryOperator<Integer> getNewNumbers(String command) {
        switch (command) {
            case "add":
                return n -> n + 1;
            case "multiply":
                return n -> n * 2;
            case "subtract":
                return n -> n - 1;
            case "print":
                return n -> n;
        }

        return null;
    }
}
