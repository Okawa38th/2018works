import java.util.Arrays;

public class test{
    public static void main(String[] args){
        int  a1[]={6,4,8,9,1};
        int a2[]=new int[5];
        System.arraycopy(a1,0,a2,0,a2.length);
        int a = a1.length;
        for(int i = 0; i<a2.length;i++){
            a2[a-1]=a1[i];
            a--;
        }
        a = 5;
        for(int j = a-1;j>=0;j--){
            for(int c = 0; c<a-1;c++){
                int temp = a1[c];
                if(a1[c]>a1[c+1]){
                    a1[c] = a1[c+1];
                    a1[c+1] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(a1));
        System.out.println(Arrays.toString(a2));
    }
}