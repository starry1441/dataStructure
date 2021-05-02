package sort;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description:希尔排序
 * User: starry
 * Date: 2021 -05 -02
 * Time: 22:33
 */
public class ShellSort {

    public static void shellSort(int[] array) {
        int[] drr = {5,3,1};

        for (int i = 0; i < drr.length; i++) {
            shell(array,drr[i]);
        }
    }

    public static void shell(int[] array, int gap) {
        for (int i = gap; i < array.length; i++) {
            int tmp = array[i];
            int j;
            for (j = i-gap; j >= 0; j -= gap) {
                if(array[j] > tmp) {
                    array[j+gap] = array[j];
                }else {
                    break;
                }
            }
            array[j+gap] = tmp;
        }
    }

    public static void main(String[] args) {
        int[] array = {12,5,9,16,6,8,27,58,80,0,7,4,33,55,77};
        shellSort(array);
        System.out.println(Arrays.toString(array));
    }

}
