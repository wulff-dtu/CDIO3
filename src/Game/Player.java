package Game;

public class Player {

    private String name;
    private int position;
    private Bankroll bankroll;

    public Player(String name) {
        this.name = name;
        this.position = 0;
        bankroll = new Bankroll();
    }

    public Bankroll getBankroll() {
        return bankroll;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }
}

