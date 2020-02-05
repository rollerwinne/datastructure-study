package cn.edu.bupt.p050_p076_sort;

import java.util.Random;

import static cn.edu.bupt.p050_p076_sort.Sort.*;

public class SortTimeCompare {
    public static void main(String[] args) {
        int length = 8000000;
        int[] arr = new int[length];
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(Integer.MAX_VALUE);
        }

        long start = System.currentTimeMillis();
        // bubbleSort(arr);
        // selectSort(arr);
        // insertSort(arr);
        // shellSort(arr);
        // quickSort(arr);
        // mergeSort(arr);
        // radixSort(arr);//注意不能为负数
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }
}
