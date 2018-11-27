package Game;

public class Tile {

    private String type, title;
    private int group, price;
    private int ownerIndex; // indicates the index of the player who owns the tile (if any)

    public Tile(String type, int group, String title, int price) {
        this.type = type;
        this.group = group;
        this.title = title;
        this.price = price;
        this.ownerIndex = -1; //-1 indicates lack of ownership
    }

    public void setOwnerIndex(int ownerIndex) {
        this.ownerIndex = ownerIndex;
    }

    public int getOwnerIndex () {
        return ownerIndex;
    }

    public String getTitle() {
        return title;
    }

    public String getType() {
        return type;
    }

    public int getGroup() {
        return group;
    }

    public int getPrice() {
        return price;
    }

}
