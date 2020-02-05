package cn.edu.bupt.p050_p076_sort;

import java.util.Arrays;

/**
 * 归并排序:分治思想
 */
public class MergeSort {
    public static void main(String[] args) {
        // int[] arr1 = {1, 3, 6, 8, 9, 23};
        // int[] arr2 = {1, 2, 6, 7, 8};
        // int[] arr = mergeSortedArr(arr1, arr2);
        // System.out.println(Arrays.toString(arr));
        int[] arr = {3, 1, 4, 2, 9, -3, 0};
        System.out.println(Arrays.toString(arr));
        mergeSort(arr, 0, arr.length - 1, new int[arr.length]);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 归并排序(有temp传入参数)
     *
     * @param arr
     * @param start
     * @param end
     */
    public static void mergeSort(int[] arr, int start, int end, int[] temp) {
        if (start >= end)
            return;
        int mid = (start + end) / 2;
        mergeSort(arr, start, mid, temp);
        mergeSort(arr, mid + 1, end, temp);
        merge(arr, start, mid, end, temp);
    }

    private static void merge(int[] arr, int left, int mid, int right, int[] temp) {
        int i = left, j = mid + 1, index = left;
        while (i <= mid && j <= right) {
            if (arr[i] > arr[j]) {
                temp[index++] = arr[j++];
            } else {
                temp[index++] = arr[i++];
            }
        }
        while (i <= mid)
            temp[index++] = arr[i++];
        while (j <= mid)
            temp[index++] = arr[j++];
        //System.arraycopy(temp,left,arr,left,right-left+1);//可用该句替换下面的语句
        for (int k = left; k <= right; k++) {
            arr[k] = temp[k];
        }
    }

    /**
     * 归并排序(temp在内部创建)
     * 经测试，temp会极大增加时间空间开销
     *
     * @param arr
     * @param start
     * @param end
     */
    public static void mergeSort(int[] arr, int start, int end) {
        if (start >= end)
            return;
        int mid = (start + end) / 2;
        mergeSort(arr, start, mid);
        mergeSort(arr, mid + 1, end);
        merge(arr, start, mid, end);
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        int i = left, j = mid + 1, index = left;
        int[] temp = new int[arr.length];
        while (i <= mid && j <= right) {
            if (arr[i] > arr[j]) {
                temp[index++] = arr[j++];
            } else {
                temp[index++] = arr[i++];
            }
        }
        while (i <= mid)
            temp[index++] = arr[i++];
        while (j <= mid)
            temp[index++] = arr[j++];
        //System.arraycopy(temp,left,arr,left,right-left+1);//可用该句替换下面的语句
        for (int k = left; k <= right; k++) {
            arr[k] = temp[k];
        }
    }

    /**
     * 韩老师的归并排序
     * temp在方法内定义也可，不过韩老师这样写省去每次都创建的时间与空间开销
     *
     * @param arr
     * @param left
     * @param right
     * @param temp
     */
    public static void mergeSortHan(int[] arr, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + right) / 2; //中间索引
            mergeSortHan(arr, left, mid, temp);
            mergeSortHan(arr, mid + 1, right, temp);
            mergeHan(arr, left, mid, right, temp);
        }
    }

    private static void mergeHan(int[] arr, int left, int mid, int right, int[] temp) {
        int i = left;
        int j = mid + 1;
        int t = 0;
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[t++] = arr[i++];
            } else {
                temp[t++] = arr[j++];
            }
        }
        while (i <= mid) {
            temp[t++] = arr[i++];
        }
        while (j <= right) {
            temp[t++] = arr[j++];
        }
        t = 0;
        int tempLeft = left;
        while (tempLeft <= right) {
            arr[tempLeft] = temp[t];
            t += 1;
            tempLeft += 1;
        }

    }

    /**
     * 我尝试的归并排序(分而治之的思想)
     * 不太好：用返回值解决递归调用
     *
     * @param arr
     */
    public static int[] mergeSortTry(int[] arr) {
        int n = arr.length;
        if (n <= 1)
            return arr;
        int[] arr1 = new int[n / 2], arr2 = new int[n - n / 2];
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = arr[i];
        }
        for (int i = 0; i < arr2.length; i++) {
            arr2[i] = arr[i + arr1.length];
        }
        arr1 = mergeSortTry(arr1);
        arr2 = mergeSortTry(arr2);
        return mergeSortedArr(arr1, arr2);
    }

    /**
     * 合并两个有序子序列
     *
     * @param arr1
     * @param arr2
     * @return
     */
    private static int[] mergeSortedArr(int[] arr1, int[] arr2) {
        int m = arr1.length, n = arr2.length;
        if (m == 0)
            return arr2;
        if (n == 0)
            return arr1;
        int[] arr = new int[m + n];
        int i = 0, j = 0, index = 0;
        while (i < m && j < n) {
            if (arr1[i] > arr2[j]) {
                arr[index++] = arr2[j++];
            } else {
                arr[index++] = arr1[i++];
            }
        }
        if (i == m) {
            while (j < n) {
                arr[index++] = arr2[j++];
            }
        }
        if (j == n) {
            while (i < m) {
                arr[index++] = arr1[i++];
            }
        }
        return arr;
    }

    /**
     * 带泛型的归并排序
     *
     * @param arr
     * @param start
     * @param end
     */
    public static <T extends Number> void mergeSort(T[] arr, int start, int end, T[] temp) {
        if (start >= end)
            return;
        int mid = (start + end) / 2;
        mergeSort(arr, start, mid, temp);
        mergeSort(arr, mid + 1, end, temp);
        merge(arr, start, mid, end, temp);
    }

    private static <T extends Number> void merge(T[] arr, int left, int mid, int right, T[] temp) {
        int i = left, j = mid + 1, index = left;
        //T[] temp = (T[]) new Number[arr.length];
        while (i <= mid && j <= right) {
            if (arr[i].longValue() > arr[j].longValue()) {
                temp[index++] = arr[j++];
            } else {
                temp[index++] = arr[i++];
            }
        }
        while (i <= mid)
            temp[index++] = arr[i++];
        while (j <= mid)
            temp[index++] = arr[j++];
        //System.arraycopy(temp,left,arr,left,right-left+1);//可用该句替换下面的语句
        for (int k = left; k <= right; k++) {
            arr[k] = temp[k];
        }
    }
}
