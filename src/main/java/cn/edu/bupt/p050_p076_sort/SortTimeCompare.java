package cn.edu.bupt.p050_p076_sort;

import java.util.Arrays;
import java.util.Random;

public class SortTimeCompare {
    public static void main(String[] args) {
        int length = 80000;
        int[] arr = new int[length];
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt();
        }

        long start = System.currentTimeMillis();
        //BubbleSort.bubbleSort(arr);
        //SelectSort.selectSort(arr);
        //InsertSort.insertSort(arr);
        ShellSort.shellSort(arr);
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }
}
