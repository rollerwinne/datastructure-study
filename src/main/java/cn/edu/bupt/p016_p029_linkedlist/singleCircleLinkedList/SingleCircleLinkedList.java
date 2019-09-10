package cn.edu.bupt.p016_p029_linkedlist.singleCircleLinkedList;

public class SingleCircleLinkedList {
    private ListNode first;

    public ListNode getFirst() {
        return first;
    }

    public static void list(ListNode first) {
        if (first == null) {
            System.out.println("链表为空");
            return;
        }
        ListNode temp = first;
        // while (temp.next != first) {
        //     System.out.println(temp);
        //     temp = temp.next;
        // }
        // System.out.println(temp);
        while (true) {
            System.out.println(temp);
            if (temp.next == first) break;
            temp = temp.next;
        }
        System.out.println("-----");
    }

    public void list() {
        list(this.first);
    }

    public void add(ListNode listNode) {
        if (first == null) {
            listNode.next = listNode;
            first = listNode;
            return;
        }
        ListNode temp = first;
        while (temp.next != first)
            temp = temp.next;
        listNode.next = first;
        temp.next = listNode;
    }
}
