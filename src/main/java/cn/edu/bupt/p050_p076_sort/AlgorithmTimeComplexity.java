package cn.edu.bupt.p050_p076_sort;

public class AlgorithmTimeComplexity {
    public static int n = 100;

    public static void main(String[] args) {
        long start, end;

        start = System.currentTimeMillis();
        constantOrder();
        end = System.currentTimeMillis();
        System.out.println(end - start);

        start = System.currentTimeMillis();
        logarithmicOrder();
        end = System.currentTimeMillis();
        System.out.println(end - start);

        start = System.currentTimeMillis();
        linearOrder();
        end = System.currentTimeMillis();
        System.out.println(end - start);

        start = System.currentTimeMillis();
        linearLogrithmicOrder();
        end = System.currentTimeMillis();
        System.out.println(end - start);

        start = System.currentTimeMillis();
        squareOrder();
        end = System.currentTimeMillis();
        System.out.println(end - start);

        start = System.currentTimeMillis();
        cubicOrder();
        end = System.currentTimeMillis();
        System.out.println(end - start);

        start = System.currentTimeMillis();
        kthOrder();
        end = System.currentTimeMillis();
        System.out.println(end - start);
    }

    //常数阶
    public static void constantOrder() {
        int i = 1024, j = 3;
        int m = i + j;
    }

    //对数阶
    public static void logarithmicOrder() {
        int i = 2;
        while (i < n) {
            i *= 2;
        }
    }

    //线性阶
    public static void linearOrder() {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += i;
        }
    }

    //线性对数阶
    public static void linearLogrithmicOrder() {
        for (int m = 1; m < n; m++) {
            int i = 1;
            while (i < m) {
                i *= 2;
            }
        }
    }

    //平方阶
    public static void squareOrder() {
        long sum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sum += (i + j);
            }
        }
    }

    //立方阶
    public static void cubicOrder() {
        long sum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    sum += (i + j - k);
                }
            }
        }
    }

    //k次方阶
    public static void kthOrder() {
        long sum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    for (int l = 0; l < n; l++) {
                        for (int m = 0; m < n; m++) {
                            sum += (i + j - k + l - m);
                        }
                    }
                }
            }
        }
    }
}
