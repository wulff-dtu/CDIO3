import Game.Bankroll;

public class PlayerDriver {

    private Bankroll bankroll;

    public PlayerDriver() {
        this.bankroll = new Bankroll();
    }

    public Bankroll getBankroll() {
        return bankroll;
    }
}