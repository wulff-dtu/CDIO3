package Controllers;

import GUI.GUIController;
import Game.Game;

public class TurnControl {

    private GUIController gui;
    private Game game;
    private TurnLogic turnLogic;
    private String playerName;
    private int playerIndex;
    private boolean continueGame, findWinner;

    /**
     * The constructor sets up the needed attributes.
     * In the end, it calls turnMenu() to display a menu to the player.
     * "continueGame" is used to tell GameControl, that the game is not over yet, so that it will
     * pass the turn forward. If a player goes bankrupt, continueGame will be set to false.
     * @param gui
     * @param game
     * @param turnIndex turnIndex is assigned to playerIndex, because it is frequently
     *                 used as a reference to the player, that currently has the turn.
     */
    public TurnControl(GUIController gui, Game game, int turnIndex) {
        this.gui = gui;
        this.game = game;
        this.playerIndex = turnIndex;
        playerName = game.getPlayerNames()[turnIndex];
        continueGame = true;
        turnMenu();
    }

    /**
     * Calls the GUI to display a menu and receive an input.
     * Then calls the corresponding method depending on input.
     */
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

    /**
     * Instantiates a new turnLogic object, which handles the actual logic of a turn.
     * Then calls displayOutCome(), which will call the GUI to display the outcome of the turn.
     * Finally it checks if the player has gone bankrupt, and if so, makes sure that
     * the game ends and a winner will be displayed.
     */
    private void throwDice() {
        turnLogic = new TurnLogic(game, playerIndex);
        turnLogic.runTurn();
        displayOutCome();
        if (turnLogic.getOutCome().equals("bankrupt")) {
            findWinner = true;
            continueGame = false;
        }
    }

    /**
     * Calls the GUI to display the scores of the players.
     */
    private void showScore() {
        gui.displayScore(game.getPlayerNames(), game.getPlayerBalances());
        turnMenu();
    }

    /**
     * Calls the GUI to remove all players, and then stops the game.
     */
    private void quitGame() {
        gui.removeAllPlayers();
        continueGame = false;
    }

    /**
     * Calls the GUI to display the dice and players.
     * Checks if the player has passed start and shows the corresponding message.
     * Then checks what the outcome of the turn is, and calls the GUI to display
     * the corresponding message.
     */
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
                gui.displayLandOnChance(playerName);
                break;
            case "jailOnVisit" :
                gui.displayVisitJail(playerName);
                break;
            case "gotojail" :
                gui.displayGoToJail(playerName);
                break;
            case "bankrupt" :
                gui.displayBankruptcy(playerName);
                break;
            default:
                break;
        }
    }

    public boolean continueGame() {
        return continueGame;
    }

    public boolean isFindWinner() {
        return findWinner;
    }
}
