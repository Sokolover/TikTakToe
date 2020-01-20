package com.company.player;

//не делать метод для ходов бота против ходов чел. слишком большим

public class Bot extends Player {


    private int[] winStep = new int[2];
    private int[] antiStep = new int[2];


    public boolean antiHumanStep() {
        return this.checkAntiRow() || this.checkAntiColumn() || this.checkAntiDiagonal();
    }

    public boolean winBotStep() {
        return this.checkWinRow() || this.checkWinColumn() || this.checkWinDiagonal();
    }

    public void cornerStep() {

        char[][] characterField = field.getCharacterField();

        int leftColumnIndex = 0;
        int upperRowIndex = 0;
        int rightColumnIndex = characterField[0].length - 1;
        int lowerRowIndex = characterField.length - 1;

        if (this.field.isEmptyCell(upperRowIndex, leftColumnIndex)) {
            this.makeStep(upperRowIndex, leftColumnIndex);
        } else {
            if (this.field.isEmptyCell(upperRowIndex, rightColumnIndex)) {
                this.makeStep(upperRowIndex, rightColumnIndex);
            } else {
                if (this.field.isEmptyCell(lowerRowIndex, rightColumnIndex)) {
                    this.makeStep(lowerRowIndex, rightColumnIndex);
                } else {
                    this.makeStep(lowerRowIndex, leftColumnIndex);
                }
            }
        }
    }


    private boolean isMarkedWithOpponent(int i, int j) {
        return this.field.getCharacter(i, j) != getPlayerCharacter() &&
                this.field.getCharacter(i, j) != ' ';
    }

    private boolean checkAntiRow() {

        int flag = 0;
        char[][] characterField = field.getCharacterField();

        for (int i = 0; i < characterField.length; i++) {
            for (int j = 0; j < characterField[i].length; j++) {
                if (isMarkedWithOpponent(i, j)) {
                    flag++;
                }
                Boolean x = antiRowStep(flag, characterField, i);
                if (x != null) return x;
            }
            flag = 0;
        }

        return false;
    }

    private Boolean antiRowStep(int flag, char[][] characterField, int i) {
        if (flag >= characterField.length - 1) {
            for (int k = 0; k < characterField[i].length; k++) {
                if (this.field.getCharacter(i, k) == ' ') {
                    this.setAntiStep(i, k);
                    return true;
                }
            }
            return false;
        }
        return null;
    }

    private boolean checkAntiColumn() {
        int flag = 0;
        char[][] characterField = field.getCharacterField();

        for (int j = 0; j < characterField.length; j++) {
            for (int i = 0; i < characterField[j].length; i++) {
                if (isMarkedWithOpponent(i, j)) {
                    flag++;
                }
                Boolean x = antiColumnStep(flag, characterField, i, j);
                if (x != null) return x;
            }
            flag = 0;
        }

        return false;
    }

    private Boolean antiColumnStep(int flag, char[][] characterField, int i, int j) {
        if (flag >= characterField.length - 1) {
            for (int k = 0; k < characterField[i].length; k++) {
                if (this.field.getCharacter(k, j) == ' ') {
                    this.setAntiStep(k, j);
                    return true;
                }
            }
            return false;
        }
        return null;
    }

    private boolean checkAntiDiagonal() {

        int flag = 0;
        char[][] characterField = field.getCharacterField();

        for (int i = 0; i < characterField.length; i++) {

            if (isMarkedWithOpponent(i, i)) {
                flag++;
            }
            Boolean x = antiLeftDiagonalStep(flag, characterField);
            if (x != null) return x;
        }

        flag = 0;

        for (int i = 0, j = characterField[i].length - 1; i < characterField.length; i++, j--) {

            if (isMarkedWithOpponent(i, j)) {
                flag++;
            }
            Boolean x = antiRightDiagonalStep(flag, characterField);
            if (x != null) {
                return x;
            }
        }
        return false;
    }

