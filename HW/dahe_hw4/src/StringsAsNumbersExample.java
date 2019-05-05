import java.math.BigInteger;

public class StringsAsNumbersExample
{
    public static void main(String[] args)
    {
        String helloString = "Hello";
        BigInteger helloNumerically = new BigInteger(helloString.getBytes());
        System.out.println(helloString + " as a BigInteger is " + helloNumerically);

        BigInteger worldNumerically = new BigInteger("96136172692513");
        String worldString = new String(worldNumerically.toByteArray());
        System.out.println(worldNumerically + " as a String is " + worldString);

        BigInteger sumNumerically = helloNumerically.add(worldNumerically);
        String sumString = new String(sumNumerically.toByteArray());

        System.out.println(helloString + " + " + worldString + " = " + helloString + worldString + " AND");
        System.out.println(helloNumerically + " + " + worldNumerically + " = " + sumNumerically + " BUT");
        System.out.print(sumNumerically + " as a String is:" + sumString);

        String originalStevenWrightJokes = "\nI bought some dehydrated water, but I don't know what to add to it."
                + "\nWhen I get real bored, I like to drive downtown and get a great parking spot,"
                + " then sit in my car and count how many people ask me if I'm leaving."
                + "\nWhen I was little, my grandfather used to make me stand in a closet for 5 minutes"
                + " without moving. He said it was elevator practice."
                + "\nI hate it when my foot falls asleep during the day because that means it's going"
                + " to be up all night.";
        BigInteger jokesNumerically = new BigInteger(originalStevenWrightJokes.getBytes());
        String jokes = new String(jokesNumerically.toByteArray());
        System.out.println(originalStevenWrightJokes);
        System.out.println("\tas a number is: " + jokesNumerically);
        System.out.println("\twhich as a String is " + jokes);
    }
}