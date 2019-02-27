package lab7;
import java.util.Scanner;
/**
 * This class contains a method for converting a String representing
 * a binary number into a decimal number. The program demonstrates
 * use of this number using randomly generated 4-bit binary numbers.
 *
 * @author Richard McKenna
 * @author Dachuan He Name
 */
public class BinaryToDecimalConverter {
    /**
     * Here's where the program starts
     */
    public static void main(String[] args) {
        // LET'S MAKE 10 RANDOM BINARY STRINGS, CONVERT THEM, AND SHOW THE OUTPUT
        for (int i = 0; i < 10; i++) {
            String binaryString = generateRandomBinaryString();
            int decimalNumber = convertBinaryStringToDecimalNumber(binaryString);
            System.out.println(binaryString + " is " + decimalNumber + " in decimal");
        }
    }

    /**
     * This helper method makes and returns a random 4-bit binary number string
     */
    public static String generateRandomBinaryString() {
        String binNumber = "";
        for (int i = 0; i < 4; i++) {
            if (Math.random() < 0.5)
                binNumber += 1;
            else
                binNumber += 0;
        }
        return binNumber;
    }

    /**
     * YOU MUST DEFINE THIS METHOD
     * <p>
     * This method should take the binaryNumberString argument and determine
     * what decimal number it represents. You should calculate and return
     * that number.
     */
    public static int convertBinaryStringToDecimalNumber(String binaryNumberString) {
        int result = 0;
        int i = 0;
        for (int b = binaryNumberString.length(); b>=0; b--) {
            String a = binaryNumberString.substring(b-1,b);
            int c = Integer.parseInt(a);
            if (c == 1) {
                double num = Math.pow(2, i);
                result += num;
                i++;
            }else{
                i++;
            }
        }
        return result;
    }
}
