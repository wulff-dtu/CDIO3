package Game;

public class DiceCup implements DiceCupInterface {

    private Die[] dice;
    private int sum;

    public DiceCup() {
        dice = new Die[0];
    }

    /**
     * Adds a die to the dicecup with a given number of sides.
     * @param sides
     */
    public void addDie(int sides) {
        Die[] newDice = new Die[dice.length + 1];
        for (int i = 0; i < dice.length; i++) {
            newDice[i] = dice[i];
        }
        newDice[dice.length] = new Die(sides);
        dice = newDice;
    }

    /**
     * throws all the dice of the cup, calculates the sum and sets the sum.
     */
    public void throwDice() {
        int accumlatedSum = 0;
        for (Die die : dice) {
            die.throwDie();
            accumlatedSum += die.getValue();
        }
        sum = accumlatedSum;
    }

    public int getSum() {
        return sum;
    }

    /**
     * Returns an array with the current face values of each die in the cup.
     * @return
     */
    public int[] getValueArray() {
        int[] diceValues = new int[dice.length];
        for (int i = 0; i < dice.length; i++) {
            diceValues[i] = dice[i].getValue();
        }
        return diceValues;
    }
}

