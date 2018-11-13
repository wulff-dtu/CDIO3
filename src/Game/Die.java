package Game;

public class Die {

    private int sides, value;

    public Die(int sides) {
        this.sides = sides;
    }

    public int throwDie() {
        value = (int) (Math.random() * sides + 1);
        return value;
    }

    public int getValue() {
        return value;
    }
}
