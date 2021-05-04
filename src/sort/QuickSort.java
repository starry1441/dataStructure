package sort;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description:快速排序 --- 递归
 * User: starry
 * Date: 2021 -05 -03
 * Time: 11:31
 */
public class QuickSort {

    public static void quickSort(int[] array) {
        quick(array,0,array.length-1);
    }

    //优化的插入排序
    public static void insertSortBount(int[] array,int low,int high) {
        for (int i = low+1; i <= high; i++) {
            int tmp = array[i];
            int j;
            for (j = i-1; j >= low; j--) {
                if(array[j] > tmp) {
                    array[j+1] = array[j];
                }else {
                    break;
                }
            }
            array[j+1] = tmp;
        }
    }

    public static void quick(int[] array, int low, int high) {
        if(low >= high) return;

        //优化，当范围越来越小，则越来越趋于有序，越有序，插入排序的时间复杂度越低
        if(high-low+1 <= 50) {
            insertSortBount(array,low,high);
            return;//这里说明这个区间法内有序了，直接结束
        }

        int index = pivot(array,low,high);
        quick(array,low,index-1);
        quick(array,index+1,high);
    }

    //相遇点
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
