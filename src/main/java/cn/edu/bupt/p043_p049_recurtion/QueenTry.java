package cn.edu.bupt.p043_p049_recurtion;

/**
 * 尝试解八皇后问题,以失败告终
 * 想着用二维数组表示棋盘,还是不好做回溯操作
 */
public class QueenTry {
    private static int size = 8;
    private static int ways = 0;

    public static void main(String[] args) {
        findWay(getChess(), 0, 0);
        System.out.println(ways);
    }

    /**
     * 0代表没试过,1代表试了不行,2代表试了可以
     *
     * @param chess
     * @param i
     * @return
     */
    private static void findWay(int[][] chess, int i, int j) {//第i行
        if (isOk(chess, i, j)) {
            if (i == size - 1) {
                ways++;
                return;
            }
            chess[i][j] = 2;
            findWay(chess, ++i, 0);
        } else if (j < size - 1) {
            chess[i][j] = 1;
            findWay(chess, i, j + 1);
        } else {
            return;
        }
    }

    private static boolean isOk(int[][] chess, int i, int j) {
        for (int x = 0; x < i; x++) {
            for (int y = 0; y < size; y++) {
                if (chess[x][y] == 2)
                    if (x == i || y == j || Math.abs(x - i) == Math.abs(y - j)) {
                        return false;
                    }
            }
        }
        return true;
    }

    private static int[][] getChess() {
        return new int[size][size];
    }
}
