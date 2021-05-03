package sort;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: starry
 * Date: 2021 -05 -03
 * Time: 10:56
 */
public class BubbleSort {

    public static void bubbleSort(int[] array) {
        for (int i = 0; i < array.length-1; i++) {
            boolean isSort = true;
            for (int j = 0; j < array.length-1-i; j++) {
                if(array[j] > array[j+1]) {
                    int tmp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = tmp;
                    isSort = false;
                }
            }
            if(isSort) break;
        }
    }

    public static void main(String[] args) {
        int[] array = {10,3,2,7,19,78,65,127};
        bubbleSort(array);
        System.out.println(Arrays.toString(array));
    }

}
