package cn.edu.bupt.p10_p15_queue;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 小测一下util中的Queue
 */
public class QueueDemo {
    public static void main(String[] args) {
        Queue<Integer> queue = new ArrayBlockingQueue<>(3);
        queue.add(1);
        queue.add(2);
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());

        Queue<Integer> queue1=new LinkedBlockingQueue<>();
        queue1.add(3);
        queue1.add(4);
        queue1.add(5);
        System.out.println(queue1.poll());
        System.out.println(queue1.poll());
        System.out.println(queue1.poll());
        System.out.println(queue1.poll());
    }
}
