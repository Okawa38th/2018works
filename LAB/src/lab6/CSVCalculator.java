package lab6;

import java.util.Scanner;
public class CSVCalculator {
    public static void main(String[]args){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a CSV string");
        String test1 = input.nextLine();
        if(test1.indexOf(",")<0){
            System.out.print("Must have at least one comma ");
        }else{
            int answer = 0;
            String[] test2 = test1.split(",");
            for(int i=0; i<=test2.length;i++){
                int test3 = Integer.parseInt(test2[i]);
                if (!Character.isDigit(test3)){
                    System.out.print("Only integers are allowed");
                }else{
                    answer += test3;
                }
            }
            String a =test1.replace(',','+');
            System.out.println(a +"="+answer);


        }
    }
}
