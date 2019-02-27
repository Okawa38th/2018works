package part1;
import java.util.regex.*;
public class test {
    public static void main(String[] args){
        String a = "asd";
        boolean result = isNumeric(a);
        if (result){
            System.out.print("我真牛逼");
        }else{
            System.out.print("可真是菜");
        }

    }
    public static boolean isNumeric(String str){
        Pattern a = Pattern.compile("[0-9]*");
        return a.matcher(str).matches();
    }
}

