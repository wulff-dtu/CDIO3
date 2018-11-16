package GUI;

import java.io.*;
import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;

public class Language {

    private File file;
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
        "board_burgerbar_subtext",
        "board_burgerbar_description",
        "board_pizzaria_title",
        "board_pizzaria_subtext",
        "board_pizzaria_description",
        "board_candystore_title",
        "board_candystore_subtext",
        "board_candystore_description",
        "board_icecream_title",
        "board_icecream_subtext",
        "board_icecream_description",
        "board_museum_title",
        "board_museum_subtext",
        "board_museum_description",
        "board_library_title",
        "board_library_subtext",
        "board_library_description",
        "board_skatepark_title",
        "board_skatepark_subtext",
        "board_skatepark_description",
        "board_swimmingpool_title",
        "board_swimmingpool_subtext",
        "board_swimmingpool_description",
        "board_gamearcade_title",
        "board_gamearcade_subtext",
        "board_gamearcade_description",
        "board_cinema_title",
        "board_cinema_subtext",
        "board_cinema_description",
        "board_toystore_title",
        "board_toystore_subtext",
        "board_toystore_description",
        "board_petshop_title",
        "board_petshop_subtext",
        "board_petshop_description",
        "board_bowlinghall_title",
        "board_bowlinghall_subtext",
        "board_bowlinghall_description",
        "board_zoo_title",
        "board_zoo_subtext",
        "board_zoo_description",
        "board_waterpark_title",
        "board_waterpark_subtext",
        "board_waterpark_description",
        "board_seafront_title",
        "board_seafront_subtext",
        "board_seafront_description",
        "board_start_title",
        "board_start_subtext",
        "board_start_description",
        "board_chance_title",
        "board_chance_subtext",
        "board_chance_description",
        "board_jailonvisit_title",
        "board_jailonvisit_subtext",
        "board_jailonvisit_description",
        "board_freeparking_title",
        "board_freeparking_subtext",
        "board_freeparking_description",
        "board_gotojail_title",
        "board_gotojail_subtext",
        "board_gotojail_description",
        "rules",
        "change_language_header",
        "change_language_english",
        "change_language_danish",
        "invalid_input",
        "main_start_howmanyplayers",
        "main_start_writeplayername"
    };


    public Language(String language) {
        changeLanguage(language);
    }

    private void mapStrings() {
        try {
            Scanner scanner = new Scanner(file);
            map = new HashMap<>();
            for(String id : stringsID) {
                map.put(id, searchFileforString(id));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


    }

    /**
     * Searches language.txt for a certain messageID, i.e. "mainmenu3",
     * and returns the corresponding message, found on the next line. Only works when language.txt is structured
     * as one line of the messageID followed by one line of the actual message
     */
    private String searchFileforString(String stringID) {
        String message = "StringID: \"" + stringID + "\" not found.";
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if(line.equals(stringID)) {
                    message = scanner.nextLine();
                    break;
                }
            }
            scanner.close();
            if(message.equals("StringID: \"" + stringID + "\" not found."))
                System.err.println("A key-value set does not match!");
        } catch(FileNotFoundException e) {
            System.out.println("File doesn't exist!");
        }
        return message;
    }

    public void changeLanguage(String language) {
        file = new File("src/GUI/"+language.toLowerCase()+".txt");
        mapStrings();
    }

    public Map getMap() {
        return map;
    }

    public String getString(String stringID) {
        return map.get(stringID);
    }

}
