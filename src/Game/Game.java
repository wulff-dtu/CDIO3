package Game;

public class Game {

    private Player[] players;
    private Board board;
    private DiceCup diceCup;
    private Turn turn;
    private int playerTurnIndex;
    private boolean winnerFound;
    private Player winner;

    public Game(String[] playerNames) {
        addPlayers(playerNames);
        shufflePlayerIndex(players.length); //"players.length" is an arbitrary number of times. Could be many more.
        playerTurnIndex = 0;
        board = new Board();
        diceCup = new DiceCup();
        diceCup.addDie(6);
        winnerFound = false;
    }

    private void addPlayers(String[] playerNames) {
        players = new Player[playerNames.length];
        for (int i = 0; i < playerNames.length; i++) {
            players[i] = new Player(playerNames[i]);
        }
    }

    public void newTurn() {
        turn = new Turn(players[playerTurnIndex], board, diceCup);
        if (players[playerTurnIndex].getBankroll().getBalance() >= 3000) {
            winnerFound = true;
            winner = players[playerTurnIndex];
        }
        playerTurnIndex++;
        if (playerTurnIndex == players.length) playerTurnIndex = 0;
    }

    private void shufflePlayerIndex(int times) {
        for (int i = 0; i < times; i++) {
            int randomPlayerIndex1 = (int) (Math.random() * players.length);
            int randomPlayerIndex2 = (int) (Math.random() * players.length);
            Player randomPlayer1 = players[randomPlayerIndex1];
            Player randomPlayer2 = players[randomPlayerIndex2];
            players[randomPlayerIndex2] = randomPlayer1;
            players[randomPlayerIndex1] = randomPlayer2;
        }
    }

    public Player[] getPlayers() {
        return players;
    }

    public boolean isWinnerFound() {
        return winnerFound;
    }

    public Turn getTurn() {
        return turn;
    }

    public int getPlayerTurnIndex() {
        return playerTurnIndex;
    }

    public void setPlayerTurnIndex(int playerTurnIndex) {
        this.playerTurnIndex = playerTurnIndex;
    }

    public DiceCup getDiceCup() {
        return diceCup;
    }

    public Player getWinner() {
        return winner;
    }

    public Board getBoard() {
        return board;
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
}