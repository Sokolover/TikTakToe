package com.company.input;

import java.util.Scanner;

public class EnterFromConsole {

    private static final int TWO = 2;
    private static final int ZERO = 0;

    public static int enterInt() {
        Scanner scanner = new Scanner(System.in);

        while (!scanner.hasNextInt()) {
            scanner.nextLine();
        }

        return scanner.nextInt();
    }

    private static int enterCoordinate() {
        int coordinate;
        do {
            coordinate = enterInt();
        } while (coordinate > TWO || coordinate < ZERO);
        return coordinate;
    }

    public static int[] enterCoordinates() {

        int[] coordinates = new int[2];

        System.out.print("Enter vertical coordinate(0-2):");
        coordinates[0] = enterCoordinate();
        System.out.print("Enter horizontal coordinate(0-2):");
        coordinates[1] = enterCoordinate();

        return coordinates;
    }
}
