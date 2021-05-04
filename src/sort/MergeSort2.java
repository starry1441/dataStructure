package sort;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description:归并排序---非递归
 * User: starry
 * Date: 2021 -05 -04
 * Time: 9:39
 */
public class MergeSort2 {

    public static void merge(int[] array,int gap) {
        int s1 = 0;
        int e1 = s1 + gap - 1;
        int s2 = e1 + 1;
        int e2 = s2 + gap - 1 < array.length ? s2 + gap - 1 : array.length - 1;
        int[] tmp = new int[array.length];
        int i = 0;

        while (s2 < array.length) {
             while (s1 <= e1 && s2 <= e2) {
                 if (array[s1] <= array[s2]) {
                     tmp[i++] = array[s1++];
                 }else {
                     tmp[i++] = array[s2++];
                 }
             }
             while (s1 <= e1) {
                 tmp[i++] = array[s1++];
             }
             while (s2 <= e2) {
                 tmp[i++] = array[s2++];
             }
             s1 = e2 + 1;
             e1 = s1 + gap - 1;
             s2 = e1 + 1;
             e2 = s2 + gap - 1 < array.length ? s2 + gap - 1 : array.length - 1;
        }

        while (s1 < array.length) {
            tmp[i++] = array[s1++];
        }

        for (int j = 0; j < tmp.length; j++) {
            array[j] = tmp[j];
        }
    }

    public static void mergeSort(int[] array) {
        for (int i = 1; i < array.length; i*=2) {
            merge(array,i);
        }
    }

    public static void main(String[] args) {
        int[] array = {27,15,19,18,28,34,65,49,25};
        mergeSort(array);
        System.out.println(Arrays.toString(array));
    }

}
