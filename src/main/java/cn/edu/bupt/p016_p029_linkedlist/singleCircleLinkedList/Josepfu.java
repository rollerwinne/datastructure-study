package cn.edu.bupt.p016_p029_linkedlist.singleCircleLinkedList;

public class Josepfu {
    public static void main(String[] args) {
        count(10, 20, 125);
    }

    public static void count(int startNo, int countNo, int nums) {
        if (startNo < 1 || startNo > nums) {
            System.out.println("输入有误");
            return;
        }
        SingleCircleLinkedList list = new SingleCircleLinkedList();
        for (int i = 1; i <= nums; i++) {
            list.add(new ListNode(i));
        }
        // list.list();
        ListNode first = list.getFirst();
        for (int i = 1; i < startNo; i++) {
            first = first.next;
        }
        // SingleCircleLinkedList.list(first);
        // 注：first移动完再定位helper，比韩老师写的要简单
        ListNode helper = first;
        while (helper.next != first)
            helper = helper.next;
        while (first != helper) {
            for (int i = 1; i < countNo; i++) {
                first = first.next;
                helper = helper.next;
            }
            System.out.println(first);
            first = first.next;
            helper.next = first;
        }
        System.out.println("剩下：" + first);
    }
}
