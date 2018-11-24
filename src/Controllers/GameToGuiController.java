package Controllers;

import Game.Game;
import GUI.GUIController;

public class GameToGuiController {

    private Game game;
    private GUIController gui;

    public GameToGuiController(Game game, GUIController gui) {
        this.game = game;
        this.gui = gui;
    }

}
