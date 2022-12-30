package functionalProgramming;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class CountUppercase {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");

        Predicate<String> predicate = n -> Character.isUpperCase(n.charAt(0));
        Consumer<String> consumer = System.out::println;

        List<String> list = Arrays.stream(input).filter(predicate).collect(Collectors.toList());
        int count = list.size();

        System.out.println(count);
        list.forEach(consumer);

    }
}
