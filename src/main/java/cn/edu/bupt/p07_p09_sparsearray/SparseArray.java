package cn.edu.bupt.p07_p09_sparsearray;

import java.io.Serializable;

public class SparseArray implements Serializable {
    private int[][] sparseArray;

    public SparseArray(int[][] arr) {
        int sum = 0;
        int row=arr.length;
        int col=arr[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (arr[i][j] != 0) {
                    sum++;
                }
            }
        }
        sparseArray=new int[sum+1][3];
        sparseArray[0][0]=row;
        sparseArray[0][1]=col;
        sparseArray[0][2]=sum;

        int count=0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (arr[i][j] != 0) {
                    count++;
                    sparseArray[count][0]=i;
                    sparseArray[count][1]=j;
                    sparseArray[count][2]=arr[i][j];
                }
            }
        }
    }

    public int[][] convertToCommonArrary() {
        return convertToCommonArrary(this.sparseArray);
    }

    public static int[][] convertToCommonArrary(int[][] sparseArray) {
        int arr[][]=new int[sparseArray[0][0]][sparseArray[0][1]];
        for (int i=1;i<sparseArray.length;i++){
            arr[sparseArray[i][0]][sparseArray[i][1]]=sparseArray[i][2];
        }
        return arr;
    }

    public int[][] getSparseArray() {
        return sparseArray;
    }

    public void setSparseArray(int[][] sparseArray) {
        this.sparseArray = sparseArray;
    }
}
