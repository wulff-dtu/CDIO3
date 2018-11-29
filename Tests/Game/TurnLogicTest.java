package Game;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TurnLogicTest {

    private Game setupTestGame(String[] players, int[] predeterminedDiceValues) {
        MockDiceCup diceCup = new MockDiceCup(predeterminedDiceValues);
        Game game = new Game(players);
        game.setDiceCup(diceCup);
        return game;
    }

    @Test
    void testPurchase() {
        String[] players = {"player1", "player2"};
        int[] predeterminedDiceValues = {1};
        Game game = setupTestGame(players, predeterminedDiceValues);

        assertEquals(-1, game.getOwnerIndex(1)); //checks that the tile is not owned by anyone.

        TurnLogic turn = new TurnLogic(game, 0);
        turn.runTurn();

        assertEquals(19, game.getPlayerBalances()[0]); //checks if player 1 has the right balance, if he/she purchased the ownable.
        assertEquals(20, game.getPlayerBalances()[1]); //checks if player 2's balance is unchanged.
        assertEquals(0, game.getOwnerIndex(1)); //checks if the tile, that player1 landed on (index 1), is owned by player1 (who has index 0).
    }

    @Test
    void testPayRent() {
        String[] players = {"player1", "player2"};
        int[] predeterminedDiceValues = {1};
        Game game = setupTestGame(players, predeterminedDiceValues);

        game.setOwnerIndex(1, 1); //sets player2 as the owner of the second tile on the board (the burger bar).

        TurnLogic turn = new TurnLogic(game, 0);
        turn.runTurn();

        assertEquals(19, game.getPlayerBalances()[0]); //checks if player 1 has the right balance, if he/she paid rent.
        assertEquals(21, game.getPlayerBalances()[1]); //checks if player 2 has the right balance, if he/she got paid.
    }

    @Test
    void testLandOnOwnProperty() {
        String[] players = {"player1", "player2"};
        int[] predeterminedDiceValues = {1};
        Game game = setupTestGame(players, predeterminedDiceValues);

        game.setOwnerIndex(1, 0); //sets player1 as the owner of the second tile on the board (the burger bar).

        TurnLogic turn = new TurnLogic(game, 0);
        turn.runTurn();

        assertEquals(20, game.getPlayerBalances()[0]); //checks if player 1 remains unchanged, because he/she owns the tile.
        assertEquals(20, game.getPlayerBalances()[1]); //checks that player 2 remains unchanged.
    }

    @Test
    void testLandOnStart() {
        String[] players = {"player1", "player2"};
        int[] predeterminedDiceValues = {2};
        Game game = setupTestGame(players, predeterminedDiceValues);

        game.setPlayerPosition(0, 22);

        TurnLogic turn = new TurnLogic(game, 0);
        turn.runTurn();

        assertEquals(20 + game.getStartEffect(), game.getPlayerBalances()[0]);
    }

    @Test
    void testPassStart() {
        String[] players = {"player1", "player2"};
        int[] predeterminedDiceValues = {3};
        Game game = setupTestGame(players, predeterminedDiceValues);

        game.setPlayerPosition(0, 22);

        TurnLogic turn = new TurnLogic(game, 0);
        turn.runTurn();

        //Player 1's balance should be 21, because player 1 will land on Burger Bar and buy it for 1,
        // but at the same time receives 2.
        assertEquals(21, game.getPlayerBalances()[0]);
    }

    @Test
    void testContinueFromLastPosition() {
        String[] players = {"player1", "player2"};
        int[] predeterminedDiceValues = {3, 5};
        Game game = setupTestGame(players, predeterminedDiceValues);

        TurnLogic turn = new TurnLogic(game, 0);
        turn.runTurn();
        turn = new TurnLogic(game, 0);
        turn.runTurn();

        assertEquals(8, game.getPlayerPositions()[0]);
    }

    @Test
    void testOutcomes() {
        String[] players = {"player1", "player2"};
        int[] predeterminedDiceValues = {1, 1, 1, 3, 6, 6};
        Game game = setupTestGame(players, predeterminedDiceValues);
        game.setOwnerIndex(2, 1);

        TurnLogic turn = new TurnLogic(game, 0);
        turn.runTurn();
        assertEquals("boughtOwnable", turn.getOutCome());
        turn.runTurn();
        assertEquals("paidRent", turn.getOutCome());
        turn.runTurn();
        assertEquals("chance", turn.getOutCome());
        turn.runTurn();
        assertEquals("jailOnVisit", turn.getOutCome());
        turn.runTurn();
        assertEquals("refuge", turn.getOutCome());
        turn.runTurn();
        assertEquals("gotojail", turn.getOutCome());
    }

    @Test
    void testBankruptcyOutcome() {
        String[] players = {"player1", "player2", "player3", "player4"};
        int[] predeterminedDiceValues = {1, 1};
        Game game = setupTestGame(players, predeterminedDiceValues);
        game.setPlayerBalance(0, 1);

        assertEquals(1, game.getPlayerBalances()[0]);
        TurnLogic turn = new TurnLogic(game, 0);
        turn.runTurn();
        assertEquals("boughtOwnable", turn.getOutCome());
        assertEquals(0, game.getPlayerBalances()[0]);
        turn.runTurn();
        assertEquals("bankrupt", turn.getOutCome());
    }
}