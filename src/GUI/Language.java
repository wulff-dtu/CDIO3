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
        "board_tower_message",
        "board_crater_message",
        "board_palace_gates_message",
        "board_cold_desert_message",
        "board_walled_city_message",
        "board_monastery_message",
        "board_black_cave_message",
        "board_huts_message",
        "board_werewall_message",
        "board_pit_message",
        "board_goldmine_message",
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
        map = new HashMap<>();
        for(String id : stringsID) {
            map.put(id, searchFileforString(id));
        }
    }

    /**
     * Searches language.txt for a certain messageID, i.e. "mainmenu3",
     * and returns the corresponding message, found on the next line. Only works when language.txt is structured
     * as one line of the messageID followed by one line of the actual message
     */
    private String searchFileforString(String stringID) {
        String message = "";
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
        } catch(FileNotFoundException e) {
            System.out.println("stringID does not exist in file!");
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
