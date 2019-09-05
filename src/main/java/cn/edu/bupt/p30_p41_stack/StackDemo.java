package cn.edu.bupt.p30_p41_stack;

import java.util.Scanner;

public class StackDemo {
    public static void main(String[] args) {
        // ArrayStack<Integer> stack = new ArrayStack<>(4);
        LinkedStack<Integer> stack = new LinkedStack<>();
        Scanner sc = new Scanner(System.in);
        String key = "";
        boolean loop = true;
        while (loop) {
            System.out.println("show: 表示显示栈");
            System.out.println("exit: 退出程序");
            System.out.println("push: 表示添加数据到栈(入栈)");
            System.out.println("pop: 表示从栈取出数据(出栈)");
            System.out.println("请输入你的选择");
            key = sc.next();
            switch (key) {
                case "show":
                    stack.list();
                    break;
                case "exit":
                    loop = false;
                    sc.close();
                    break;
                case "push":
                    System.out.print("请输入一个数字");
                    int num = sc.nextInt();
                    stack.push(num);
                    break;
                case "pop":
                    System.out.println(stack.pop() + "弹出");
                    break;
                default:
                    System.out.println("输入有误");
                    break;
            }
        }
    }

    public static void test1() {
        ArrayStack<Integer> stack = new ArrayStack<>();
        stack.push(2);
        stack.push(4);
        stack.push(5);
        stack.push(9);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        stack.push(10);
        stack.push(28);
        stack.push(12);
        stack.push(84);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        stack.print();
    }
}
