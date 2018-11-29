package Game;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    private Game setupTestGame(String[] players, int[] predeterminedValues) {
        MockDiceCup diceCup = new MockDiceCup(predeterminedValues);
        Game game = new Game(players);
        game.setDiceCup(diceCup);
        return game;
    }

    @Test
    void testStartBalance() {
        String[] twoPlayers = {"player1", "player2"};
        String[] threePlayers = {"player1", "player2", "player3"};
        String[] fourPlayers = {"player1", "player2", "player3", "player4"};

        Game game = new Game(twoPlayers);
        assertEquals(20, game.getPlayerBalances()[0]);
        assertEquals(20, game.getPlayerBalances()[1]);

        game = new Game(threePlayers);
        assertEquals(18, game.getPlayerBalances()[0]);
        assertEquals(18, game.getPlayerBalances()[1]);
        assertEquals(18, game.getPlayerBalances()[2]);

        game = new Game(fourPlayers);
        assertEquals(16, game.getPlayerBalances()[0]);
        assertEquals(16, game.getPlayerBalances()[1]);
        assertEquals(16, game.getPlayerBalances()[2]);
        assertEquals(16, game.getPlayerBalances()[3]);
    }

    @Test
    void testGetWinnerName() {
        String[] players = {"player1", "player2"};
        int[] predeterminedValues = {1};
        Game game = setupTestGame(players, predeterminedValues);

        TurnLogic turn = new TurnLogic(game, 0);
        turn.runTurn();

        assertEquals("player2", game.getWinnerName());
        assertTrue(game.getPlayerBalances()[1] > game.getPlayerBalances()[0]);
    }

}