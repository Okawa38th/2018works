import java.util.Scanner;

public class DiceOddsGame {
    static String userinput;
    static boolean keepgoing; //themenu's boolean
    static Scanner keyboard;
    static boolean correctinput;
    static Gambler name;
    static int playerrolls;
    static int repeattimes;
    static int bet;
    static int rollonbet;
    static Casino bankname;
    static boolean notdraw;
    static boolean gamestatic; //startgame's boolean

    public static void main(String[] args) {
        userinput = "";
        keepgoing = true;
        notdraw = true;
        keyboard = new Scanner(System.in);
        bankname = new Casino("My bank's total balance");
        while(keepgoing)
        {
            runMainMenu();
            processMainMenuInput();
        }
    }
    private static void runMainMenu() {
        System.out.println("*********************************************************");
        System.out.println("** Dice Odds Game Main Menu                            **");
        System.out.println("**                                                     **");
        System.out.println("** Please type a menu option and press enter.          **");
        System.out.println("*********************************************************"+'\n');
        System.out.println("1) Setup a new gambling account"+'\n'+"2) Make a bet"+'\n'+"q) Quit");
        userinput = keyboard.nextLine();
    }
    private static void processMainMenuInput() {
        if(userinput.equals("1")) {
            SetupAccount();
        }else if(userinput.equals("2")){
            if(name == null){
                System.out.println("You must setup a Gambling Account before you start playing!");
            }else if(name.getBalance()<=0){
                System.out.println("You need to create a new account you little poor ass");
            } else{
                makeabet();
            }
        }else if(userinput.toLowerCase().equals("q")){
            System.out.println("See you");
            keepgoing = false;
        }else{
            System.out.println("Wrong choice!");
        }
    }
    private static void SetupAccount() {
        correctinput = true;
        System.out.println("****************************************************");
        System.out.println("    WELCOME TO Dachuan's Palace IN  Dark Fantasy    ");
        System.out.println("**                                                **");
        System.out.println("** Thank you for choosing our casino for your     **");
        System.out.println("** gambling pleasure. We will thoroughly enjoy    **");
        System.out.println("** ripping you off.                               **");
        System.out.println("**                                                **");
        System.out.println("** Before getting down to business, we need to    **");
        System.out.println("** ask you a few questions to setup your account. **");
        System.out.println("****************************************************\n");
        System.out.println("Please Enter your Name:");
        userinput = keyboard.nextLine();
        name = new Gambler(userinput);
        while(correctinput){
            acount101();
        }
        System.out.println("PRESS ENTER WHEN YOU ARE READY TO CONTINUE");
        new Scanner(System.in).nextLine();

    }
    private static void acount101(){
        System.out.println("Please Enter your Starting Balance ($10 Min): ");
        userinput = keyboard.nextLine();
        name.setBalance(Integer.parseInt(userinput));
        if(name.getBalance()==0){
            System.out.println("You are too poor to play this game, put more money!");
        }else if (name.getBalance()==1){
            System.out.println("Are you sure you have so much money? Do it again");
        }else{
            System.out.println("Thank you, "+name.getName()+" ,for opening an account with us.");
            System.out.println("We hope your balance will soon be $0."+'\n');
            correctinput = false;
        }
    }
    private  static void makeabet(){
        System.out.println("**************************************************************************");
        System.out.println("    YOU ARE PLAYING Dachuan's game IN the  Big♂Dark♂Fantasy"+'\n');
        System.out.println("                    GOOD LUCK HAVE FUN                ");
        System.out.println("                 Don't lose all your money  (˘•ω•˘)");
        System.out.println("**************************************************************************"+'\n');
        gamestatic = true;
        while(gamestatic){
            StartGame();
        }

    }
    private  static void StartGame(){
        System.out.println('\n'+ name.getName()+ ", enter the # of rolls you are betting on (1 - 50): ");
        userinput = keyboard.nextLine();
        int a = Integer.parseInt(userinput);
        bankname.whichfactor();
        if((a<1 || a>50)){
            System.out.println("Are you blind? [1-50]!!");
        }else{
            playerrolls = a;
            System.out.println("FOR " + userinput + " ROLL(S), WE USE THE FOLLOWING ODDS:");
            System.out.println("\t2:      "+bankname.odds(a,2)+ "to 1\n" +
                    "\t3:      "+bankname.odds(a,3)+ " to 1\n" +
                    "\t4:      "+bankname.odds(a,4)+ " to 1\n" +
                    "\t5:      "+bankname.odds(a,5)+ " to 1\n" +
                    "\t6:      "+bankname.odds(a,6)+ " to 1\n" +
                    "\t7:      "+bankname.odds(a,7)+ " to 1\n" +
                    "\t8:      "+bankname.odds(a,8)+ " to 1\n" +
                    "\t9:      "+bankname.odds(a,9)+ " to 1\n" +
                    "\t10:     "+bankname.odds(a,10)+ " to 1\n" +
                    "\t11:     "+bankname.odds(a,11)+ " to 1\n" +
                    "\t12:     "+bankname.odds(a,12)+ " to 1");
            System.out.println(name.getName() + ", what roll would you like to bet on? (2 - 12)");
            rollonbet = Integer.parseInt(keyboard.nextLine());
            System.out.println(name.getName() + ", enter your bet (min $10, max $100000): $");
            bet = Integer.parseInt(keyboard.nextLine());
            if(name.getBalance()< bet ){
                System.out.println("You don't have ENOUGH MONEY");
            }else{
                Gameprocess();
            }

        }

    }
    private static void Gameprocess() {
        int[] array = new int[playerrolls];
        int[] times = new int[11];
        for (int a = 0; a < playerrolls; a++) {
            int die1 = ((int) (Math.random() * 6)) + 1;
            int die2 = ((int) (Math.random() * 6)) + 1;
            array[a] = die1 + die2;
        }
        for(int i =2; i<=12;i++){
            int c= 0;
            for (int b=0;b<array.length;b++){
                if(i==array[b]){
                    c++;
                }
            }
            repeattimes = c;
            times[i-2] = c; //Each number 's show up time
            if(i>=10){
                System.out.println(i+":     ("+c+")"+ repeat());
            }else{
                System.out.println(i+":      ("+c+")"+ repeat());
            }

        }
        int d = 0;
        int c = 0;
        for(int h = 1; h<times.length;h++){
            if (times[h]>d){
                d = times[h];
                c = h;
            }
        }
        for(int t = 0; t<times.length;t++){
            if(times[t]==d && t!=c){
                notdraw = false;
            }
        }
        if(notdraw){
            int indexofthebiggest = c + 2;
            System.out.println("The roll of " + indexofthebiggest + " wins!");
            System.out.println("It was rolled " + d + " time(s)!");
            if (rollonbet == indexofthebiggest) {
                System.out.println(name.getName() + ", YOU WIN $" + Moneyyouwin() + '\n');
                bankname.newbankbalance(1);//  "1" means the player in winning
                name.newgamblerbalance(1);
            } else {
                System.out.println(name.getName() + ", You LOSE $" + bet + '\n');
                bankname.newbankbalance(0);
                name.newgamblerbalance(0);
            }

            if(name.getBalance()<=0){
                System.out.println(bankname.toString());
                System.out.println(name.toString());
                gamestatic = false;
            }else if(bankname.getBank()<= 0){
                keepgoing = false;
            }
            else{
                System.out.println(bankname.toString());
                System.out.println(name.toString());
                System.out.println("Would you like to make another bet? (y/n):  ");
                userinput = keyboard.nextLine();
                if(userinput.toLowerCase().equals("n")){
                    gamestatic = false;
                }
            }

        }else{
            System.out.println("Draw!!!");
            System.out.println("Return to the game");
            notdraw = true;
        }

    }
    private static StringBuffer repeat(){
        StringBuffer a = new StringBuffer();
        if(repeattimes == 0){
            return a;
        }else{
            for (int b = 1; b <= repeattimes; b++) {
                a.append("X");
            }
            return a;
        }
    }

    public static int Moneyyouwin(){
        return bet * bankname.odds(playerrolls,rollonbet);
    }
}
