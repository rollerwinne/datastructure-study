package cn.edu.bupt.p30_p42_stack;

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
