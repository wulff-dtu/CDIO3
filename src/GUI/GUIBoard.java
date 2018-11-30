package GUI;

import gui_fields.*;
import java.awt.*;

public class GUIBoard {

    private GUI_Field[] fields;
    private String[] boardTypes;
    private String[] boardTitles;
    private int[] boardGroups;
    private String[] boardPrices;


    public GUIBoard(Language language, String[] boardTypes, String[] boardTitles, int[] boardGroups, String[] boardPrices) { ;
        this.boardTypes = boardTypes;
        this.boardTitles = boardTitles;
        this.boardGroups = boardGroups;
        this.boardPrices = boardPrices;

        fields = new GUI_Field[24];
        for (int i = 0; i < boardTypes.length; i++) {
            switch(boardTypes[i]) {
                case "start":
                    fields[i] = new GUI_Start("", "", "", Color.red, Color.white);
                    break;
                case "ownable":
                    fields[i] = new GUI_Street("", "", "", boardPrices[i], Color.darkGray, Color.white);
                    setOwnableColor(i);
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
        setFieldTexts(language);
    }

    public GUI_Field[] getFields() {
        return fields;
    }

    public void setFieldTexts(Language language) {
        for (int i = 0; i < boardTitles.length; i++) {
            fields[i].setTitle(language.getString(boardTitles[i]));
            switch (boardTypes[i]) {
                case "start":
                    fields[i].setSubText(language.getString("board_start_subtext") + " " + boardPrices[0] + ",-");
                    fields[i].setDescription(language.getString("board_start_description"));
                    break;
                case "ownable":
                    fields[i].setSubText(boardPrices[i] + ",-");
                    fields[i].setDescription(language.getString("board_ownable_forsale"));
                    break;
                case "chance":
                    //fields[i].setSubText(language.getString("board_chance_subtext"));
                    //fields[i].setDescription(language.getString("board_chance_description"));
                    break;
                case "jail":
                    fields[i].setSubText(language.getString("board_jailonvisit_subtext"));
                    fields[i].setDescription(language.getString("board_jailonvisit_description"));
                    break;
                case "gotojail":
                    fields[i].setSubText(language.getString("board_gotojail_subtext"));
                    fields[i].setDescription(language.getString("board_gotojail_description"));
                    break;
                case "refuge":
                    fields[i].setSubText(language.getString("board_freeparking_subtext"));
                    fields[i].setDescription(language.getString("board_freeparking_description"));
                    break;
            }
        }
    }

    public void setOwnership(Language language, String playerName, int i) {
        fields[i].setDescription(language.getString("board_ownable_ownedby") + " " + playerName);
    }

    private void setOwnableColor(int i) {
        switch (boardGroups[i]) {
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
