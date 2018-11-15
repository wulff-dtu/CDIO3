package GUI;

import gui_main.GUI;
import gui_fields.*;
import Game.Board;

public class GUIController {

    private GUI gui;
    private GUI_Field[] GUIboard;
    private Language language;

    public GUIController(Board board) {

        language = new Language("english");
        GUIboard = new GUIBoard(language, board).getFields();
        gui = new GUI(GUIboard);

    }

    public int mainMenu() {
        String option1 = language.getString("main_menu_option1");
        String option2 = language.getString("main_menu_option2");
        String option3 = language.getString("main_menu_option3");
        String option4 = language.getString("main_menu_option4");
        String input = gui.getUserButtonPressed(language.getString("main_menu_header"), option1, option2, option3, option4);
        if (input.equals(option1)) {
            return 1;
        } else if (input.equals(option2)) {
            return 2;
        } else if (input.equals(option3)) {
            return 3;
        } else if (input.equals(option4)) {
            return 4;
        }
        return 0;
    }

    public String[] promptPlayerNames() {
        String input = gui.getUserButtonPressed(language.getString("main_start_howmanyplayers"), "2", "3", "4");
        int numOfPlayers = Integer.parseInt(input);
        String[] playerNames = new String[numOfPlayers];

        for (int i = 0; i < numOfPlayers; i++) {
            playerNames[i] = gui.getUserString(language.getString("main_start_writeplayername") + " " + (i + 1) + ":");
        }

        return playerNames;
    }

    public int turnMenu(String playerName) {
        String option1 = language.getString("turn_menu_option1");
        String option2 = language.getString("turn_menu_option2");
        String option3 = language.getString("turn_menu_option3");
        String input = gui.getUserButtonPressed(playerName + language.getString("turn_menu_header"), option1, option2, option3);
        if (input.equals(option1)) {
            return 1;
        } else if (input.equals(option2)) {
            return 2;
        } else if (input.equals(option3)) {
            return 3;
        }
        return 0;
    }

    public void displayTurnMessage(String message) {
        gui.showMessage(language.getString(message));
    }

    public void displayScore(String[] playerNames, int[] playerScores) {
        String score = "";
        for (int i = 0; i < playerNames.length; i++) {
            score += playerNames[i] + ": " + playerScores[i] + "\n";
        }
        gui.showMessage(score);
    }

    public void displayWinner(String playerName) {
        gui.showMessage(language.getString("end_game_congratulations") + " " + playerName + ", " + language.getString("end_game_youwon"));
    }

    public void displayRules() {
        String rules = language.getString("rules");
        rules += "\n";
        rules = rules.replaceAll("(.{1,50})\\s+", "$1\n");
        gui.showMessage(rules);
    }

    public void changeLanguage() {
        String option1 = language.getString("change_language_english");
        String option2 = language.getString("change_language_danish");
        String input = gui.getUserButtonPressed(language.getString("change_language_header"), option1, option2);
        if (input.equals(option1)) {
            language.changeLanguage("english");
        } else if (input.equals(option2)) {
            language.changeLanguage("danish");
        }
    }

    public void displayDice(int[] dice) {
        gui.setDice(dice[0], dice[1]);
    }
}
