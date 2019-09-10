package cn.edu.bupt.p010_p015_queue;

/**
 * java.util包中也有Queue接口，注意区别，这里的Queue是自定义接口
 * 接口的规范是按照韩老师来写的
 */
public interface Queue {
    public boolean isFull();
    public boolean isEmpty();
    public void addQueue(int num);
    public int getQueue();
    public void showQueue();
    public int headQueue();
}
