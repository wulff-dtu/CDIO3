package Game;

public class Bankroll {

    private int balance;

    public Bankroll() {
        this.balance = 0; //the exact amount is calculated in the Game-class dependent on the number of players
    }

    public void changeBalance(int change){
        this.balance += change;
    }

    public int getBalance() {
            return this.balance;
    }

}
