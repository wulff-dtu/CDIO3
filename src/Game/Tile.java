package Game;

public class Tile {

    private String type, title, subtext, description;
    private int group, effectOnBalance;
    private boolean grantsExtraTurn;

    public Tile(String type, int group, String title, String subtext, String description, int effectOnBalance, boolean grantsExtraTurn) {
        this.type = type;
        this.group = group;
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

    public int getGroup() {
        return group;
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

    public String effectToString() {
        if (effectOnBalance == 0) {
            return "";
        } else {
            return "" + effectOnBalance;
        }
    }
}
