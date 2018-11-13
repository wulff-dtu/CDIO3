package Game;

public class Board {

    private Tile[] tiles;

    public Board() {
        tiles = new Tile[11];
        tiles[0] = new Tile("board_tower_message", 250, false);
        tiles[1] = new Tile("board_crater_message", -100, false);
        tiles[2] = new Tile("board_palace_gates_message", 100, false);
        tiles[3] = new Tile("board_cold_desert_message", -20, false);
        tiles[4] = new Tile("board_walled_city_message", 180, false);
        tiles[5] = new Tile("board_monastery_message", 0, false);
        tiles[6] = new Tile("board_black_cave_message", -70, false);
        tiles[7] = new Tile("board_huts_message", 60, false);
        tiles[8] = new Tile("board_werewall_message", -80, true);
        tiles[9] = new Tile("board_pit_message", -50, false);
        tiles[10] = new Tile("board_goldmine_message", 650, false);
    }

    public Tile[] getTiles() {
        return tiles;
    }
}
