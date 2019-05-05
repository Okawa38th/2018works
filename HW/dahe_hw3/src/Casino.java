public class Casino {
    private int bank;
    private  double casinofactor;
    private  double percentage;
    private  String name;

    public Casino (String initname){
        name = initname;
        bank = 1000000; //1,000,000
    }

    public String getName() {
        return name;
    }

    public int getBank() {
        return bank;
    }

    public double getCasinofactor() {
        return casinofactor;
    }

    public void whichfactor(){
        if(bank<1000000){
            casinofactor = 0.005;
        }else{
            casinofactor = 0.01;
        }

    }
    public  int odds(int pow,int num){
        if(num == 2 ||num == 12){
            return (int)(36*Math.pow(1.0+3*casinofactor,pow));
        }else if(num == 3 || num == 11){
            return (int)(36*Math.pow(1.0+2*casinofactor,pow));
        }else if(num == 4 || num == 10){
            return (int)(36*Math.pow(1.0+casinofactor,pow));
        }else if(num == 5 || num == 9){
            return 9;
        }else if(num == 6 || num == 8){
            return (int)(7.2*Math.pow(1.0-casinofactor,pow));
        }else if(num == 7){
            return (int)(6.0*Math.pow(1.0-2*casinofactor,pow));
        }else{
            return 0;
        }
    }

    public void newbankbalance (int a){
        if(a == 1){
            bank -= DiceOddsGame.Moneyyouwin();
            percentage = ((bank-1000000.0)/1000000) * 100;
        }else{
            bank += DiceOddsGame.bet;
            percentage = ((bank-1000000.0)/1000000) * 100;
        }


    }
    @Override
    public String toString() {
        if (percentage > 0) {
            return "The Bank's account is now at $" + bank + '\n' + '\t' + "Overall, the bank's balances are up " + percentage + "%";
        } else if (percentage < 0) {
            return "The Bank's account is now at $" + bank + '\n' + '\t' + "Overall, the bank's balances are down " + percentage * -1 + "%";
        }else if(bank<=0){
            return "How did you do that! You are now on our black list!";
        }
        else {
            return "Bank's account didn't change.";
        }
    }
}
