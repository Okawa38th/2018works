import java.util.regex.Pattern;

public class test {
    public static boolean isNumeric1(String str) {
        Pattern pattern =Pattern.compile("[0-9]*");
        return pattern.matcher(str).matches();

    }
    String i = "0101";
    String[] a = i.split("");


}
