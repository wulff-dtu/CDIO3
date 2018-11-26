package Game;

public class Tile {

    private String title;

    public Tile(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public int getEffectOnBalance() {
        return 0;
    }

    public int getGroup() {
        return 0;
    }

    public int getOwnerIndex() {
        return 0;
    }

    public void setOwnerIndex(int i) {}
}
