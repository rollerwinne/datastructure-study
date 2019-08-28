package cn.edu.bupt.p10_p15_queue;

public class CircleArrayQueue implements Queue {
    private int maxSize;
    private int front;
    private int rear;
    private int[] arr;

    public CircleArrayQueue() {
        this(20);
    }

    public CircleArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        this.arr = new int[maxSize];
        this.front = 0;
        this.rear = 0;
    }

    @Override
    public boolean isFull() {
        return (rear + 1) % maxSize == front;
    }

    @Override
    public boolean isEmpty() {
        return front == rear;
    }

    @Override
    public void addQueue(int n) {
        if (isFull())
            throw new RuntimeException("队列已满");
        arr[rear] = n;
        rear = (rear + 1) % maxSize;
    }

    @Override
    public int getQueue() {
        if (isEmpty())
            throw new RuntimeException("队列空");
        int tmp = arr[front];
        front = (front + 1) % maxSize;
        return tmp;
    }

    @Override
    public void showQueue() {
        if (isEmpty())
            throw new RuntimeException("队列空");
//        for (int i = 0; i < arr.length; i++) {
//            System.out.printf("arr[%d]=%d\n", i, arr[i]);
//        }
        for (int i = front; i < front + size(); i++) {
            System.out.printf("arr[%d]=%d\n", i % maxSize, arr[i % maxSize]);
        }

    }

    private int size() {
        return (rear + maxSize - front) % maxSize;
    }

    @Override
    public int headQueue() {
        if (isEmpty())
            throw new RuntimeException("队列空");
        return arr[front];
    }
}
