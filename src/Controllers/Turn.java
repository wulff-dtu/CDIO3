package Controllers;

import Game.Game;

public class Turn {

    private int playerIndex, startingPosition, calculatedNewPosition, actualNewPosition;
    private Game game;

    public Turn(Game game, int turnIndex) {
        this.game = game;
        playerIndex = turnIndex;
        movePlayer();
        checkStartPassed();
        runEffectOfNewPosition();
    }

    /**
     * Gets the starting position of the player.
     * Then throws the dice and returns the sum.
     * Then calculates the new position of the player.
     * Then sets the player at the new position.
     */
    private void movePlayer() {
        startingPosition = game.getPlayerPositions()[playerIndex];
        int diceThrow = game.throwDice();
        calculatedNewPosition = startingPosition + diceThrow;
        actualNewPosition = calculatedNewPosition % game.getBoardLength();
        game.setPlayerPosition(playerIndex, actualNewPosition);
    }

    /**
     * Checks if the player has passed or landed on start.
     * If so, the player is granted with an amount of money (start effect).
     * Since the start tile is supposed to always be at index 0 of the board, we can
     * check if the player has passed or landed on start by checking
     * if calculatedPosition is larger than the length of the board.
     */
    private void checkStartPassed() {
        if (calculatedNewPosition > game.getBoardLength()) {
            game.changePlayerBalance(playerIndex, game.getStartEffect());
        }
    }

    /**
     * Calls the game to find out what type of tile, the player has landed on.
     * Then calls the corresponding method to run the effects of the tile.
     */
    private void runEffectOfNewPosition() {
        switch (game.getTileType(actualNewPosition)) {
            case "Tile_Ownable":
                onOwnable();
                break;
            case "Tile_Chance":
                onChance();
                break;
            case "Tile_Jail":
                onGoToJail();
                break;
        }
    }

    /**
     * First checks if the player can afford to either buy the ownable
     * or pay rent. If not, the game ends. If yes, it then checks
     * if ownable is owned by anyone (-1 indicates that no one owns it).
     * If not, they player is forced to buy it. If it's already owned,
     * the player pays rent to the owner.
     */
    private void onOwnable() {
        int priceAndRent = game.getPriceAndRent(actualNewPosition);
        int ownerIndex = game.getOwnerIndex(actualNewPosition);

        if (canAfford(priceAndRent)) {
            if (ownerIndex == -1) {
                buyOwnable(playerIndex, priceAndRent);
            } else {
                payRent(ownerIndex, priceAndRent);
            }
        } else {
            endGame();
        }
    }

    private void onChance() {
        //Chance chance = new Chance(game, playerIndex);
    }

    private void onGoToJail() {

    }

    /**
     * Checks if the player can afford something.
     * @param price
     * @return
     */
    private boolean canAfford(int price) {
        return game.getPlayerBalances()[playerIndex] > price;
    }

    private void buyOwnable(int playerIndex, int price) {
        game.changePlayerBalance(playerIndex, -price);
        game.setOwnerIndex(actualNewPosition, playerIndex);
    }

    private void payRent(int playerIndex, int rent) {
        game.changePlayerBalance(playerIndex, -rent);
    }

    private void endGame() {

    }


}
