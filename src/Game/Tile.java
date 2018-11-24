package Game;

public class Tile {

    private String type, title, subtext, description;
    private int group, price;
    private int ownerIndex; // indicates the index of the player who owns the tile (if any)

    public Tile(String type, int group, String title, String subtext, String description, int price) {
        this.type = type;
        this.group = group;
        this.title = title;
        this.subtext = subtext;
        this.description = description;
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

    public String getSubtext() {
        return subtext;
    }

    public int getGroup() {
        return group;
    }

    public String getDescription() {
        return description;
    }

    public int getPrice() {
        return price;
    }

    public String priceToString() {
        if (price == 0) {
            return "";
        } else {
            return "" + price;
        }
    }

    public String[] toStringArr() {
        String[] arr = {type, ""+group, title, subtext, description, ""+price, ""+ownerIndex};
        return arr;
    }
}
