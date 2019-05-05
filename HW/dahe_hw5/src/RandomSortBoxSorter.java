public class RandomSortBoxSorter implements BoxSorter
{
    public void sortBoxes(ColoredBox[] boxes)
    {
        boolean loop = true;
        while(loop) {
            for (int i = 0; i < boxes.length; i++) {
                int a = (int) (Math.random() * (boxes.length - i));
                ColoredBox temp = boxes[i];
                boxes[i] = boxes[a];
                boxes[a] = temp;
            }
            int d = 0;
            for(int c = 0; c<boxes.length-1;c++){
                if(boxes[c].getNum()>boxes[c+1].getNum()){
                    d++;
                }
            }
            if (d ==4){
            loop = false;}
        }
        BoxSortingDemo.updateDisplay();
    }
}