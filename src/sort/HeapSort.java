package sort;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description:堆排序
 * User: starry
 * Date: 2021 -05 -03
 * Time: 9:25
 */
public class HeapSort {

    public static void creatBigHeap(int[] array) {
        int len = array.length-1;
        int parent = (len-1)/2;
        for (int i = parent; i >= 0; i--) {
            adjustDown(i,array,len);
        }
    }

    public static void adjustDown(int parent, int[] array,int end) {
        int child = 2*parent+1;
        while (child < end+1) {
            if(child+1 <= end && array[child] < array[child+1]) {
                child = child+1;
            }
            if(array[child] > array[parent]) {
                int tmp = array[child];
                array[child] = array[parent];
                array[parent] = tmp;
                parent = child;
                child = parent*2+1;
            }else {
                break;
            }
        }
    }

    public static void heapSort(int[] array) {
        creatBigHeap(array);
        int end = array.length-1;
        while (end >= 0) {
            int tmp = array[0];
            array[0] = array[end];
            array[end] = tmp;
            end--;
            adjustDown(0,array,end);
        }
    }

    public static void main(String[] args) {
        int[] array = {27,15,19,18,28,34,65,49,25,37};
        heapSort(array);
        System.out.println(Arrays.toString(array));
    }

}
