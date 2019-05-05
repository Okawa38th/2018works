import java.math.BigInteger;
import java.security.SecureRandom;

public class BigIntegerExample {
    public static void main(String[] args) {
        // Pick a Random Number of 256 bits
        BigInteger hugeNumber = new BigInteger(256, new SecureRandom());
        BigInteger two = new BigInteger("2");
        System.out.println();

        // ADDITION
        System.out.print(hugeNumber);
        hugeNumber = hugeNumber.add(two);
        System.out.println(" + " + two + " = \n" + hugeNumber);

        // MULTIPLICATION
        System.out.print("\n" + hugeNumber);
        hugeNumber = hugeNumber.multiply(two);
        System.out.println(" * " + two + " = \n" + hugeNumber);

        // SUBTRACTION
        System.out.print("\n" + hugeNumber);
        hugeNumber = hugeNumber.subtract(two);
        System.out.println(" - " + two + " = \n" + hugeNumber);

        // REALLY BIG MULTIPLICATION
        BigInteger bigPrimeNumber = new BigInteger(256, 50, new SecureRandom());
        System.out.print("\n" + hugeNumber);
        hugeNumber = hugeNumber.multiply(bigPrimeNumber);
        System.out.println(" * " + bigPrimeNumber + " = \n" + hugeNumber);
    }
}
