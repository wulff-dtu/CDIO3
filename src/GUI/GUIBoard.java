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
                    fields[i] = new GUI_Start("", "", "", Color.red, Color.white);
                    break;
                case "street":
                    fields[i] = new GUI_Street("", "", "", Integer.toString(tiles[i].getPrice()), Color.darkGray, Color.white);
                    break;
                case "chance":
                    fields[i] = new GUI_Chance("", "", "", Color.white, Color.black);
                    break;
                case "jail":
                    fields[i] = new GUI_Jail("default", "", "", "", Color.white, Color.black);
                    break;
                case "gotojail":
                    fields[i] = new GUI_Jail("default", "", "", "", Color.white, Color.black);
                    break;
                case "refuge":
                    fields[i] = new GUI_Refuge("default", "", "", "", Color.white, Color.black);

            }
        }
        setFieldsData(language);
    }

    public GUI_Field[] getFields() {
        return fields;
    }

    public void setFieldsData(Language language) {
        for (int i = 0; i < tiles.length; i++) {
            fields[i].setTitle(language.getString(tiles[i].getTitle()));
            fields[i].setSubText(language.getString(tiles[i].getSubtext()) + tiles[i].priceToString());
            fields[i].setDescription(language.getString(tiles[i].getDescription()));
            switch (tiles[i].getGroup()) {
                case 1:
                    fields[i].setBackGroundColor(new Color(127,120,79));
                    break;
                case 2:
                    fields[i].setBackGroundColor(new Color(180,209,209));
                    fields[i].setForeGroundColor(Color.black);
                    break;
                case 3:
                    fields[i].setBackGroundColor(new Color(179,124,135));
                    break;
                case 4:
                    fields[i].setBackGroundColor(new Color(255,251,171));
                    fields[i].setForeGroundColor(Color.black);
                    break;
                case 5:
                    fields[i].setBackGroundColor(new Color(180,209,209));
                    fields[i].setForeGroundColor(Color.black);
                    break;
                case 6:
                    fields[i].setBackGroundColor(new Color(0,131,96));
                    break;
                case 7:
                    fields[i].setBackGroundColor(new Color(15,75,116));
                    break;
                case 8:
                    fields[i].setBackGroundColor(new Color(38, 38, 39));
                    break;
            }
        }
    }
}
