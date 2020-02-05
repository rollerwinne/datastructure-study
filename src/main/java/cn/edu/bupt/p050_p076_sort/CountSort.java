package cn.edu.bupt.p050_p076_sort;

import java.util.Arrays;

/**
 * 计数排序:用辅助数组计数
 */
public class CountSort {
    public static void main(String[] args) {
        int[] arr = {3, 1, 4, 2, 9, -3, 0};
        System.out.println(Arrays.toString(arr));
        countSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 计数排序,针对整数(可负)
     *
     * @param arr
     */
    public static void countSort(int[] arr) {
        int max = arr[0], min = arr[0];
        for (int value : arr) {
            if (value > max)
                max = value;
            if (value < min)
                min = value;
        }
        int[] temp = new int[max - min + 1];
        for (int value : arr) {
            temp[value - min]++;
        }
        for (int i = 0, idx = 0; i < temp.length; i++) {//对temp遍历
            for (int j = 0; j < temp[i]; j++) {//遍历temp[i]次
                arr[idx++] = i + min;
            }
        }
    }
}
