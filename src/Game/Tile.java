package Game;

public class Tile {

    private String type, title, subtext, description;
    private int effectOnBalance;
    private boolean grantsExtraTurn;

    public Tile(String type, String title, String subtext, String description, int effectOnBalance, boolean grantsExtraTurn) {
        this.type = type;
        this.title = title;
        this.subtext = subtext;
        this.description = description;
        this.effectOnBalance = effectOnBalance;
        this.grantsExtraTurn = grantsExtraTurn;
    }

    public String getTitle() {
        return title;
    }

    public String getType() {
        return type;
    }

    public String getSubtext() {
        return subtext;
    }

    public String getDescription() {
        return description;
    }

    public int getEffectOnBalance() {
        return effectOnBalance;
    }

    public boolean grantsExtraTurn() {
        return grantsExtraTurn;
    }
}
