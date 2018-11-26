package Game;

public class Tile_Start extends Tile {

    private int moneyGrantedOnPass;

    public Tile_Start(String title, int moneyGrantedOnPass) {
        super(title);
        this.moneyGrantedOnPass = moneyGrantedOnPass;
    }

    public int getEffectOnBalance() {
        return moneyGrantedOnPass;
    }
}
