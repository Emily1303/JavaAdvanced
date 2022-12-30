package setsAndMapsAdvanced;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class SoftUniParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Set<String> reservationList = new TreeSet<>();

        while (!input.equals("PARTY")) {
            reservationList.add(input);

            input = scanner.nextLine();
        }

        while (!input.equals("END")) {
            reservationList.remove(input);

            input = scanner.nextLine();
        }

        System.out.println(reservationList.size());
        reservationList.stream().forEach(element -> System.out.println(element));
    }

}
