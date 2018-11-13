package Game;

public class DiceCup {

    private Die[] dice;
    private int sum;

    public DiceCup() {
        dice = new Die[0];
    }

    public void addDie(int sides) {
        Die[] newDice = new Die[dice.length + 1];
        for (int i = 0; i < dice.length; i++) {
            newDice[i] = dice[i];
        }
        newDice[dice.length] = new Die(sides);
        dice = newDice;
    }

    public void removeAllDice() {
        dice = new Die[0];
    }

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
}

