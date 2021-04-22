package Work4_22;

import java.util.Arrays;
import java.util.Scanner;


/**
 * Created with IntelliJ IDEA.
 * Description:从小到大排序---建立大根堆
 * User: starry
 * Date: 2021 -04 -22
 * Time: 11:39
 */
public class Work3 {

    public void adjustDown(int[] array,int parent, int len) {
        int child = parent*2+1;
        while (child < len) {
            if(child+1 < len && array[child] < array[child+1]) {
                child = child+1;
            }
            if(array[parent] < array[child]) {
                int tmp = array[parent];
                array[parent] = array[child];
                array[child] = tmp;
                parent = child;
                child = 2*child+1;
            }else {
                break;
            }
        }
    }

    public void createBigHeap(int[] array) {
        int len = array.length;
        int parent = (len-2)/2;
        for(int i = 0; i < len; i++) {
            adjustDown(array,parent,len);
        }
    }

    public void heapSort(int[] array) {
        int end = array.length-1;
        while (end > 0) {
            int top = array[0];
            array[0] = array[end];
            array[end] = top;
            adjustDown(array,0,end);
            end--;
        }
    }

    public static void main(String[] args) {
        int[] array = {27,15,19,18,28,34,65,49,25,37};
        Work3 a = new Work3();
        a.createBigHeap(array);
        a.heapSort(array);
        System.out.println(Arrays.toString(array));
    }

}

