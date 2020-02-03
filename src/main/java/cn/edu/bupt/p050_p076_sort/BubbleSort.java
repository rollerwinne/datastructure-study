package cn.edu.bupt.p050_p076_sort;

import java.util.Arrays;

/**
 * 冒泡排序：每次比较的是相邻的值
 */
public class BubbleSort {
    public static void main(String[] args) {
        Number[] arr = {3d, 1L, 4f, 2, 9d, -3, 0};
        //int[] arr={3,1,4,2,9,-3,0};
        System.out.println(Arrays.toString(arr));
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 冒泡排序
     *
     * @param arr
     */
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    /**
     * 带泛型的冒泡排序
     *
     * @param arr
     * @param <T>
     */
    public static <T extends Number> void bubbleSort2(T[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j].longValue() > arr[j + 1].longValue()) {
                    swap(arr, j, j + 1);
                }
            }
            System.out.println(Arrays.toString(arr));
        }
    }

    /**
     * 优化后的冒泡排序
     *
     * @param arr
     * @param <T>
     */
    public static <T extends Number> void bubbleSort(T[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            boolean flag = true;
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j].longValue() > arr[j + 1].longValue()) {
                    flag = false;
                    swap(arr, j, j + 1);
                }
            }
            System.out.println(Arrays.toString(arr));
            if (flag) {
                break;
            }
        }
    }

    public static <T> void swap(T[] arr, int i, int j) {
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
