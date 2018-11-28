package Interfaces;

import Game.Die;

public interface DiceCupInterface {

    public void addDie(int sides);

    public void throwDice();

    public int getSum();

    public int[] getValueArray();

}

