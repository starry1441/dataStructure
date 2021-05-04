package sort;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description:选择排序
 * User: starry
 * Date: 2021 -05 -03
 * Time: 8:50
 */
public class SelectSort {

    public static void selectSort(int[] array) {
        for(int i = 0; i < array.length; i++) {
            for (int j = i+1; j < array.length; j++) {
                if(array[j] < array[i]) {
                    int tmp = array[j];
                    array[j] = array[i];
                    array[i] = tmp;
                }
            }
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

    public static void selectSortOP(int[] array) {
        int low = 0;
        int high = array.length - 1;
        // [low, high] 表示整个无序区间
        // 无序区间内只有一个数也可以停止排序了
        while (low <= high) {
            int min = low;
            int max = high;
            for (int i = low + 1; i <= max; i++) {
                if (array[i] < array[min]) {
                    min = i;
                }
                if (array[i] > array[max]) {
                    max = i;
                }
            }
            swap(array, min, low);
            if (max == low) {
                max = min;
            }
            swap(array, max, high);
            low++;
            high--;
        }
    }

    private static void swap(int[] array, int i, int j) {
        int t = array[i];
        array[i] = array[j];
        array[j] = t;
    }

    public static void main(String[] args) {
        int[] array = {10,3,2,7,19,78,65,127};
        selectSortOP(array);
        System.out.println(Arrays.toString(array));
    }
}
