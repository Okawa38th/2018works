public class RadixSortBoxSorter implements BoxSorter
{
    public void sortBoxes(ColoredBox[] boxes)
    {
        int[] a = new int[boxes.length];
        for(int i =0; i <boxes.length;i++){
            a[i]=boxes[i].getNum()%10;}
        int j = boxes.length-1;
        while(j!=0){
            for(int i = 0; i<boxes.length-1;i++){
                ColoredBox Temp = boxes[i];
                int temp = a[i];
                if(a[i]<a[i+1]){
                    a[i] = a[i+1];
                    boxes[i] = boxes[i+1];
                    a[i+1] = temp;
                    boxes[i+1] = Temp;
                }
            }
            j--;
        }
        BoxSortingDemo.updateDisplay();
        for(int i =0; i <boxes.length;i++){
            a[i]=boxes[i].getNum()/10%10;}
        j = boxes.length-1;
        while(j!=0){
            for(int i = 0; i<boxes.length-1;i++){
                ColoredBox Temp = boxes[i];
                int temp = a[i];
                if(a[i]<a[i+1]){
                    a[i] = a[i+1];
                    boxes[i] = boxes[i+1];
                    a[i+1] = temp;
                    boxes[i+1] = Temp;
                }
            }
            j--;
        }
        BoxSortingDemo.updateDisplay();
        for(int i =0; i <boxes.length;i++){
            a[i]=boxes[i].getNum()/100%10;}
        j = boxes.length-1;
        while(j!=0){
            for(int i = 0; i<boxes.length-1;i++){
                ColoredBox Temp = boxes[i];
                int temp = a[i];
                if(a[i]<a[i+1]){
                    a[i] = a[i+1];
                    boxes[i] = boxes[i+1];
                    a[i+1] = temp;
                    boxes[i+1] = Temp;
                }
            }
            j--;
        }
        BoxSortingDemo.updateDisplay();


    }
}