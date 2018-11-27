package GUI;

import gui_fields.GUI_Field;
import gui_fields.GUI_Player;
import gui_main.GUI;

import java.awt.*;

public class GUIController {

    private GUI gui;
    private GUI_Player[] gui_players;
    private GUIBoard GUIboard;
    private Language language;

    public GUIController(String[] boardTypes, String[] boardTitles, int[] boardGroups, String[] prices) {
        language = new Language("english");
        GUIboard = new GUIBoard(language, boardTypes, boardTitles, boardGroups, prices);
        gui = new GUI(GUIboard.getFields(), new Color(55, 89, 50));
    }

    /**
     * @return
     * Displays the main menu with four options/buttons.
     * Returns an integer from 1-4.
     */
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

    public void displayMessage(String message) {
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
        rules = rules.replaceAll("(.{1,350})\\s+", "$1\n");
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
        GUIboard.setFieldTexts(language);
    }

    public void displayDice(int[] dice) {
        if (dice.length == 1) {
            gui.setDie(dice[0]);
        } else if (dice.length == 2) {
            gui.setDice(dice[0], dice[1]);
        }
    }

    public void addPlayers(String[] names, int[] balances) {
        removeAllPlayers();
        gui_players = new GUI_Player[names.length];
        for (int i = 0; i < names.length; i++) {
            gui_players[i] = new GUI_Player(names[i], balances[i]);
            GUIboard.getFields()[0].setCar(gui_players[i], true);
        }
    }

    public void displayPlayers(int[] positions) {
        GUI_Field[] fields =  GUIboard.getFields();
        removeAllPlayers();
        for (int i = 0; i < positions.length; i++) {
            fields[positions[i]].setCar(gui_players[i], true);
        }
    }

    public void removeAllPlayers() {
        GUI_Field[] fields =  GUIboard.getFields();
        for (GUI_Field field : fields) {
            field.removeAllCars();
        }
    }

    public void displayPurchase(String playerName, String tileTitle, int price) {
        gui.showMessage(playerName + " " + language.getString("player_action_buy1") + " " + language.getString(tileTitle) + " " + language.getString("player_action_buy2") + " " + price + ",-");
    }

    public void displayRentPaid(String playerName, String ownerName, String tileTitle, int rent) {
        gui.showMessage(language.getString(tileTitle) + " " + language.getString("player_action_payrent1") + " " + ownerName + ". " + playerName + " " + language.getString("player_action_payrent2") + " " + rent + ",- " + language.getString("player_action_payrent3") + " " + ownerName);
    }

    public void displayStartPassed(String playerName, int startEffect) {
        gui.showMessage(playerName + " " + language.getString("player_action_passStart") + " " + startEffect + ",-");
    }
}
