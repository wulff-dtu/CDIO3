package Game;

public class Turn {

    private int diceThrow;
    private Tile tile;

    public Turn(Player player, Board board, DiceCup diceCup) {
        diceCup.throwDice();
        diceThrow = diceCup.getSum();
        tile = board.getTiles()[diceThrow -2];
        player.getBankroll().changeBalance(tile.getEffectOnBalance());
    }

    public Tile getTile() {
        return tile;
    }

}
