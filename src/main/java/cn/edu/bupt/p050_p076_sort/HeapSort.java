package cn.edu.bupt.p050_p076_sort;

import java.util.Arrays;

/**
 * 堆排序:利用二叉树
 */
public class HeapSort {
    public static void main(String[] args) {
        int[] arr = {3, 1, 4, 2, 9, -3, 0};
        System.out.println(Arrays.toString(arr));
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 堆排序
     *
     * @param arr
     */
    public static void heapSort(int[] arr) {
        for (int i = (arr.length - 1) / 2; i >= 0; i--) {
            adjustHeap(arr, i, arr.length);
        }
        for (int i = arr.length - 1; i > 0; i--) {
            int temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;
            adjustHeap(arr, 0, i);
        }
    }

    //调整堆
    private static void adjustHeap(int[] arr, int parent, int length) {
        int temp = arr[parent];
        int lChild = 2 * parent + 1;
        while (lChild < length) {
            int rChild = lChild + 1;
            if (rChild < length && arr[lChild] < arr[rChild]) {
                lChild++;
            }
            if (temp >= arr[lChild]) {
                break;
            }
            arr[parent] = arr[lChild];
            parent = lChild;
            lChild = 2 * lChild + 1;
        }
        arr[parent] = temp;
    }
}
