package cn.edu.bupt.p07_p09_sparsearray;

import java.io.File;

/**
 * @author mmc 502358401@qq.com
 * https://github.com/rollerwinne/DataStructure
 *
 * 相比于韩老师的面向过程的写法，这里用的对象重写的稀疏数组类
 * @see com.atguigu.sparsearray.SparseArray
 */
public class SparseArrayDemo {
    public static void main(String[] args) {
        int chessArr[][]=new int[11][11];
        chessArr[1][2]=1;
        chessArr[2][3]=2;
        System.out.println("原始数组：");
        printArray(chessArr);

        System.out.println("原始数组转为稀疏数组：");
        SparseArray sa = new SparseArray(chessArr);
        int[][] sparsearr=sa.getSparseArray();
        printArray(sparsearr);

        System.out.println("稀疏数组转为普通数组");
        printArray(SparseArray.convertToCommonArrary(sparsearr));

        System.out.println("数组的保存（持久化）：");
        File savedFile = SaveUtils.saveArray(sa);
        System.out.println("数组保存为"+savedFile.getPath());

        System.out.println("数组的读取:");
        SparseArray sa2 =SaveUtils.readArray();
        printArray(sa2.getSparseArray());
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
