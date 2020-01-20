package com.company.player;

import com.company.Field;

public abstract class Player {

    Field field;
    private char playerCharacter;


    void markCell(int row, int column) {
        if (this.getPlayerCharacter() == 'X') {
            this.putX(row, column);
        } else {
            this.putO(row, column);
        }
    }

    void makeStep(int row, int column) {
        if (field.isEmptyCell(row, column)) {
            markCell(row, column);
            field.showField();
        } else {
            System.out.println("You can't do it");
        }
    }

    public void makeStep(int[] placeArray) {
        if (field.isEmptyCell(placeArray)) {
            markCell(placeArray[0], placeArray[1]);
        } else {
            System.out.println("You can't do it");
        }
        field.showField();
    }


    private void putX(int rowCoordinate, int columnCoordinate) {
        field.putCharacter(rowCoordinate, columnCoordinate, 'X');
    }

    private void putO(int rowCoordinate, int columnCoordinate) {
        field.putCharacter(rowCoordinate, columnCoordinate, 'O');
    }

    public char getPlayerCharacter() {
        return playerCharacter;
    }

    public void setPlayerCharacter(char playerCharacter) {
        this.playerCharacter = playerCharacter;
    }

    public void setField(Field field) {
        this.field = field;
    }

    public Field getField() {
        return field;
    }
}
