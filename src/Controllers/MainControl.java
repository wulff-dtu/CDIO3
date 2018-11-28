package Controllers;

import Game.Board;
import GUI.GUIController;

/** Tries to handle communication between the game and the GUI.
 *  Also handles the main flow/turns of the game, because
 *  communication between game and GUI happens each turn.
 */
public class MainControl {

    private Board board;
    private GUIController gui;
    private GameControl gameControl;

    /**
     * Constructor. Instantiates a new board and calls the GUI to make a matching board.
     * Ends by calling the mainMenu method.
     */
    public MainControl() {
        board = new Board();
        gui = new GUIController(getBoardTypesForGUI(board), getBoardTitlesForGUI(board), getBoardGroupsForGUI(board), getBoardPricesForGUI(board));
        mainMenu();
    }


    /**
     * Handles the logic of the main menu. First, it calls the GUI to display the main menu
     * and receive an input, and then performs the related action.
     */
    private void mainMenu() {
        switch (gui.mainMenu()) {
            case 1 :
                gameControl = new GameControl(gui);
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

    private String[] getBoardTypesForGUI(Board board) {
        String[] types = new String[board.getTiles().length];
        for (int i = 0; i < board.getTiles().length; i++) {
            types[i] = board.getTiles()[i].getType();
        }
        return types;
    }

    private String[] getBoardTitlesForGUI(Board board) {
        String[] titles = new String[board.getTiles().length];
        for (int i = 0; i < board.getTiles().length; i++) {
            titles[i] = board.getTiles()[i].getTitle();
        }
        return titles;
    }

    private int[] getBoardGroupsForGUI(Board board) {
        int[] groups = new int[board.getTiles().length];
        for (int i = 0; i < board.getTiles().length; i++) {
            groups[i] = board.getTiles()[i].getGroup();
        }
        return groups;
    }

    private String[] getBoardPricesForGUI(Board board) {
        String[] prices = new String[board.getTiles().length];
        for (int i = 0; i < board.getTiles().length; i++) {
            prices[i] = Integer.toString(board.getTiles()[i].getPrice());
        }
        return prices;
    }

}
