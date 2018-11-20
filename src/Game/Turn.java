package Game;

public class Turn {

    private int diceThrow;
    private Tile tile;

    public Turn(Player player, Game game) {
        game.getDiceCup().throwDice();
        diceThrow = game.getDiceCup().getSum();
        int previousPosition = player.getPosition();
        int newPosition = previousPosition + diceThrow;
        player.changePosition(newPosition);
        tile = game.getBoard().getTiles()[player.getPosition()]; //TODO mere elegant med lokale attributter?

        if(newPosition > 23) player.getBankroll().changeBalance(2);

        if (tile.getType().equals("street")) {

            if (tile.getOwnerIndex() == -1) {

                //if the tile is not owned

                if (player.getBankroll().getBalance() < tile.getPrice()) { //player unable to pay
                    game.calculateWinner();
                } else { // player buys tile
                    tile.setOwnerIndex(game.getPlayerTurnIndex());
                    player.getBankroll().changeBalance(-tile.getPrice());
                }
            } else { //if the tile is owned
                if (player.getBankroll().getBalance() < tile.getPrice() && tile.getOwnerIndex() != game.getPlayerTurnIndex()) {
                    game.calculateWinner();
                } else if (tile.getOwnerIndex() != game.getPlayerTurnIndex()) {
                    player.getBankroll().changeBalance(-tile.getPrice());
                    game.getPlayers()[tile.getOwnerIndex()].getBankroll().changeBalance(tile.getPrice());
                    // player pays the owner of the tile
                }
            }
        }
    }

    public Tile getTile() { //TODO nødvendig?
        return tile;
    }

}
