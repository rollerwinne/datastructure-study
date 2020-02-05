package cn.edu.bupt.p077_p085_search;

/**
 * 插值查找算法（线性插值）
 */
public class InsertValueSearch {
    public static void main(String[] args) {
        int length = 20;
        int[] arr = new int[length];
        for (int i = 0; i < length; i++) {
            arr[i] = i;
        }
        System.out.println(insertValueSearch(arr,2));
        System.out.println(insertValueSearch(arr,0,arr.length-1,2));
    }

    /**
     * 插值查找（递归法）
     *
     * @param arr
     * @param value
     * @return
     */
    public static int insertValueSearch(int[] arr, int left, int right, int value) {
        int low = arr[left], high = arr[right];
        if (left > right || value < arr[left] || value > arr[right])
            return -1;
        int mid = left + (value - low) / (high - low) * (right - left);
        if (arr[mid] > value)
            return insertValueSearch(arr, left, mid - 1, value);
        if (arr[mid] < value)
            return insertValueSearch(arr, mid + 1, right, value);
        return mid;
    }

    /**
     * 插值查找（迭代法）
     *
     * @param arr
     * @param value
     * @return
     */
    public static int insertValueSearch(int[] arr, int value) {
        int left = 0, right = arr.length - 1, mid;
        int low = arr[left], high = arr[right];
        while (left <= right) {
            mid = left + (value - low) / (high - low) * (right - left);
            if (arr[mid] == value)
                return mid;
            if (arr[mid] > value)
                right = mid - 1;
            else
                left = mid + 1;
        }
        return -1;
    }
}
