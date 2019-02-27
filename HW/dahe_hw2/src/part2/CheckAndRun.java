package part2;

import java.text.NumberFormat;
import java.time.Duration;
import java.time.Instant;
import java.util.Scanner;

public class CheckAndRun {
    static String yourinput;
    static Scanner keyboard;
    static  double timeyouused;


    public static StringBuffer randomsth()
    {
        String zimu = "abcdefghijklmnopqrstuvwxyz";
        StringBuffer b = new StringBuffer();
        char[] a = zimu.toCharArray();
        double x = Math.random()*20+10;
        for(int c = (int)x;c>=0;c--)
        {
            b.append(a[(int)(Math.random()*26)]);
        }
        return b;
    }


    public static double timing(StringBuffer typed)
    {
        keyboard = new Scanner(System.in);
        Instant start = Instant.now();
        yourinput = keyboard.nextLine();
        Instant end = Instant.now();
        Duration duration = Duration.between(start,end);
        long time1 = duration.toNanos();
        timeyouused = (typed.length()/(time1/1000000000.0))*60;
        return timeyouused;
    }

    public static boolean test(StringBuffer myrandom)
    {
        String my1 = myrandom.toString();
        if(my1.equals(yourinput))
        {
            return true;
        }
        else
        {
            return false;
        }

    }
    public static String changetofraction(double number)
    {
        NumberFormat numberFormat = NumberFormat.getInstance();
        numberFormat.setMaximumFractionDigits(1);
        return numberFormat.format(number);
    }
}
