package GUI;

import gui_fields.*;
import Game.Tile;
import Game.Board;

import java.awt.*;

public class GUIBoard {

    private GUI_Field[] fields;
    private Tile[] tiles;

    public GUIBoard(Language language, Board board) {
        this.tiles = board.getTiles();
        Tile[] tiles = board.getTiles();
        fields = new GUI_Field[24];
        for (int i = 0; i < tiles.length; i++) {
            switch(tiles[i].getType()) {
                case "start":
                    fields[i] = new GUI_Start(language.getString(tiles[i].getTitle()), language.getString(tiles[i].getSubtext()), language.getString(tiles[i].getDescription()), Color.red, Color.white);
                    break;
                case "street":
                    fields[i] = new GUI_Street(language.getString(tiles[i].getTitle()), language.getString(tiles[i].getSubtext()), language.getString(tiles[i].getDescription()), Integer.toString(tiles[i].getEffectOnBalance()), Color.darkGray, Color.white);
                    break;
                case "chance":
                    fields[i] = new GUI_Chance(language.getString(tiles[i].getTitle()), language.getString(tiles[i].getSubtext()), language.getString(tiles[i].getDescription()), Color.white, Color.black);
                    break;
                case "jail":
                    fields[i] = new GUI_Jail("gui_resources/Jail.jpg", language.getString(tiles[i].getTitle()), language.getString(tiles[i].getSubtext()), language.getString(tiles[i].getDescription()), Color.darkGray, Color.white);
                    break;
                case "gotojail":
                    fields[i] = new GUI_Jail("gui_resources/GoToJail.jpg", language.getString(tiles[i].getTitle()), language.getString(tiles[i].getSubtext()), language.getString(tiles[i].getDescription()), Color.darkGray, Color.white);
                    break;
                case "refuge":
                    fields[i] = new GUI_Refuge("gui_resources/Cones.jpg", language.getString(tiles[i].getTitle()), language.getString(tiles[i].getSubtext()), language.getString(tiles[i].getDescription()), Color.darkGray, Color.white);

            }
        }
    }

    public GUI_Field[] getFields() {
        return fields;
    }

    public void updtateFields(Language language) {
        for (int i = 0; i < tiles.length; i++) {
            fields[i].setTitle(language.getString(tiles[i].getTitle()));
            fields[i].setSubText(language.getString(tiles[i].getSubtext()));
            fields[i].setDescription(language.getString(tiles[i].getDescription()));
        }
    }
}
