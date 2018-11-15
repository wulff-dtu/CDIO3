package GUI;

import gui_fields.*;
import Game.Tile;
import Game.Board;

import java.awt.*;

public class GUIBoard {

    private GUI_Field[] fields;

    public GUIBoard(Language language, Board board) {
        /*
        fields = new GUI_Field[24];
        fields[0] = new GUI_Start(language.getString("board_start_title"), language.getString("board_start_subtext"), language.getString("board_start_description"), Color.red, Color.white);
        fields[1] = new GUI_Street(language.getString("board_start_title"), language.getString("board_start_subtext"), language.getString("board_start_description"), , Color.red, Color.white);
        fields[2] = new GUI_Street();
        fields[3] = new GUI_Chance();
        fields[4] = new GUI_Street();
        fields[5] = new GUI_Street();
        fields[6] = new GUI_Jail();
        fields[7] = new GUI_Street();
        fields[8] = new GUI_Street();
        fields[9] = new GUI_Chance();
        fields[10] = new GUI_Street();
        fields[11] = new GUI_Street();
        fields[12] = new GUI_Refuge();
        fields[13] = new GUI_Street();
        fields[14] = new GUI_Street();
        fields[15] = new GUI_Chance();
        fields[16] = new GUI_Street();
        fields[17] = new GUI_Street();
        fields[18] = new GUI_Jail();
        fields[19] = new GUI_Street();
        fields[20] = new GUI_Street();
        fields[21] = new GUI_Chance();
        fields[22] = new GUI_Street();
        fields[23] = new GUI_Street();*/
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
}
