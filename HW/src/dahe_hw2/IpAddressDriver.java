package dahe_hw2;

import java.util.Scanner;

/**
 * DO NOT CHANGE THIS CLASS - Note that you may use of the code
 * that I give you in other programs that you write. For example,
 * the code I have provided to you in this class may be used in
 * part 2 of this assignment.
 *
 * IpAddressDriver - This class is a driver program, which is used for
 * testing other code. In this case, it is used for testing your IpAddressVerifier
 * methods, which you will author for Part 1 of HW 2.
 *
 * This program provides a menu where the user may choose between entering an
 * IP address or quitting the program. If the user chooses to enter an address,
 * the program will prompt the user to enter an address, and then use your isValidIpAddress
 * method to verify whether it is valid or not.
 *
 * Every student should go over the code I have provided here and try to understand
 * what every line of code is doing and how the program works. Note the way that I use
 * helper methods to organize my program. This is essential to writing larger programs.
 *
 * @author McKilla Gorilla
 *
 */
public class IpAddressDriver
{
    // THESE ARE OUR LOOP CONTROL VARIABLES
    // WE'LL MAKE THEM STATIC, OUTSIDE ALL METHODS
    // SO THAT ALL METHODS CAN EASILY SHARE THEM
    static String userInput;
    static boolean keepGoing;

    // WE'LL USE THIS IN A COUPLE OF DIFFERENT METHODS
    // FOR GETTING USER INPUT
    static Scanner keyboard;

    /**
     * This is where our program starts.
     */
    public static void main(String[] args)
    {
        // INITIALIZE OUR LOOP CONTROL VARIABLES
        userInput = ""; 	// EMPTY INPUT
        keepGoing = true;	// KEEP LOOPING

        // INITIALIZE THE Scanner
        keyboard = new Scanner(System.in);

        // THIS LOOP WILL CONTINUE TO RUN, RE-PROMPTING THE USER
        // UNTIL THE USER ASKS TO QUIT
        while (keepGoing)
        {
            // CALL OUR HELPER METHOD FOR GETTING INPUT FROM THE USER
            runMainMenu();

            // DO SOMETHING WITH THE USER INPUT
            processMainMenuInput();
        }
    }

    /**
     * runMainMenu - This helper method displays the main menu to
     * the user and then gets the user selection, placing it in the
     * userInput variable.
     */
    private static void runMainMenu()
    {
        System.out.println("*** SELECT A MENU OPTION ***");
        System.out.println("1) Test an IP Address");
        System.out.println("2) Generate a Random IP Address");
        System.out.println("Q) Quit");
        System.out.print("ENTER: ");
        userInput = keyboard.nextLine();
    }

    /**
     * processMainMenuInput - This helper method examines the
     * input the user provided and then provides the appropriate
     * response, including giving feedback if the user entered
     * an illegal selection.
     */
    private static void processMainMenuInput()
    {
        // 1)
        if (userInput.equals("1"))
        {
            runTestIpAddress();
        }
        // 2)
        else if (userInput.equals("2"))
        {
            runGenerateRandomIpAddress();
        }
        // Q or q
        else if (userInput.toUpperCase().equals("Q"))
        {
            System.out.println("\nGoodbye\n");
            keepGoing = false;
        }
        // ENTRY NOT A VALID OPTION
        else
        {
            System.out.println("\nINVALID INPUT - Please enter a menu choice\n");
        }
    }

    /**
     * runTestIpAddress - This method provides the program's response
     * for when the user selects option 3). It will employ the student-defined
     * isValidIpAddress method.
     */
    private static void runTestIpAddress()
    {
        System.out.print("\nEnter an IP Address to Test: ");
        userInput = keyboard.nextLine();
        boolean testResults = IpAddressVerifier.isValidIpAddress(userInput);
        if (testResults)
        {
            System.out.println("That is a Valid IP Address Format\n");
        }
        else
        {
            System.out.println("INVALID IP Address Format\n");
        }
    }

    /**
     * runGenerateRandomIpAddress - This method provides the program's response
     * for when the user selects option 2). It will employ the student-defined
     * generateRandomIpAddress method.
     */
    private static void runGenerateRandomIpAddress()
    {
        String randomAddress = IpAddressVerifier.generateRandomIpAddress();
        System.out.println("\nRandom IP Address: " + randomAddress);
        boolean testResults = IpAddressVerifier.isValidIpAddress(randomAddress);
        if (testResults)
            System.out.println("The randomly generated IP Address is in the proper format\n");
        else
            System.out.println("ERROR - your randomly generated IP Address is in an incorrect format\n");
    }
}