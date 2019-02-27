package part1;

import java.util.regex.Pattern;

/**
 * Students should define the isValidIpAddress and generateRandomIpAddress
 * methods for Part 1 of HW 2. Note that you may (and should) add whatever
 * additional methods you like to help these two required methods perform
 * their intended function. Such additional methods are called helper methods
 * because they help other methods work properly.
 *
 * @author Dachuan He
 */
public class IpAddressVerifier
{
    /**
     * YOU MUST DEFINE THIS METHOD - YOU MAY ADD HELPER METHODS
     *
     * isValidIpAddress - This method should examine the testIpAddress
     * method argument and determine if it is in the proper format. If it
     * is, return true, otherwise return false;
     */
    public static boolean isValidIpAddress(String testIpAddress)
    {
        String a ="0123456789";
        if(testIpAddress.substring(testIpAddress.length()-1).contains(".") || !testIpAddress.contains("."))
        {
            return false;
        } else {
            String[] test1 = testIpAddress.split("\\.");
            if (test1.length != 4)
            {
                return false;
            }else {
                for(int b=0;b<=3;b++)
                {
                    boolean test2 = isNumeric(test1[b]);
                    if (test2)
                    {
                        for(int i = 0;i<=3;i++)
                        {
                            int num =Integer.parseInt(test1[i]);
                            if (num >255)
                            {
                                return false;
                            }
                        }return true;
                    }else
                        {
                        return false;
                        }
                }
            }
            }return false;
    }
    /**
     * YOU MUST DEFINE THIS METHOD - YOU MAY ADD HELPER METHODS
     *
     * generateRandomIpAddress - This method should randomly generate and
     * then return a String storing a textual representation of an
     * IP Address in the format of Num.Num.Num.Num, where each Num is
     * and integer from 0 - 255 inclusive.
     */
    public static String generateRandomIpAddress()
    {
        StringBuffer result = new StringBuffer();
        for(int i = 0; i<=3;i++)
        {
            double a = Math.random()*255;
            int b = (int)a;
            String c = String.valueOf(b);
            result.append(c);
            if(i!=3)
            {
                result.append(".");
            }
        }
        String finalresult = new String(result);
        return finalresult;
    }
    public static boolean isNumeric(String str)
    {
        Pattern a = Pattern.compile("[0-9]*");
        return a.matcher(str).matches();
    }
}
