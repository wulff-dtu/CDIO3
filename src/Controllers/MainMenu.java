package Controllers;

import Game.Game;
import Game.Board;
import GUI.GUIController;

/** Tries to handle communication between the game and the GUI.
 *  Also handles the main flow/turns of the game, because
 *  communication between game and GUI happens each turn.
 */
public class MainMenu {

    private Game game;
    private Board board;
    private GUIController gui;

    /**
     * Constructor. Instantiates a new board and calls the GUI to make a matching board.
     * Ends by calling the mainMenu method.
     */
    public MainMenu() {
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

}
