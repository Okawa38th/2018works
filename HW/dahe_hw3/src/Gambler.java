public class Gambler {
    private String name;
    private int balance;
    private double percentage;
    private double initmoney;
    public Gambler(String initname){
        name = initname;
        balance = 0;
    }

    public String getName() {
        return name;
    }

    public int getBalance(){
        return balance;
    }
    public void setBalance(int newbalance){
        if (newbalance < 10){
            balance = 0;
        }else if (newbalance > 100000){
            balance = 1;
        }else{
            balance = newbalance;
            initmoney = newbalance;
        }
    }
    public void newgamblerbalance(int a){
        if(a==1){
            balance += DiceOddsGame.Moneyyouwin()-DiceOddsGame.bet;
            percentage = ((balance-initmoney)/initmoney) * 100;
        }else{
            balance -= DiceOddsGame.bet;
            percentage = ((balance-initmoney)/initmoney) * 100;
        }

    }
    @Override
    public String toString() {
        if (percentage > 0) {
            return name + ", you have a balance of $" + balance + '\n' + '\t' + "You increased your account by " + (int)percentage + "%"+"  Good job Good job";
        } else if (percentage < 0 && balance >0) {
            return name + ", you have a balance of $" + balance + '\n' + '\t' + "You've lost " + (int)percentage * -1 + "%"+" of your money." + '\n' + '\t' + "Pay me more money. Have more fun!" ;
        } else if(balance<=0){
            return '\t'+"You have LOST ALL YOUR MONEY!"+'\n'+'\t'+"Grab more money then come back!";
        }else{
            return "You have back to your original money. Interesting";
        }
    }

}
