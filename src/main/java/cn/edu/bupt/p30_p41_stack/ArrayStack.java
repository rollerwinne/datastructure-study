package cn.edu.bupt.p30_p41_stack;

/**
 * 区别于jdk中的Stack,这里是自定义栈,数组实现
 * 加上泛型吧
 */
public class ArrayStack<T> implements Stack<T> {
    private int maxSize;
    private T[] arr;
    private int top;

    public ArrayStack() {
        this(5);
    }

    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        // arr=new T[maxSize];// 错误的写法 泛型不可用new数组
        this.arr = (T[]) new Object[maxSize];
        this.top = -1;
    }

    @Override
    public boolean isFull() {
        return top == maxSize - 1;
    }

    @Override
    public boolean isEmpty() {
        return top == -1;
    }

    @Override
    public void push(T t) {
        if (isFull()) {
            System.out.println("error:栈满");
            return;
        }
        top++;
        arr[top] = t;
    }

    @Override
    public T pop() {
        if (isEmpty()) {
            System.out.println("error:栈空");
            return null;
        }
        return arr[top--];
    }

    @Override
    public T peek() {
        if (isEmpty()) {
            System.out.println("error:栈空");
            return null;
        }
        return arr[top];
    }

    //从栈底开始输出
    public void print() {
        if (isEmpty()) {
            System.out.println("error:栈空");
            return;
        }
        for (int i = 0; i <= top; i++) {
            System.out.println(arr[i]);
        }
    }

    @Override
    public void list() {
        if (isEmpty()) {
            System.out.println("error:栈空");
            return;
        }
        for (int i = top; i >= 0; i--) {
            System.out.println(arr[i]);
        }
    }

    @Override
    public String toString() {
        int temp = top;
        String str = "";
        while (temp != -1) {
            str += (arr[temp].toString()+",");
            temp--;
        }
        return str;
    }
}

