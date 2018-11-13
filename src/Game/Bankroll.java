package Game;

public class Bankroll {

    private int balance;

    //The Game starts with each player having 1000
    public Bankroll() {
        this.balance = 1000;
    }


    //The bankroll can't be negative
    public void checkIfNegative(){
        if(this.balance < 0 ){
            this.balance = 0;
        }
    }

    public void changeBalance(int change){
        this.balance += change;
        checkIfNegative();
    }

    //Get balance
    public int getBalance() {
            return this.balance;
    }

}
