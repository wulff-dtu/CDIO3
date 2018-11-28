package Game;

public class Board {

    private Tile[] tiles;

    /**
     * Board constructor.
     */
    public Board() {
        tiles = new Tile[24];
        tiles[0] = new Tile("start", 0, "board_start_title",2);
        tiles[1] = new Tile("ownable", 1,"board_burgerbar_title",1);
        tiles[2] = new Tile("ownable", 1,"board_pizzaria_title", 1);
        tiles[3] = new Tile("chance", 0,"board_chance_title",0);
        tiles[4] = new Tile("ownable",2, "board_candystore_title",1);
        tiles[5] = new Tile("ownable",2, "board_icecream_title",1);
        tiles[6] = new Tile("jail",0, "board_jailonvisit_title", 0);
        tiles[7] = new Tile("ownable",3,"board_museum_title", 2);
        tiles[8] = new Tile("ownable",3,"board_library_title", 2);
        tiles[9] = new Tile("chance",0,"board_chance_title",0);
        tiles[10] = new Tile("ownable",4,"board_skatepark_title",2);
        tiles[11] = new Tile("ownable",4,"board_swimmingpool_title",2);
        tiles[12] = new Tile("refuge",0,"board_freeparking_title",0);
        tiles[13] = new Tile("ownable",5,"board_gamearcade_title",3);
        tiles[14] = new Tile("ownable",5,"board_cinema_title", 3);
        tiles[15] = new Tile("chance",0,"board_chance_title", 0);
        tiles[16] = new Tile("ownable",6,"board_toystore_title", 3);
        tiles[17] = new Tile("ownable",6,"board_petshop_title", 3);
        tiles[18] = new Tile("gotojail",0,"board_gotojail_title", 0);
        tiles[19] = new Tile("ownable",7,"board_bowlinghall_title", 4);
        tiles[20] = new Tile("ownable",7,"board_zoo_title",4);
        tiles[21] = new Tile("chance",0,"board_chance_title",0);
        tiles[22] = new Tile("ownable",8,"board_waterpark_title",5);
        tiles[23] = new Tile("ownable",8,"board_seafront_title", 5);
    }

    public Tile[] getTiles() {
        return tiles;
    }
}
