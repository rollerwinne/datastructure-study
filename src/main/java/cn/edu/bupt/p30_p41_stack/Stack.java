package cn.edu.bupt.p30_p41_stack;

public interface Stack<T> {
    boolean isEmpty();
    boolean isFull();
    void push(T t);
    T pop();
    T peek();
    void list();
}