    private Boolean antiRightDiagonalStep(int flag, char[][] characterField) {
        if (flag >= characterField.length - 1) {
            for (int i = 0, j = characterField[i].length - 1; i < characterField.length; i++, j--) {
                if (this.field.isEmptyCell(i, j)) {
                    setAntiStep(i, j);
                    return true;
                }
            }
            return false;
        }
        return null;
    }

    private Boolean antiLeftDiagonalStep(int flag, char[][] characterField) {
        if (flag >= characterField.length - 1) {
            for (int i = 0; i < characterField.length; i++) {
                if (this.field.isEmptyCell(i, i)) {
                    setAntiStep(i, i);
                    return true;
                }
            }
            return false;
        }
        return null;
    }


    private boolean isMarkedWithPlayer(int i, int j) {
        return this.field.getCharacter(i, j) == getPlayerCharacter();
    }

    private boolean checkWinRow() {

        int flag = 0;
        char[][] characterField = field.getCharacterField();

        for (int i = 0; i < characterField.length; i++) {
            for (int j = 0; j < characterField[i].length; j++) {
                if (isMarkedWithPlayer(i, j)) {
                    flag++;
                }
                Boolean x = winRowStep(flag, characterField, i);
                if (x != null) {
                    return x;
                }
            }
            flag = 0;
        }

        return false;
    }

    private Boolean winRowStep(int flag, char[][] characterField, int i) {
        if (flag >= characterField.length - 1) {
            for (int j = 0; j < characterField[i].length; j++) {
                if (this.field.getCharacter(i, j) == ' ') {
                    this.setWinStep(i, j);
                    return true;
                }
            }
            return false;
        }
        return null;
    }

    private boolean checkWinColumn() {
        int flag = 0;
        char[][] characterField = field.getCharacterField();

        for (int j = 0; j < characterField.length; j++) {
            for (int i = 0; i < characterField[j].length; i++) {
                if (isMarkedWithPlayer(i, j)) {
                    flag++;
                }
                Boolean x = winColumnStep(flag, characterField, i, j);
                if (x != null) return x;
            }
            flag = 0;
        }

        return false;
    }

    private Boolean winColumnStep(int flag, char[][] characterField, int i, int j) {
        if (flag >= characterField.length - 1) {
            for (int k = 0; k < characterField[i].length; k++) {
                if (this.field.getCharacter(k, j) == ' ') {
                    this.setWinStep(k, j);
                    return true;
                }
            }
            return false;
        }
        return null;
    }

    private boolean checkWinDiagonal() {

        int flag = 0;
        char[][] characterField = field.getCharacterField();

        for (int i = 0; i < characterField.length; i++) {
            if (isMarkedWithPlayer(i, i)) {
                flag++;
            }
            Boolean x = winLeftDiagonalStep(flag, characterField);
            if (x != null) return x;
        }

        flag = 0;

        for (int i = 0, j = characterField[i].length - 1; i < characterField.length; i++, j--) {

            if (isMarkedWithPlayer(i, j)) {
                flag++;
            }
            Boolean x = winRightDiagonalStep(flag, characterField);
            if (x != null) return x;
        }
        return false;
    }

    private Boolean winRightDiagonalStep(int flag, char[][] characterField) {
        if (flag >= characterField.length - 1) {
            for (int i = 0, j = characterField[i].length - 1; i < characterField.length; i++, j--) {
                if (this.field.isEmptyCell(i, j)) {
                    setWinStep(i, j);
                    return true;
                }
            }
            return false;
        }
        return null;
    }

    private Boolean winLeftDiagonalStep(int flag, char[][] characterField) {
        if (flag >= characterField.length - 1) {
            for (int i = 0; i < characterField.length; i++) {
                if (this.field.isEmptyCell(i, i)) {
                    setWinStep(i, i);
                    return true;
                }
            }
            return false;
        }
        return null;
    }


    public int[] getWinStep() {
        return winStep;
    }

    private void setWinStep(int row, int column) {
        winStep[0] = row;
        winStep[1] = column;
    }

    public int[] getAntiStep() {
        return antiStep;
    }

    private void setAntiStep(int row, int column) {
        this.antiStep[0] = row;
        this.antiStep[1] = column;
    }

}
