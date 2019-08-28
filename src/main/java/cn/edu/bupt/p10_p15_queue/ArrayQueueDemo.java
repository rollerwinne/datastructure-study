package cn.edu.bupt.p10_p15_queue;

import java.io.IOException;
import java.util.Scanner;

public class ArrayQueueDemo {

    public static void main(String[] args) {
        ArrayQueue queue = new ArrayQueue(5);
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        char key = ' ';
        while (loop) {
//            try {
//                Runtime.getRuntime().exec("clear"); //UNIX console
//                //Runtime.getRuntime().exec("cls"); //Windows console
//            } catch (IOException e) { }
            System.out.println("s(show): 显示队列");
            System.out.println("e(exit): 退出程序");
            System.out.println("a(add): 添加数据到队列");
            System.out.println("g(get): 从队列取出数据");
            System.out.println("h(head): 查看队列头的数据");
            key = scanner.next().charAt(0);
            switch (key) {
                case 's':
                    try {
                        queue.showQueue();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e':
                    scanner.close();
                    loop=false;
                    break;
                case 'a':
                    try {
                        System.out.print("输入加入队列的数据：");
                        int value=scanner.nextInt();
                        queue.addQueue(value);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'g':
                    try {
                        int res = queue.getQueue();
                        System.out.println("从队列中取出：" + res);
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    try {
                        int res = queue.headQueue();
                        System.out.println("查看队列头数据：" + res);
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                default:
                    break;
            }
        }
        System.out.println("Program exit.");
    }
}
