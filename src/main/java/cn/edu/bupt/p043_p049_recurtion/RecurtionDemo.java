package cn.edu.bupt.p043_p049_recurtion;

public class RecurtionDemo {
    public static void main(String[] args) {
        // printN(10);
        // printM(10);
        System.out.println(factorial(3));
    }

    private static void printN(int n) {
        if (n > 1)
            printN(n - 1);
        System.out.println("n=" + n);
    }

    private static void printM(int m) {
        if (m == 0)
            return;
        printM(m - 1);
        System.out.println("m=" + m);
    }

    private static int factorial(int n) {
        if (n == 1)
            return 1;
        return n * factorial(n - 1);
    }
}
