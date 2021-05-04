package sort;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description:归并排序---递归
 * User: starry
 * Date: 2021 -05 -03
 * Time: 15:24
 */
public class MergeSort {

    public static void merge(int[] array,int low,int mid,int high) {
        int s1 = low;
        int s2 = mid+1;
        int[] tmp = new int[high-low+1];
        int i = 0;
        while (s1 <= mid && s2 <= high) {
            if(array[s1] <= array[s2]) {
                tmp[i++] = array[s1++];
            }else {
                tmp[i++] = array[s2++];
            }
        }
        //可能s1没走完，也可能s2没走完
        while (s1 <= mid) {
            tmp[i++] = array[s1++];
        }
        while (s2 <= high) {
            tmp[i++] = array[s2++];
        }
        for (int j = 0; j < tmp.length; j++) {
            array[j+low] = tmp[j];
        }
    }

    public static void mergeSortInternal(int[] array,int low,int high) {
        if(low >= high) return;
        int mid = (low+high)/2;
        mergeSortInternal(array,low,mid);
        mergeSortInternal(array,mid+1,high);
        //合并
        merge(array,low,mid,high);
    }

    public static void mergeSort(int[] array) {
        int low = 0;
        int high = array.length-1;
        mergeSortInternal(array,low,high);
    }

    public static void main(String[] args) {
//        int[] s1 = {1,2,3,4,5};
//        int[] s2 = new int[s1.length];
//        int i = 0;
//        int j = 0;
//        while (i < s2.length) {
//            s2[i++] = s1[j++];
//        }
//        System.out.println(Arrays.toString(s2));
        int[] array = {27,15,19,18,28,34,65,49,25};
        mergeSort(array);
        System.out.println(Arrays.toString(array));
    }

}
