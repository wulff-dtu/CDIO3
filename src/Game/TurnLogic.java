package Game;

public class TurnLogic {

    private int playerIndex, startingPosition, calculatedNewPosition, actualNewPosition, ownerIndex, priceAndRent;
    private Game game;
    private String outCome;
    private boolean startPassed;

    public TurnLogic(Game game, int playerIndex) {
        this.game = game;
        this.playerIndex = playerIndex;
    }

    /**
     * Calls three functions.
     * First, it throws the dice and moves the player.
     * Then it checks if the player has passed or landed on start.
     * Finally it determines what kind of tile, the player lands on, and gets the corresponding effect.
     */
    public void runTurn() {
        //checkIfPlayerInJail(); //todo: add jail functionality
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
            startPassed = true;
        }
    }

    //TODO: add jail functionality
    /*
    private void checkIfPlayerInJail() {
        if (game.isPlayerInJail(playerIndex)) {
            if (canAfford(1)) {
                game.changePlayerBalance(playerIndex, -1);
                game.setPlayerInJail(playerIndex, false);
            } else {
                goBankrupt();
            }

        }
    }*/

    /**
     * Calls the game to find out what type of tile, the player has landed on.
     * Then calls the corresponding method to run the effects of the tile.
     */
    private void runEffectOfNewPosition() {
        switch (game.getTileType(actualNewPosition)) {
            case "ownable":
                onOwnable();
                break;
            case "chance":
                onChance();
                break;
            case "jail" :
                onJail();
                break;
            case "gotojail":
                onGoToJail();
                break;
            default:
                outCome = "nothing";
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
        priceAndRent = game.getPriceAndRent(actualNewPosition);
        ownerIndex = game.getOwnerIndex(actualNewPosition);

        if (canAfford(priceAndRent)) {
            if (ownerIndex == -1) {
                buyOwnable(playerIndex, priceAndRent);
            } else {
                payRent(playerIndex, ownerIndex, priceAndRent);
            }
        } else {
            goBankrupt();
        }
    }

    private void onChance() {
        //Chance chance = new Chance(game, playerIndex);
        outCome = "chance";
    }

    private void onJail() {
        outCome = "jailOnVisit";
    }

    private void onGoToJail() {
        outCome = "jail";
    }

    /**
     * Checks if the player can afford something.
     * @param price
     * @return
     */
    private boolean canAfford(int price) {
        return game.getPlayerBalances()[playerIndex] > price;
    }

    /**
     * Handles the event where a player buys an ownable.
     * @param playerIndex
     * @param price
     */
    private void buyOwnable(int playerIndex, int price) {
        game.changePlayerBalance(playerIndex, -price);
        game.setOwnerIndex(actualNewPosition, playerIndex);
        outCome = "boughtOwnable";
    }

    /**
     * Handles the event where a player pays rent to another player.
     * @param playerIndex
     * @param ownerIndex
     * @param rent
     */
    private void payRent(int playerIndex, int ownerIndex, int rent) {
        game.changePlayerBalance(playerIndex, -rent);
        game.changePlayerBalance(ownerIndex, rent);
        outCome = "paidRent";
    }

    private void goBankrupt() {
        outCome = "bankrupt";
    }

    public String getOutCome() {
        return outCome;
    }

    public boolean isStartPassed() {
        return startPassed;
    }

    public int getOwnerIndex() {
        return ownerIndex;
    }

    public int getPriceAndRent() {
        return priceAndRent;
    }

    public int getActualNewPosition() {
        return actualNewPosition;
    }
}
