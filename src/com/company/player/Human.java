package com.company.player;

import com.company.input.EnterFromConsole;

public class Human extends Player {

    public void makeStep() {
        boolean result = true;
        while (result) {
            int[] arrayCoordinates = EnterFromConsole.enterCoordinates();
            if (field.isEmptyCell(arrayCoordinates)) {
                markCell(arrayCoordinates[0], arrayCoordinates[1]);
                field.showField();
                result = false;
            } else {
                System.out.println("You can't step here, try again\n");
                result = true;
            }
        }
    }
}
