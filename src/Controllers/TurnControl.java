package Controllers;

import GUI.GUIController;
import Game.Game;

public class TurnControl {

    private GUIController gui;
    private Game game;
    private TurnLogic turnLogic;
    private String playerName;
    private int turnIndex;
    private boolean continueGame, findWinner;

    public TurnControl(GUIController gui, Game game, int turnIndex) {
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
        turnLogic = new TurnLogic(game, turnIndex);
        displayOutCome();
        if (turnLogic.getOutCome().equals("bankrupt")) {
            findWinner = true;
            continueGame = false;
        }
    }

    private void showScore() {
        gui.displayScore(game.getPlayerNames(), game.getPlayerBalances());
        turnMenu();
    }

    private void quitGame() {
        gui.removeAllPlayers();
        continueGame = false;
    }

    private void displayOutCome() {
        gui.displayDice(game.getDiceValues());
        gui.displayPlayers(game.getPlayerPositions());
        if (turnLogic.isStartPassed()) {
            gui.displayStartPassed(playerName, game.getStartEffect());
        }
        switch (turnLogic.getOutCome()) {
            case "boughtOwnable" :
                gui.displayPurchase(playerName, game.getTileTitle(turnLogic.getActualNewPosition()), turnLogic.getPriceAndRent());
                gui.setOwnership(playerName, turnLogic.getActualNewPosition());
                break;
            case "paidRent" :
                gui.displayRentPaid(playerName, game.getPlayerNames()[turnLogic.getOwnerIndex()], game.getTileTitle(turnLogic.getActualNewPosition()), turnLogic.getPriceAndRent());
                break;
            case "chance" :
                //gui.displayChance(playerName, turnLogic.getActualNewPosition());
                break;
            case "jail" :
                //gui.displayGoToJail(playerName, turnLogic.getActualNewPosition());
                break;
            case "bankrupt" :
                //gui.displayBankruptcy(playerName, turnLogic.getActualNewPosition());
                break;
            default:
                break;
        }
    }

    public boolean continueGame() {
        return continueGame;
    }
}
