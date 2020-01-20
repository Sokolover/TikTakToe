package com.company.game;

import com.company.player.Player;

class Referee {

    static boolean draw(Player player){
        return player.getField().isEmpty();
    }

    static boolean playerWin(Player player) {
        return checkRows(player) || checkColumns(player) || checkDiagonals(player);
    }

    private static boolean checkRows(Player player) {

        char[][] characterField = player.getField().getCharacterField();
        int flag = 0;

        for (int i = 0; i < characterField.length; i++) {
            for (int j = 0; j < characterField[i].length; j++) {
                if (player.getField().getCharacter(i, j) == player.getPlayerCharacter()) {
                    flag++;
                }
                if (flag == characterField.length) {
                    return true;
                }
            }
            flag = 0;
        }

        return false;
    }

    private static boolean checkColumns(Player player) {

        char[][] characterField = player.getField().getCharacterField();
        int flag = 0;

        for (int i = 0; i < characterField.length; i++) {
            for (int j = 0; j < characterField[i].length; j++) {
                if (player.getField().getCharacter(j, i) == player.getPlayerCharacter()) {
                    flag++;
                }
                if (flag == characterField[i].length) {
                    return true;
                }
            }
            flag = 0;
        }

        return false;
    }

    private static boolean checkDiagonals(Player player) {

        char[][] characterField = player.getField().getCharacterField();
        int flag = 0;

        for (int i = 0; i < characterField.length; i++) {
            if (player.getField().getCharacter(i, i) == player.getPlayerCharacter()) {
                flag++;
            }
            if (flag == characterField.length) {
                return true;
            }
        }

        flag = 0;

        for (int i = 0, j = characterField[i].length - 1; i < characterField.length; i++, j--) {
            if (player.getField().getCharacter(i, j) == player.getPlayerCharacter()) {
                flag++;
            }
            if (flag == characterField.length) {
                return true;
            }

        }

        return false;
    }
}
