package Controllers;

import GUI.GUIController;
import Game.Game;

public class TurnMenu {

    private String playerName;
    private int turnIndex;
    private boolean continueGame;

    public TurnMenu(GUIController gui, Game game, int turnIndex) {
        this.turnIndex = turnIndex;
        playerName = game.getPlayerNames()[turnIndex];
        continueGame = true;
        turnMenu(gui, game);
    }

    private void turnMenu(GUIController gui, Game game) {
        int input = gui.turnMenu(playerName);
        switch (input) {
            case 1 :
                throwDice(gui, game);
                break;
            case 2 :
                showScore(gui, game);
                break;
            case 3 :
                quitGame();
                break;
        }
    }

    private void throwDice(GUIController gui, Game game) {
        Turn turn = new Turn(game, turnIndex);
        gui.displayDice(game.getDiceValues());
        //gui.displayTurnMessage();
        gui.displayPlayers(game.getPlayerPositions());
    }

    private void showScore() {

    }

    private void quitGame(GUIController gui) {
        gui.removeAllPlayers();
        continueGame = false;
    }

    public boolean continueGame() {
        return continueGame;
    }
}
