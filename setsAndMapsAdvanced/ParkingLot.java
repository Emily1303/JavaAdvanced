package setsAndMapsAdvanced;

import com.sun.source.doctree.SeeTree;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class ParkingLot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Set<String> cars = new LinkedHashSet<>();

        while (!input.equals("END")) {
            String[] inputLine = input.split(", ");

            String direction = inputLine[0];
            String carNumber = inputLine[1];

            switch (direction) {
                case "IN":
                    cars.add(carNumber);
                    break;
                case "OUT":
                    cars.remove(carNumber);
                    break;
            }

            input = scanner.nextLine();
        }


        if (cars.isEmpty()) {
            System.out.println("Parking Lot is Empty");
        } else {
            String output = String.join(System.lineSeparator(), cars);
            System.out.println(output);
        }

    }
}
