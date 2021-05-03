package sort;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: starry
 * Date: 2021 -05 -03
 * Time: 11:31
 */
public class QuickSort {

    public static void quickSort(int[] array) {
        quick(array,0,array.length-1);
    }

    public static void quick(int[] array, int low, int high) {
        if(low >= high) return;

        int index = pivot(array,low,high);
        quick(array,low,index-1);
        quick(array,index+1,high);
    }

    public static int pivot(int[] array, int left, int right) {
        int piv = array[left];
        while (left < right) {
            while (left < right && array[right] >= piv) {
                right--;
            }
            array[left] = array[right];

            while (left < right && array[left] <= piv) {
                left++;
            }
            array[right] = array[left];
        }
        array[left] = piv;
        return left;
    }

    public static void main(String[] args) {
        int[] array = {27,15,19,18,28,34,65,49,25,37};
        quickSort(array);
        System.out.println(Arrays.toString(array));
    }

}
