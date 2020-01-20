package com.company;

import static java.util.Arrays.*;

public class Field {

    private char[][] characterField = new char[3][3];

    public Field() {
        for (char[] chars : characterField) {
            fill(chars, ' ');
        }
        System.out.println("\n\n\nYou have created new field");
        this.showField();
    }

    public boolean isEmpty() {
        for (char[] charRow : characterField) {
            for (char aChar : charRow) {
                if (aChar == ' ') {
                    return false;
                }
            }
        }
        return true;
    }

    public void showField() {
        System.out.print("\n  0 1 2 \n");
        for (int i = 0; i < characterField.length; i++) {
            System.out.print("" + i);
            for (int j = 0; j < characterField[i].length; j++) {
                System.out.print("|" + characterField[i][j]);
            }
            System.out.print("|\n");
        }
    }

    public void putCharacter(int row, int column, char character) {
        this.characterField[row][column] = character;
    }

    public char getCharacter(int row, int column) {
        return this.characterField[row][column];
    }

    public boolean isEmptyCell(int[] placeArray) {
        return characterField[placeArray[0]][placeArray[1]] == ' ';
    }

    public boolean isEmptyCell(int row, int column) {
        return characterField[row][column] == ' ';
    }

    public char[][] getCharacterField() {
        return characterField;
    }
}
