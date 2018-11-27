package Controllers;

import Game.Game;
import GUI.GUIController;

public class GameControl {

    private Game game;
    private GUIController gui;
    private int numOfPlayers, turnIndex;
    private boolean gameRunning;

    public GameControl(GUIController gui) {
        this.gui = gui;
        newGame();
    }

    /**
     * Initializes a game and the runs it.
     */
    private void newGame() {
        initializeGame();
        runGame();
    }

    /**
     * Initializes a new game.
     * First, it calls the GUI to prompt for a number of players and their names.
     * Second, it sets the number of players and instantiates a new game with those players.
     * Third, it calls the GUI to add those players.
     * Finally, it randomly chooses a player to start.
     */
    private void initializeGame() {
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
     */
    private void runGame() {
        gameRunning = true;
        do {
            TurnControl turn = new TurnControl(gui, game, turnIndex);
            gameRunning = turn.continueGame();
            passTurnForward();
        } while (gameRunning);
        gui.removeAllPlayers();
    }

    /**
     * Passes the turn forward.
     */
    private void passTurnForward() {
        turnIndex++;
        if (turnIndex == numOfPlayers) turnIndex = 0;
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