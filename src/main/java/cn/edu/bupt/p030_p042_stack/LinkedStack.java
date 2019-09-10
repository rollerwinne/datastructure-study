package cn.edu.bupt.p030_p042_stack;

/**
 * 练习:链表实现栈
 */
public class LinkedStack<T> implements Stack<T> {
    private ListNode<T> head;

    public LinkedStack() {
        head = new ListNode<>();
    }

    @Override
    public boolean isEmpty() {
        return head.next == null;
    }

    @Override
    public boolean isFull() {
        return false;//链表可以无限加
    }

    @Override
    public void push(T t) {
        ListNode<T> listNode = new ListNode<>(t);
        listNode.next = head.next;
        head.next = listNode;
    }

    @Override
    public T pop() {
        if (head.next == null) {
            System.out.println("error:栈空");
            return null;
        }
        ListNode<T> temp = head.next;
        head.next = head.next.next;
        return temp.value;
    }

    @Override
    public T peek() {
        if (head.next == null) {
            System.out.println("error:栈空");
            return null;
        }
        return head.next.value;
    }

    @Override
    public void list() {
        ListNode<T> temp = head.next;
        while (temp != null) {
            System.out.println(temp);
            temp = temp.next;
        }
    }
}

class ListNode<T> {
    public T value;
    public ListNode<T> next;

    public ListNode() {
    }

    public ListNode(T t) {
        this.value = t;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "value=" + value +
                '}';
    }
}