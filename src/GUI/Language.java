package GUI;

import java.io.*;
import java.util.Map;
import java.util.HashMap;

/**
 * The constructor defines an array, "stringsID", with the ID's of all strings
 * that will be searched for in a language file.
 */
public class Language {

    private String fileName;
    private InputStream is;
    private Map<String, String> map;
    private String[] stringsID = {
        "main_menu_header",
        "main_menu_option1",
        "main_menu_option2",
        "main_menu_option3",
        "main_menu_option4",
        "main_menu_option1",
        "turn_menu_header",
        "turn_menu_option1",
        "turn_menu_option2",
        "turn_menu_option3",
        "end_game_congratulations",
        "end_game_youwon",
        "board_burgerbar_title",
        "board_pizzaria_title",
        "board_candystore_title",
        "board_icecream_title",
        "board_museum_title",
        "board_library_title",
        "board_skatepark_title",
        "board_swimmingpool_title",
        "board_gamearcade_title",
        "board_cinema_title",
        "board_toystore_title",
        "board_petshop_title",
        "board_bowlinghall_title",
        "board_zoo_title",
        "board_waterpark_title",
        "board_seafront_title",
        "board_start_title",
        "board_chance_title",
        "board_jailonvisit_title",
        "board_freeparking_title",
        "board_gotojail_title",
        "rules",
        "change_language_header",
        "change_language_english",
        "change_language_danish",
        "invalid_input",
        "main_start_howmanyplayers",
        "main_start_writeplayername",
        "player_action_passStart",
        "player_action_buy1",
        "player_action_buy2",
        "player_action_payrent1",
        "player_action_payrent2",
        "player_action_payrent3",
        "board_ownable_subtext",
        "board_ownable_forsale",
        "board_ownable_ownedby",
        "board_start_subtext",
        "board_start_description",
        "board_jailonvisit_subtext",
        "board_jailonvisit_description",
        "board_gotojail_subtext",
        "board_gotojail_description",
        "board_chance_subtext",
        "board_chance_description",
        "board_freeparking_subtext",
        "board_freeparking_description",
        "player_action_pickChance",
        "player_action_visitJail",
        "player_action_goToJail",
        "player_action_bankruptcy"
    };


    public Language(String language) {
        changeLanguage(language);
    }

    private void mapStrings() {
        map = new HashMap<>();
        for(String id : stringsID) {
            try {
                map.put(id, searchFileforString(id));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Searches language.txt for a certain messageID, i.e. "mainmenu3",
     * and returns the corresponding message, found on the next line. Only works when language.txt is structured
     * as one line of the messageID followed by one line of the actual message
     */
    private String searchFileforString(String stringID) throws IOException {
        String message = "StringID: \"" + stringID + "\" not found.";

        is = getClass().getResourceAsStream(fileName);
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);

        String line;
        while ((line = br.readLine()) != null) {
            if (line.equals(stringID)) message = br.readLine();
        }

        br.close();
        isr.close();
        is.close();

        if(message.equals("StringID: \"" + stringID + "\" not found."))
            System.err.println("A key-value set does not match! Key: " + stringID);
        return message;
    }

    public void changeLanguage(String language) {
        fileName = language.toLowerCase() + ".txt";
        mapStrings();
    }

    public String getString(String stringID) {
        return map.get(stringID);
    }

}
