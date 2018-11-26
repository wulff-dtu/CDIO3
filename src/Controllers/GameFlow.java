package Controllers;

import Game.Game;
import GUI.GUIController;

public class GameFlow {

    private Game game;
    private int numOfPlayers, turnIndex;
    private boolean gameRunning;

    public GameFlow(GUIController gui) {
        newGame(gui);
    }

    /**
     * Initializes a game and the runs it.
     * @param gui
     */
    private void newGame(GUIController gui) {
        initializeGame(gui);
        runGame(gui);
    }

    /**
     * Initializes a new game.
     * First, it calls the GUI to prompt for a number of players and their names.
     * Second, it sets the number of players and instantiates a new game with those players.
     * Third, it calls the GUI to add those players.
     * Finally, it randomly chooses a player to start.
     * @param gui
     */
    private void initializeGame(GUIController gui) {
        String[] playerNames = gui.promptPlayerNames();
        numOfPlayers = playerNames.length;
        game = new Game(playerNames);
        gui.addPlayers(game.getPlayerNames(), game.getPlayerBalances());
        turnIndex = randomIndex(numOfPlayers);
    }

    /**
     * Controls the flow of the game, that is:
     * 1. Instantiates a new turn with a turnIndex.
     * 2. Checks if a winner is found in that turn, and stops the game if there is.
     * 3. Passes the turn forward (it doesn't matter if the game is stopped).
     * 4. Continues as long as no winner is found.
     * @param gui
     */
    private void runGame(GUIController gui) {
        gameRunning = true;
        do {
            TurnMenu turn = new TurnMenu(gui, game, turnIndex);
            gameRunning = turn.continueGame();
            changeTurn(1);
        } while (gameRunning);
    }

    /**
     * Is used mainly to pass the turn forward by 1.
     * Can also be used to pass the turn backwards, or to grant an extra turn.
     * It makes sure, that the index will never go out of bounds.
     * @param change Positive values passes the turn forward. Negative backwards.
     */
    private void changeTurn(int change) {
        change = change % numOfPlayers;
        turnIndex += change;
        if (turnIndex > numOfPlayers - 1) turnIndex -= numOfPlayers;
        if (turnIndex < 0) turnIndex += numOfPlayers;
    }

    /**
     * Generates a random integer from 0 to x (x not included);
     * @param x
     * @return
     */
    private int randomIndex(int x) {
        return (int)(Math.random() * x);
    }

}
