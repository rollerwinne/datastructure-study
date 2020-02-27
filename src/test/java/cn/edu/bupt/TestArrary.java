package cn.edu.bupt;

import org.junit.Test;

import java.util.Arrays;

public class TestArrary {
    @Test
    public void fun() {
        int[][] a = new int[2][3];
        a[1][1] = 1;
        int[][] b = new int[2][3];
        b[1][1] = 1;
        System.out.println(Arrays.equals(a, b));
    }

    @Test
    public void fun2() {
        int[] a = new int[2];
        int[] b = new int[2];
        System.out.println(Arrays.equals(a, b));
    }

    @Test
    public void fun3() {
        int[][] a = new int[10][1000];
        a[9][0] = 2;
        System.out.println(a[9][999]);
    }

    @Test
    public void fun4() {
        Object object = 1;
        System.out.println(object.equals(1));
    }

    @Test
    public void fun5() {
        Byte[][] bytes = new Byte[2][2];
        byte[][] bytes2 = new byte[2][2];
        System.out.println(bytes[1][1]);
        System.out.println(bytes2[1][1]);
        System.out.println(Arrays.deepToString(bytes));
        System.out.println(Arrays.deepToString(bytes2));
    }
}
