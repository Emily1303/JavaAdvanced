package functionalProgramming;

import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FilterByAge {

    static class Person {
        String name;
        int age;

        Person(String name, int age) {
            this.name = name;
            this.age = age;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());

        Function<Scanner, Person> readPeople = sc -> {
          String[] input = scanner.nextLine().split(", ");
          String name = input[0];
          int age = Integer.parseInt(input[1]);
          Person person = new Person(name, age);
            return person;
        };

        List<Person> people = IntStream.range(0, number).mapToObj(o -> readPeople.apply(scanner))
                .collect(Collectors.toList());

        String condition = scanner.nextLine();
        int ageToCompare = Integer.parseInt(scanner.nextLine());
        String format = scanner.nextLine();

        Predicate<Person> predicate = getFilterAges(ageToCompare, condition);
        Consumer<Person> consumer = getPrintPeople(format);

        people.stream().filter(predicate).forEach(consumer);

    }

    private static Consumer<Person> getPrintPeople(String format) {
        switch (format) {
            case "name":
                return n -> System.out.println(n.name);
            case "age":
                return n -> System.out.println(n.age);
            case "name age":
                return n -> System.out.printf("%s - %d%n", n.name, n.age);
        }
        return null;
    }

    private static Predicate<Person> getFilterAges(int ageToCompare, String condition) {
        switch (condition) {
            case "older":
                return n -> n.age >= ageToCompare;
            case "younger":
                return n -> n.age <= ageToCompare;
        }

        return null;
    }
}
