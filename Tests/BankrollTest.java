import Game.Bankroll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BankrollTest {



    @Test
    void changeBalance() {
        Bankroll testBankroll = new Bankroll();
        testBankroll.changeBalance(Integer.MIN_VALUE);
        assertEquals(Integer.MIN_VALUE+0,testBankroll.getBalance());

        testBankroll = new Bankroll();
        testBankroll.changeBalance(Integer.MIN_VALUE -1);
        assertEquals(Integer.MIN_VALUE-1,testBankroll.getBalance());

        testBankroll = new Bankroll();
        testBankroll.changeBalance(Integer.MIN_VALUE+1);
        assertEquals(Integer.MIN_VALUE+1,testBankroll.getBalance());

        testBankroll = new Bankroll();
        testBankroll.changeBalance(0-1);
        assertEquals(0-1,testBankroll.getBalance());

        testBankroll = new Bankroll();
        testBankroll.changeBalance(0);
        assertEquals(0,testBankroll.getBalance());

        testBankroll = new Bankroll();
        testBankroll.changeBalance(0+1);
        assertEquals(0+1,testBankroll.getBalance());

        testBankroll = new Bankroll();
        testBankroll.changeBalance(Integer.MAX_VALUE);
        assertEquals(Integer.MAX_VALUE+0,testBankroll.getBalance());

        testBankroll = new Bankroll();
        testBankroll.changeBalance(Integer.MAX_VALUE-1);
        assertEquals(Integer.MAX_VALUE-1,testBankroll.getBalance());

        testBankroll = new Bankroll();
        testBankroll.changeBalance(Integer.MAX_VALUE+1);
        assertEquals(Integer.MAX_VALUE+1,testBankroll.getBalance());


    }

    @Test
    void Bankroll(){
        PlayerDriver testPlayer = new PlayerDriver();

        assertTrue(testPlayer.getBankroll() != null); //tests if the bankroll attribute is empty or not

        assertTrue(testPlayer.getBankroll() instanceof Bankroll); //tests if the bankroll attribute is a Bankroll object
    }

}