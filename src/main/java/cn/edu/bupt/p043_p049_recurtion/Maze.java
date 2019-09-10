package cn.edu.bupt.p043_p049_recurtion;

/**
 * 最短路径的练习就不做了,24种方向排列,意义不大
 */
public class Maze {
    private static int targetX;
    private static int targetY;

    public static void main(String[] args) {
        int[][] map = getMaze(12, 12);
        printMap(map);
        findWay(map, 1, 1);
        System.out.println("-----");
        printMap(map);
    }

    public static boolean findWay(int[][] map, int i, int j) {
        if (map[targetX][targetY] == 2)
            return true;
        if (map[i][j] == 0) {
            map[i][j] = 2;
            if (findWay(map, i + 1, j))
                return true;
            else if (findWay(map, i, j + 1))
                return true;
            else if (findWay(map, i - 1, j))
                return true;
            else if (findWay(map, i, j - 1))
                return true;
            else {
                map[i][j] = 3;
                return false;
            }
        } else
            return false;
    }

    public static int[][] getMaze(int sizeX, int sizeY) {
        targetX = sizeX - 2;
        targetY = sizeY - 2;
        int[][] map = new int[sizeX][sizeY];
        for (int i = 0; i < sizeX; i++) {
            for (int j = 0; j < sizeY; j++) {
                if (i == 0 || j == 0 || i == sizeX - 1 || j == sizeY - 1) {
                    map[i][j] = 1;
                }
            }
        }
        int wall = sizeX * sizeY / 8;
        for (int i = 0; i < wall; i++) {
            int x = (int) (Math.random() * (sizeX - 2) + 1);
            int y = (int) (Math.random() * (sizeY - 2) + 1);
            map[x][y] = 1;
        }
        map[1][1] = 0;
        map[sizeX - 2][sizeY - 2] = 0;
        return map;
    }

    public static void printMap(int[][] map) {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }
}