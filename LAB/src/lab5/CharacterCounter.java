package lab5;
public class CharacterCounter {
    public static void main(String[] args) {
        String text = "8675309";
        char target = '4';
        int minIndex = 2;
        int maxIndex = 6;
        mm(text, target, minIndex, maxIndex);

        text = "112123123412345123456123456712345678";
        target = '3';
        minIndex = 7;
        maxIndex = 26;
        mm(text, target, minIndex, maxIndex);


        text = "1111112222222223333333344444445555555";
        target = '2';
        minIndex = 4;
        maxIndex = 14;
        mm(text, target, minIndex, maxIndex);

    }

    public static void mm(String text, char target, int minIndex, int maxIndex) {
        int index = minIndex;
        int counter = 0;

        while (index <= maxIndex) {
            if (text.charAt(index) == target)
                counter++;
            index++;
        }
        System.out.println("There is/are " + counter + " " + target + "s "
                + " in " + text + " in the range from indices " + minIndex + " to "
                + maxIndex);
    }
}