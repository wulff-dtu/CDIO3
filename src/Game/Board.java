package Game;

public class Board {

    private Tile[] tiles;

    public Board() {
        tiles = new Tile[24];
        tiles[0] = new Tile("start", 0, "board_start_title", "board_start_subtext", "board_start_description",2, false);
        tiles[1] = new Tile("street", 1,"board_burgerbar_title", "board_burgerbar_subtext", "board_burgerbar_description",1, false);
        tiles[2] = new Tile("street", 1,"board_pizzaria_title", "board_pizzaria_subtext", "board_pizzaria_description", 1,false);
        tiles[3] = new Tile("chance", 0,"board_chance_title", "board_chance_subtext", "board_chance_description", 0, false);
        tiles[4] = new Tile("street",2, "board_candystore_title", "board_candystore_subtext", "board_candystore_description",  1, false);
        tiles[5] = new Tile("street",2, "board_icecream_title", "board_icecream_subtext", "board_icecream_description", 1, false);
        tiles[6] = new Tile("jail",0, "board_jailonvisit_title", "board_jailonvisit_subtext", "board_jailonvisit_description", 0, false);
        tiles[7] = new Tile("street",3,"board_museum_title", "board_museum_subtext", "board_museum_description", 2, false);
        tiles[8] = new Tile("street",3,"board_library_title", "board_library_subtext", "board_library_description", 2, false);
        tiles[9] = new Tile("chance",0,"board_chance_title", "board_chance_subtext", "board_chance_description", 0, false);
        tiles[10] = new Tile("street",4,"board_skatepark_title", "board_skatepark_subtext", "board_skatepark_description", 2, true);
        tiles[11] = new Tile("street",4,"board_swimmingpool_title", "board_swimmingpool_subtext", "board_swimmingpool_description", 2, false);
        tiles[12] = new Tile("refuge",0,"board_freeparking_title", "board_freeparking_subtext", "board_freeparking_description", 0, false);
        tiles[13] = new Tile("street",5,"board_gamearcade_title", "board_gamearcade_subtext", "board_gamearcade_description", 3, false);
        tiles[14] = new Tile("street",5,"board_cinema_title", "board_cinema_subtext", "board_cinema_description", 3, false);
        tiles[15] = new Tile("chance",0,"board_chance_title", "board_chance_subtext", "board_chance_description", 0, false);
        tiles[16] = new Tile("street",6,"board_toystore_title", "board_toystore_subtext", "board_toystore_description", 3, false);
        tiles[17] = new Tile("street",6,"board_petshop_title", "board_petshop_subtext", "board_petshop_description", 3, false);
        tiles[18] = new Tile("gotojail",0,"board_gotojail_title", "board_gotojail_subtext", "board_gotojail_description", 0, false);
        tiles[19] = new Tile("street",7,"board_bowlinghall_title", "board_bowlinghall_subtext", "board_bowlinghall_description", 4, false);
        tiles[20] = new Tile("street",7,"board_zoo_title", "board_zoo_subtext", "board_zoo_description", 4, false);
        tiles[21] = new Tile("chance",0,"board_chance_title", "board_chance_subtext", "board_chance_description", 0, false);
        tiles[22] = new Tile("street",8,"board_waterpark_title", "board_waterpark_subtext", "board_waterpark_description", 5, false);
        tiles[23] = new Tile("street",8,"board_seafront_title", "board_seafront_subtext", "board_seafront_description", 5, false);
    }

    public Tile[] getTiles() {
        return tiles;
    }
}
