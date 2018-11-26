package Controllers;

import GUI.GUIController;
import Game.Game;

public class TurnMenu {

    private GUIController gui;
    private Game game;
    private String playerName;
    private int turnIndex;
    private boolean continueGame;

    public TurnMenu(GUIController gui, Game game, int turnIndex) {
        this.gui = gui;
        this.game = game;
        this.turnIndex = turnIndex;
        playerName = game.getPlayerNames()[turnIndex];
        continueGame = true;
        turnMenu();
    }

    private void turnMenu() {
        int input = gui.turnMenu(playerName);
        switch (input) {
            case 1 :
                throwDice();
                break;
            case 2 :
                showScore();
                break;
            case 3 :
                quitGame();
                break;
        }
    }

    private void throwDice() {
        new Turn(game, turnIndex);
        gui.displayDice(game.getDiceValues());
        //gui.displayTurnMessage();
        gui.displayPlayers(game.getPlayerPositions());
    }

    private void showScore() {
        gui.displayScore(game.getPlayerNames(), game.getPlayerBalances());
        turnMenu();
    }

    private void quitGame() {
        gui.removeAllPlayers();
        continueGame = false;
    }

    public boolean continueGame() {
        return continueGame;
    }
}
