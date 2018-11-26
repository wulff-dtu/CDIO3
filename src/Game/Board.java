package Game;

public class Board {

    private Tile[] tiles;

    /**
     * Board constructor.
     */
    public Board() {
        tiles = new Tile[24];
        tiles[0] = new Tile_Start("board_start_title", 2);
        tiles[1] = new Tile_Ownable("board_burgerbar_title", 1, 1);
        tiles[2] = new Tile_Ownable("board_pizzaria_title", 1, 1);
        tiles[3] = new Tile_Chance("board_chance_title");
        tiles[4] = new Tile_Ownable("board_candystore_title", 2, 1);
        tiles[5] = new Tile_Ownable("board_icecream_title", 2, 1);
        tiles[6] = new Tile_Jail("board_jailonvisit_title");
        tiles[7] = new Tile_Ownable("board_museum_title", 3, 2);
        tiles[8] = new Tile_Ownable("board_library_title", 3, 2);
        tiles[9] = new Tile_Chance("board_chance_title");
        tiles[10] = new Tile_Ownable("board_skatepark_title", 4, 2);
        tiles[11] = new Tile_Ownable("board_swimmingpool_title", 4, 2);
        tiles[12] = new Tile_FreeParking("board_freeparking_title");
        tiles[13] = new Tile_Ownable("board_gamearcade_title", 5, 3);
        tiles[14] = new Tile_Ownable("board_cinema_title", 5, 3);
        tiles[15] = new Tile_Chance("board_chance_title");
        tiles[16] = new Tile_Ownable("board_toystore_title", 6, 3);
        tiles[17] = new Tile_Ownable("board_petshop_title", 6, 3);
        tiles[18] = new Tile_Jail("board_gotojail_title");
        tiles[19] = new Tile_Ownable("board_bowlinghall_title", 7, 4);
        tiles[20] = new Tile_Ownable("board_zoo_title", 7, 4);
        tiles[21] = new Tile_Chance("board_chance_title");
        tiles[22] = new Tile_Ownable("board_waterpark_title", 8, 5);
        tiles[23] = new Tile_Ownable("board_seafront_title", 8, 5);
    }

    public Tile[] getTiles() {
        return tiles;
    }

}
