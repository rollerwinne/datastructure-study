package cn.edu.bupt.p090_p111_tree;

import java.util.Random;

public class HeapSort {
    /**
     * 堆排序
     *
     * @param arr
     */
    public static void heapSort(int[] arr) {
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            adjust(arr, i, arr.length);
        }
        int temp;
        for (int i = arr.length - 1; i > 0; i--) {
            temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            adjust(arr, 0, i);
        }
    }

    /**
     * 调整堆 (不必每次都交换)
     *
     * @param arr    待调整的数组
     * @param parent 节点为parent的子树
     * @param length 需要调整的界限
     */
    private static void adjust(int[] arr, int parent, int length) {
        int temp = arr[parent];
        int p = 2 * parent + 1;
        while (p < length) {
            if (p + 1 < length && arr[p] < arr[p + 1]) {
                p++;
            }
            if (temp > arr[p])
                break;
            arr[parent] = arr[p];
            parent = p;
            p = p * 2 + 1;
        }
        arr[parent] = temp;
    }

    /**
     * 堆排序(调用每次均交换的调整方法)
     *
     * @param arr
     */
    private static void heapSort0(int[] arr) {
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            adjust0(arr, i, arr.length);
        }
        int temp;
        for (int i = arr.length - 1; i > 0; i--) {
            temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            adjust0(arr, 0, i);
        }
    }

    /**
     * 调整堆 (每次都交换)
     *
     * @param arr    待调整的数组
     * @param parent 节点为parent的子树
     * @param length 需要调整的界限
     */
    private static void adjust0(int[] arr, int parent, int length) {
        int p = 2 * parent + 1;
        while (p < length) {
            if (p + 1 < length && arr[p] < arr[p + 1]) {
                p++;
            }
            if (arr[parent] > arr[p])
                break;
            int temp = arr[parent];
            arr[parent] = arr[p];
            arr[p] = temp;
            parent = p;
            p = p * 2 + 1;
        }
    }

    public static void main(String[] args) {
        int length = 10000000;
        Random random = new Random();
        int[] arr1 = new int[length];
        int[] arr2 = new int[length];
        int temp;
        for (int i = 0; i < length; i++) {
            temp = random.nextInt();
            arr1[i] = temp;
            arr2[i] = temp;
        }

        long start = System.currentTimeMillis();
        heapSort(arr1);
        long end = System.currentTimeMillis();
        System.out.println(end - start);

        start = System.currentTimeMillis();
        heapSort0(arr2);
        end = System.currentTimeMillis();
        System.out.println(end - start);
    }
}
