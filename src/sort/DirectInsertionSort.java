package sort;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description:直接插入排序
 * User: starry
 * Date: 2021 -05 -02
 * Time: 11:07
 */
public class DirectInsertionSort {

    public static void insertSort(int[] array) {
        int tmp = 0;
        for(int i = 1; i < array.length; i++) {
            tmp = array[i];
            int j;
            for (j = i-1; j >= 0; j--) {
                if(array[j] > tmp) {
                    array[j+1] = array[j];
                }else {
                    break;
                }
            }
            array[j+1] = tmp;
        }
    }

    public static void bsInsertSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int v = array[i];
            int left = 0;
            int right = i;
            // [left, right)
            // 需要考虑稳定性
            while (left < right) {
                int m = (left + right) / 2;
                if (v >= array[m]) {
                    left = m + 1;
                } else {
                    right = m;
                }
            }
            // 搬移
            for (int j = i; j > left; j--) {
                array[j] = array[j - 1];
            }
            array[left] = v;
        }
    }

    public static void main(String[] args) {
        int[] array = {10,3,2,7,19,78,65,127};
        System.out.println(Arrays.toString(array));
        insertSort(array);
        System.out.println(Arrays.toString(array));
    }

}
