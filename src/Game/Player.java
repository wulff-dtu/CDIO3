package Game;

public class Player {

    private String name;
    private Bankroll bankroll;

    public Player(String name) {
        this.name = name;
        bankroll = new Bankroll();
    }

    public Bankroll getBankroll() {
        return bankroll;
    }

    public String getName() {
        return name;
    }

}

