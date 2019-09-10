package cn.edu.bupt.p043_p049_recurtion;

/**
 * 额外练手:汉诺塔
 */
public class Hanoi {
    public static void main(String[] args) {
        hanoi(3, "a", "b", "c");
    }

    private static void hanoi(int n, String a, String b, String c) {
        if (n == 1)
            move(a, c);
        else {
            hanoi(n - 1, a, c, b);
            move(a, c);
            hanoi(n - 1, b, a, c);
        }
    }

    private static void move(String l1, String l2) {
        System.out.println(l1 + "-->" + l2);
    }
}
