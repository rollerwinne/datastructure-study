package cn.edu.bupt.p010_p015_queue;

public class ArrayQueue implements Queue {
    private int maxSize;
    private int front;
    private int rear;
    private int[] arr;

    public ArrayQueue(){
        this(20);
    }

    public ArrayQueue(int maxSize){
        this.maxSize=maxSize;
        this.arr=new int[maxSize];
        this.front=-1;
        this.rear =-1;
    }
    @Override
    public boolean isFull() {
        return rear ==maxSize-1;
    }

    @Override
    public boolean isEmpty() {
        return front == rear;
    }

    @Override
    public void addQueue(int n) {
        if(isFull())
            throw new RuntimeException("队列已满");
        rear++;
        arr[rear]=n;
    }

    @Override
    public int getQueue() {
        if (isEmpty())
            throw new RuntimeException("队列空");
        front++;
        return arr[front];
    }

    @Override
    public void showQueue() {
        if(isEmpty())
            throw new RuntimeException("队列空");
        for (int i = 0; i < arr.length ; i++) {
            System.out.printf("arr[%d]=%d\n",i,arr[i]);
        }

    }

    @Override
    public int headQueue() {
        if (isEmpty())
            throw new RuntimeException("队列空");
        return arr[front+1];
    }
}
