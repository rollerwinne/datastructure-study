package cn.edu.bupt;

import org.junit.Test;

import java.util.Arrays;

public class TestArrary {
    @Test
    public void fun(){
        int[][] a=new int[2][3];
        a[1][1]=1;
        int[][] b=new int[2][3];
        b[1][1]=1;
        System.out.println(Arrays.equals(a,b));
    }

    @Test
    public void fun2(){
        int[] a=new int[2];
        int[] b=new int[2];
        System.out.println(Arrays.equals(a,b));
    }

    @Test
    public void fun3(){
        int[][] a=new int[10][];
        a[9][0]=2;
        System.out.println(a[9][1000]);
    }
}
