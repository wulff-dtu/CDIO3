package Game;

public class Tile_Ownable extends Tile {

    private int group, priceAndRent, ownerIndex;

    public Tile_Ownable(String title, int group, int priceAndRent) {
        super(title);
        this.group = group;
        this.priceAndRent = priceAndRent;
        ownerIndex = -1; // "-1" is the default ownerIndex, which indicates that it is not owned by anyone yet.
    }

    public int getGroup() {
        return group;
    }

    public int getOwnerIndex() {
        return ownerIndex;
    }

    public void setOwnerIndex(int i) {
        ownerIndex = i;
    }

    public int getEffectOnBalance() {
        return priceAndRent;
    }
}
