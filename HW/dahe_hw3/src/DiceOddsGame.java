import java.util.Scanner;

public class DiceOddsGame {
    static String userinput;
    static boolean keepgoing;
    static Scanner keyboard;

    public static void main(String[] args) {
        userinput = "";
        keepgoing = true;
        keyboard = new Scanner(System.in);
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
        }else if(userinput.equals("2")){ // not finish yet

        }
    }
    private static void SetupAccount() {
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
        System.out.println("Please Enter your Name:");//not finished yet
        userinput = keyboard.nextLine();
        Gambler name = new Gambler(userinput);
        System.out.println("Please Enter your Starting Balance ($10 Min): ");
        userinput = keyboard.nextLine();
        name.setBalance(Integer.parseInt(userinput));

    }

}
