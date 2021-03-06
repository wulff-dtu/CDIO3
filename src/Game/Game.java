package Game;

public class Game {

    private Player[] players;
    private Board board;
    private DiceCupInterface diceCup;

    public Game(String[] playerNames) {
        addPlayers(playerNames);
        board = new Board();
        diceCup = new DiceCup();
        diceCup.addDie(6);
    }

    /**
     * Adds players to the game from an array of names.
     * Each player is then initialized with a balance, that is set
     * depending on the number of players.
     * @param playerNames
     */
    private void addPlayers(String[] playerNames) {
        players = new Player[playerNames.length];
        for (int i = 0; i < playerNames.length; i++) {
            players[i] = new Player(playerNames[i]);
            players[i].getBankroll().changeBalance(20-(players.length*2-4));
        }
    }

    /**
     * Wrapper method, that throws the dice in the dicecup and returns the sum.
     * @return
     */
    public int throwDice() {
        diceCup.throwDice();
        return diceCup.getSum();
    }

    public int getBoardLength() {
        return board.getTiles().length;
    }

    public void setPlayerPosition(int playerIndex, int position) {
        players[playerIndex].setPosition(position);
    }

    public void changePlayerBalance(int playerIndex, int change) {
        players[playerIndex].getBankroll().changeBalance(change);
    }

    public int getPriceAndRent(int i) {
        return board.getTiles()[i].getPrice();
    }

    public int getOwnerIndex(int i) {
        return board.getTiles()[i].getOwnerIndex();
    }

    public void setOwnerIndex(int boardIndex, int playerIndex) {
        board.getTiles()[boardIndex].setOwnerIndex(playerIndex);
    }

    public int getStartEffect() {
        return board.getTiles()[0].getPrice();
    }

    public String getTileType(int i) {
        return board.getTiles()[i].getType();
    }

    public int[] getPlayerPositions() {
        int[] positions = new int[players.length];
        for (int i = 0; i < players.length; i++) {
            positions[i] = players[i].getPosition();
        }
        return positions;
    }

    public String[] getPlayerNames() {
        String[] names = new String[players.length];
        for (int i = 0; i < players.length; i++) {
            names[i] = players[i].getName();
        }
        return names;
    }

    public int[] getPlayerBalances() {
        int[] names = new int[players.length];
        for (int i = 0; i < players.length; i++) {
            names[i] = players[i].getBankroll().getBalance();
        }
        return names;
    }

    public void setPlayerBalance(int i, int balance) {
        players[i].getBankroll().setBalance(balance);
    }

    public int[] getDiceValues() {
        return diceCup.getValueArray();
    }

    public String getTileTitle(int i) {
        return board.getTiles()[i].getTitle();
    }

    //TODO: Doesn't work yet. Should not assign a name to winners[0], since this will only return one winner. There may be two or more winners.
    public String getWinnerName() {
        String winner = "";
        int maxBalance = 0;
        for (int i = 0; i < players.length; i++) {
            if (players[i].getBankroll().getBalance() >= maxBalance){
                maxBalance = players[i].getBankroll().getBalance();
                winner = players[i].getName();
            }
        }
        return winner;
    }

    public void setDiceCup(DiceCupInterface diceCup) {
        this.diceCup = diceCup;
    }
}

