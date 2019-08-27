package cn.edu.bupt.sparsearray;

/**
 * 相比于韩老师的面向过程的写法，这里用的对象重写的稀疏数组类
 * @author mmc
 */
public class SparseArrayDemo {
    public static void main(String[] args) {
        int chessArr[][]=new int[11][11];
        chessArr[1][2]=1;
        chessArr[2][3]=2;
        System.out.println("原始数组：");
        printArray(chessArr);
        System.out.println("稀疏数组：");
        int[][] sparsearr=new SparseArray(chessArr).getSparseArray();
        printArray(sparsearr);
    }

    public static void printArray(int[][] arr) {
        for (int[] row : arr) {
            for (int data : row){
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }
    }
}
