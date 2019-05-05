import java.util.Arrays;

/**
 * YOU MUST DEFINE THIS CLASS
 *
 * This class provides a reverse implementation
 * of the selection sort algorithm.
 *
 * @author _____________
 */
public class SelectionSortBoxSorter implements BoxSorter
{
    public void sortBoxes(ColoredBox[] boxes)
    {
        int j, k, max_index;
        for (j = 0; j <=boxes.length-2; j++) {
            max_index = j;
            for (k = j+1; k <= boxes.length-1; k++)
                if (boxes[k].getNum() > boxes[max_index].getNum())
                    max_index = k;
            ColoredBox temp = boxes[j];
            boxes[j] = boxes[max_index];
            boxes[max_index] = temp;
        }
        BoxSortingDemo.updateDisplay();
    }
}
