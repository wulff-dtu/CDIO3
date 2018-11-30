package Game;

public class Player {

    private String name;
    private int position;
    private Bankroll bankroll;
    private boolean inJail;

    public Player(String name) {
        this.name = name;
        this.position = 0;
        bankroll = new Bankroll();
        inJail = false;
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

    public boolean isInJail() {
        return inJail;
    }

    public void setInJail(boolean inJail) {
        this.inJail = inJail;
    }
}

