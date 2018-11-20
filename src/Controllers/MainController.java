package Controllers;

import Game.Game;
import Game.Board;
import GUI.GUIController;

/** Tries to handle communication between the game and the GUI.
 *  Also handles the main flow/turns of the game, because
 *  communication between game and GUI happens each turn.
 */
public class MainController {

    private Game game;
    private Board board;
    private GUIController gui;

    /**
     * Constructor. Instantiates a new board and calls the GUI to make a matching board.
     * Ends by calling the mainMenu method.
     */
    public MainController() {
        board = new Board();
        gui = new GUIController(board);
        mainMenu();
    }


    /**
     * Handles the logic of the main menu. First, it calls the GUI to display the main menu
     * and receive an input, and then performs the related action.
     */
    private void mainMenu() {
        switch (gui.mainMenu()) {
            case 1 :
                startGame();
                break;
            case 2 :
                gui.displayRules();
                break;
            case 3 :
                gui.changeLanguage();
                break;
            case 4 :
                System.exit(0);
                break;
        }
        mainMenu();
    }

    /**
     * Instantiates a new game and then calls the GUI to receive input (the player names).
     * the do/while calls the game to run a new turn, as long as a winner is not found.
     */
    public void startGame() {
        game = new Game(gui.promptPlayerNames());
        gui.addPlayers(game.getPlayerNames(), game.getPlayerBalances());
        do {
            turnMenu();
        } while (!game.isWinnerFound());
        gui.displayWinner(game.getWinner().getName());
    }

    /**
     * Handles the logic of the turn menu.
     * Calls the GUI to display the turn menu and receive input, and then performs the right action.
     * After the player rolls the dice, the GUI is called to update the dice and players.
     */
    public void turnMenu() {
        switch (gui.turnMenu(game.getPlayers()[game.getPlayerTurnIndex()].getName())) {
            case 1 :
                game.newTurn();
                gui.displayDice(game.getDiceCup().getValueArray());
                gui.displayTurnMessage(game.getTurn().getTile().getTitle());
                gui.displayPlayers(game.getPlayerPositions());
                break;
            case 2 :
                String[] playerNames = new String[game.getPlayers().length];
                int[] playerScores = new int[game.getPlayers().length];
                for (int i = 0; i < game.getPlayers().length; i++) {
                    playerNames[i] = game.getPlayers()[i].getName();
                    playerScores[i] = game.getPlayers()[i].getBankroll().getBalance();
                }
                gui.displayScore(playerNames, playerScores);
                turnMenu();
                break;
            case 3 :
                gui.removeAllPlayers();
                mainMenu();
                break;
        }
    }
}
