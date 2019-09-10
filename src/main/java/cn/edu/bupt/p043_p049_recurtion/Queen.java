package cn.edu.bupt.p043_p049_recurtion;

import java.util.Arrays;

public class Queen {
    private static int size = 8;
    private static int ways = 0;
    private static int[] chess = new int[size];

    public static void main(String[] args) {
        check(0);
        System.out.println(ways);
    }

    private static void check(int n) {//代表放置第n行
        if (n == size) {
            ways++;
            printChess();
            return;
        }
        for (int i = 0; i < size; i++) {
            chess[n] = i;
            if (judge(n))
                check(n + 1);
        }

    }

    private static boolean judge(int n) {
        for (int i = 0; i < n; i++) {
            if (chess[i] == chess[n] || Math.abs(i - n) == Math.abs(chess[i] - chess[n]))
                return false;
        }
        return true;
    }

    private static void printChess() {
        System.out.println(Arrays.toString(chess));
    }
}
