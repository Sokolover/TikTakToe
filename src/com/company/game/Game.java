package com.company.game;

import com.company.Field;
import com.company.input.EnterFromConsole;
import com.company.player.Bot;
import com.company.player.Human;
import com.company.player.Player;

class Game {

    private static final int PLAYER_VS_PLAYER_MODE = 1;
    private static final int PLAYER_VS_COMP_MODE = 2;
    private static final int EXIT = 3;

    void menu() {

        boolean isRunning = true;

        while (isRunning) {
            System.out.println("\nTIC TAC TOE\n");
            System.out.println("1 - Multiplayer");
            System.out.println("2 - Singleplayer");
            System.out.println("3 - Exit\n");
            System.out.print("Your choice: ");
            int choice = EnterFromConsole.enterInt();
            switch (choice) {
                case PLAYER_VS_PLAYER_MODE:
                    playPVP();
                    break;
                case PLAYER_VS_COMP_MODE:
                    playWithBot();
                    break;
                case EXIT:
                    isRunning = false;
                    break;
                default:
                    break;
            }
        }
    }

    private void playPVP() {

        Field field = new Field();

        Human human1 = new Human();
        Human human2 = new Human();

        human1.setField(field);
        human2.setField(field);

        human1.setPlayerCharacter('O');
        human2.setPlayerCharacter('X');

        System.out.println("\nFirst payer - O");
        System.out.println("Second payer - X\n");

        while (!field.isEmpty()) {

            human1.makeStep();

            if (endOfGame(human1)) {
                break;
            }

            human2.makeStep();

            if (endOfGame(human2)) {
                break;
            }
        }

    }

    private void playWithBot() {

        Field field = new Field();
        Bot bot = new Bot();
        Human human = new Human();

        bot.setField(field);
        human.setField(field);

        bot.setPlayerCharacter('O');
        human.setPlayerCharacter('X');

        System.out.println("\nBot - O");
        System.out.println("Payer - X\n");

        while (!field.isEmpty()) {

            if (bot.winBotStep()) {
                bot.makeStep(bot.getWinStep());
            } else if (bot.antiHumanStep()) {
                bot.makeStep(bot.getAntiStep());
            } else {
                bot.cornerStep();
            }

            if (endOfGame(bot)) {
                return;
            }

            human.makeStep();

            if (endOfGame(human)) {
                return;
            }
        }
    }

    private static boolean endOfGame(Player player) {
        if (Referee.playerWin(player)) {
            System.out.println("\nPlayer " + player.getPlayerCharacter() + " win!");
            System.out.println("\nGame over");
            return true;
        } else if (Referee.draw(player)) {
            System.out.println("\n\nDraw");
            System.out.println("\nGame over");
            return true;
        }
        return false;
    }
}
