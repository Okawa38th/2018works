import java.util.Arrays;

public class BubbleSortBoxSorter implements BoxSorter
{
    public void sortBoxes(ColoredBox[] boxes)
    {
        int a = boxes.length;
        int j = a-1;
        while(j!=0){
            for(int i = 0; i<a-1;i++){
                ColoredBox temp = boxes[i];
                if(boxes[i].getNum()<boxes[i+1].getNum()){
                    boxes[i] = boxes[i+1];
                    boxes[i+1] = temp;
                }
            }
            j--;
        }
        BoxSortingDemo.updateDisplay();
    }

}