package part2;

import java.util.Scanner;

import static part2.CheckAndRun.randomsth;

public class ATypingTestGame
{
    static String userinput;
    static boolean keepgoing;
    static Scanner keyboard;
    static double highscore;

    public  static void main(String[] args)
    {
        System.out.println("*** WELCOME TO Dachuan He'S TYPING TEST GAME *** ");
        userinput = "";
        keepgoing = true;
        keyboard = new Scanner(System.in);
        while(keepgoing)
        {
          runMainMenu();

          processMainMenuInput();
        }
    }

    private static void runMainMenu()
    {
        System.out.println("*** GAME MENU ***");
        System.out.println("(p) play another round");
        System.out.println("(x) exit the game");
        System.out.println("Selection: ");
        userinput = keyboard.nextLine();
    }

    private  static void processMainMenuInput()
    {
        if(userinput.toUpperCase().equals("P"))
        {
            runAnotherRound();
        }
        else if( userinput.toUpperCase().equals("X"))
        {
            System.out.println("\nGoodbye!\n");
            keepgoing = false;
        }
        else
        {
            System.out.println("\nINVALID INPUT - Please enter a menu choice\n");
        }

    }


    private  static void runAnotherRound()
    {
        StringBuffer b = randomsth();
        System.out.print(b+"\n");
        double timeused = CheckAndRun.timing(b);
        boolean testyourtype = CheckAndRun.test(b);
        if(testyourtype)
        {
            System.out.print("Text to Match: " );
            System.out.println(b +"\n"+"\t"+ "\t"+ CheckAndRun.yourinput);
            if(timeused>=highscore)
            {
                System.out.println("Speed: " + CheckAndRun.changetofraction(timeused) + "characters per minute");
                System.out.println("NEW FASTED TYPING SPEED!");
                highscore = timeused;
                System.out.println("Top Speed: " + CheckAndRun.changetofraction(highscore) + "characters per minute");
            }
            else
            {
                System.out.println("Speed: " + CheckAndRun.changetofraction(timeused) + "characters per minute");
                System.out.println("Top Speed: " + CheckAndRun.changetofraction(highscore) + "characters per minute");
            }
        }
        else
        {
            System.out.println("INCORRECTLY TYPED, YOU GET A SPEED OF 0!");
        }


    }
}
