package Controllers;

import Game.Game;

public class Turn {

    int playerIndex;
    int startingPosition;
    int calculatedNewPosition;
    int actualNewPosition;

    public Turn(Game game, int turnIndex) {
        playerIndex = turnIndex;
        movePlayer(game);
        checkStartPassed(game);
        runEffectOfNewPosition(game);
    }

    /**
     * Gets the starting position of the player.
     * Then throws the dice and returns the sum.
     * Then calculates the new position of the player.
     * Then sets the player at the new position.
     * @param game
     */
    private void movePlayer(Game game) {
        startingPosition = game.getPlayerPositions()[playerIndex];
        int diceThrow = game.throwDice();
        calculatedNewPosition = startingPosition + diceThrow;
        actualNewPosition = calculatedNewPosition % game.getBoardSize();
        game.setPlayerPosition(playerIndex, actualNewPosition);
    }

    /**
     * Checks if the player has passed or landed on start.
     * If so, the player is granted with an amount of money (start effect).
     * Since the start tile is supposed to always be at index 0 of the board, we can
     * check if the player has passed or landed on start by checking
     * if calculatedPosition is larger than the length of the board.
     * @param game
     */
    private void checkStartPassed(Game game) {
        if (calculatedNewPosition > game.getBoardLength()) {
            game.changePlayerBalance(playerIndex, game.getStartEffect);
        }
    }

    /**
     * Calls the game to find out what type of tile, the player has landed on.
     * Then calls the corresponding method to run the effects of the tile.
     * @param game
     */
    private void runEffectOfNewPosition(Game game) {
        switch (game.getTileType(actualNewPosition)) {
            case "ownable":
                onOwnable(game);
                break;
            case "chance":
                onChance(game);
                break;
            case "gotojail":
                onGoToJail(game);
                break;
        }
    }

    /**
     * First checks if the player can afford to either buy the ownable
     * or pay rent. If not, the game ends. If yes, it then checks
     * if ownable is owned by anyone (-1 indicates that no one owns it).
     * If not, they player is forced to buy it. If it's already owned,
     * the player pays rent to the owner.
     * @param game
     */
    private void onOwnable(Game game) {
        int priceOrRent = game.getPrice(actualNewPosition);
        int ownerIndex = game.getOwnerIndex(actualNewPosition);

        if (canAfford(game, priceOrRent)) {
            if (ownerIndex == -1) {
                buyOwnable(playerIndex, priceOrRent);
            } else {
                payRent(ownerIndex, priceOrRent);
            }
        } else {
            endGame();
        }
    }

    private void onChance(Game game) {

    }

    private void onGoToJail(Game game) {

    }

    /**
     * Checks if the player can afford something with certain price.
     * @param game
     * @param price
     * @return
     */
    private boolean canAfford(Game game, int price) {
        return game.getPlayerBalances()[playerIndex] > price;
    }





}
