public class InsertionSortBoxSorter implements BoxSorter
{
    public void sortBoxes(ColoredBox[] boxes)
    {
        int a = boxes.length;
        for(int j = 1;j<=a-1;j++){
            for(int i = j-1;i>=0;i--){
                ColoredBox temp = boxes[i];
                if(boxes[i].getNum()<=boxes[i+1].getNum()){
                    boxes[i] = boxes[i+1];
                    boxes[i+1]=temp;
                }
            }
        }
        BoxSortingDemo.updateDisplay();
    }
}