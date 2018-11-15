package Controllers;

import Game.Game;
import Game.Board;
import GUI.GUIController;

public class MainController {

    private Game game;
    private Board board;
    private GUIController gui;

    public MainController() {
        board = new Board();
        gui = new GUIController(board);
        mainMenu();
    }

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

    public void startGame() {
        game = new Game(gui.promptPlayerNames());
        do {
            turnMenu();
        } while (!game.isWinnerFound());
        gui.displayWinner(game.getWinner().getName());
    }

    public void turnMenu() {
        switch (gui.turnMenu(game.getPlayers()[game.getPlayerTurnIndex()].getName())) {
            case 1 :
                game.newTurn();
                gui.displayDice(game.getDiceCup().getValueArray());
                gui.displayTurnMessage(game.getTurn().getTile().getTitle());
                if (game.getTurn().getTile().grantsExtraTurn()) {
                    if (game.getPlayerTurnIndex() != 0) {
                        game.setPlayerTurnIndex(game.getPlayerTurnIndex() - 1);
                    } else {
                        game.setPlayerTurnIndex(game.getPlayers().length - 1);
                    }

                }
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
                mainMenu();
                break;
        }
    }
}
