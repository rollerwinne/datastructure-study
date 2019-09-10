package cn.edu.bupt.p030_p042_stack;

/**
 * 不是JDK中的Stack
 */
public interface Stack<T> {
    boolean isEmpty();

    boolean isFull();

    void push(T t);

    T pop();

    T peek();

    void list();
}
