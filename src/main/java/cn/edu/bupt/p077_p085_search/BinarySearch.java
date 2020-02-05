package cn.edu.bupt.p077_p085_search;

import java.util.ArrayList;
import java.util.List;

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 8, 15, 15, 15, 15, 15, 15, 15, 15, 15, 23, 45, 56, 67, 100};
        //int[] arr = {15};
        //int index = binarySearch(arr, 0, arr.length - 1, 15);
        //int index = binarySearch(arr, 15);
        List<Integer> list = binarySearchPro(arr, 0, arr.length - 1, 15);
        //System.out.println(index);
        System.out.println(list);
    }

    /**
     * 递归法二分查找
     *
     * @param arr
     * @param value
     * @return
     */
    public static int binarySearch(int[] arr, int left, int right, int value) {
        if (left > right || value < arr[left] || value > arr[right])
            return -1;
        int mid = (left + right) / 2;
        if (arr[mid] > value)
            return binarySearch(arr, left, mid - 1, value);
        if (arr[mid] < value)
            return binarySearch(arr, mid + 1, right, value);
        return mid;
    }

    /**
     * 迭代法二分查找
     *
     * @param arr
     * @param value
     * @return
     */
    public static int binarySearch(int[] arr, int value) {
        int left = 0, right = arr.length - 1, mid;
        while (left <= right) {
            mid = (left + right) / 2;
            if (arr[mid] == value)
                return mid;
            if (arr[mid] > value)
                right = mid - 1;
            else
                left = mid + 1;
        }
        return -1;
    }

    /**
     * 二分查找所有的下标
     *
     * @param arr
     * @param left
     * @param right
     * @param value
     * @return
     */
    public static List<Integer> binarySearchPro(int[] arr, int left, int right, int value) {
        if (left > right)
            return null;
        int mid = (left + right) / 2;
        if (arr[mid] > value)
            return binarySearchPro(arr, left, mid - 1, value);
        if (arr[mid] < value)
            return binarySearchPro(arr, mid + 1, right, value);
        List<Integer> list = new ArrayList<>();
        for (int i = mid - 1; i >= 0 && arr[i] == value; i--) {
            list.add(i);
        }
        list.add(mid);
        for (int i = mid + 1; i < arr.length && arr[i] == value; i++) {
            list.add(i);
        }
        return list;
    }
}
