package midterm2;

public class test {
    public static  void main(String[] args){
        Rect r = new Rect();
        r.x = 5;
        r.y = 6;
        r.width = 7;
        int num = r.x;
        num++;
        r.y += r.y;
        r.width++;
        System.out.println(r.x);
        System.out.println(r.y);
        System.out.println(r.width);

    }
}
