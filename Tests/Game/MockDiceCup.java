package Game;

import Interfaces.DiceCupInterface;

public class MockDiceCup implements DiceCupInterface {

    private int sum;
    private int valueIndex;
    private int[] predeterminedValues;

    public MockDiceCup(int[] predeterminedValues) {
        this.predeterminedValues = predeterminedValues;
        valueIndex = 0;
    }

    /**
     * Adds a die to the dicecup with a given number of sides.
     * @param sides
     */
    public void addDie(int sides) {
    }

    /**
     * throws all the dice of the cup, calculates the sum and sets the sum.
     */
    public void throwDice() {
        sum = predeterminedValues[valueIndex];
        valueIndex++;
    }

    public int getSum() {
        return sum;
    }

    /**
     * Returns an array with the current face values of each die in the cup.
     * @return
     */
    public int[] getValueArray() {
        int[] values = new int[1];
        values[0] = sum;
        return values;
    }
}

