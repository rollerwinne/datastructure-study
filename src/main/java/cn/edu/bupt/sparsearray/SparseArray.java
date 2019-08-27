package cn.edu.bupt.sparsearray;

public class SparseArray {
    private int row, col, value;
    private int[][] sparseArray;

    public SparseArray() {
    }

    public SparseArray(int[][] arr) {
        int sum = 0;
        row=arr.length;
        col=arr[0].length;
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
        return null;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int[][] getSparseArray() {
        return sparseArray;
    }

    public void setSparseArray(int[][] sparseArray) {
        this.sparseArray = sparseArray;
    }
}
