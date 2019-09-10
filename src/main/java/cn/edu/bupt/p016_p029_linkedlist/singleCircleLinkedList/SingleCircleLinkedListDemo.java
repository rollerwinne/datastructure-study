package cn.edu.bupt.p016_p029_linkedlist.singleCircleLinkedList;

public class SingleCircleLinkedListDemo {
    public static void main(String[] args) {
        testList();
    }

    public static void testList() {
        SingleCircleLinkedList list = new SingleCircleLinkedList();
        for (int i = 1; i <=5 ; i++) {
            ListNode listNode =new ListNode(i);
            list.add(listNode);
        }
        list.list();
    }
}
