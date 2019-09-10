package cn.edu.bupt.p016_p029_linkedlist.singleLinkedList;

import java.util.Stack;

/**
 * 练习：单链表面试题
 *
 * @author mmc
 */
public class LinkedListUtils {
    /**
     * 1.求单链表中节点的个数
     */
    public static int getlength(HeroNode head) {
        int sum = 0;
        HeroNode temp = head;
        while (temp.next != null) {
            sum++;
            temp = temp.next;
        }
        return sum;
    }

    /**
     * 2.查找单链表中的倒数第k个结点【新浪面试题】
     */
    public static HeroNode findLastIndexNode(HeroNode head, int index) {
        int size = getlength(head);
        HeroNode temp = head;
        if (index < 0 | size - index < 0) {
            return null;
        }
        for (int i = 0; i < size - index; i++) {
            temp = temp.next;
        }
        return temp.next;
    }

    public static HeroNode findLastIndexNode2(HeroNode head, int index) {
        HeroNode temp = head, tail = head;
        for (int i = 0; i < index; i++) {
            if (tail.next != null)
                tail = tail.next;
            else
                return null;
        }
        while (tail.next != null) {
            temp = temp.next;
            tail = tail.next;
        }
        return temp.next;
    }

    /**
     * 3.单链表的反转【腾讯面试题，有点难度】
     */
    //感觉这个写的比韩老师简洁，且少用了一个临时变量
    //区别在遍历的方式
    public static void reverseList(HeroNode head) {
        HeroNode reverseHead = new HeroNode();
        HeroNode temp;
        while (head.next != null) {
            temp = head.next;
            head.next = head.next.next;
            temp.next = reverseHead.next;
            reverseHead.next = temp;
        }
        head.next = reverseHead.next;
    }

    //韩老师的方法
    public static void reverseList2(HeroNode head) {
        if (head.next == null) {
            return;
        }
        HeroNode reverseHead = new HeroNode();
        HeroNode cur = head.next;
        HeroNode curnext;
        while (cur != null) {
            curnext = cur.next;
            cur.next = reverseHead.next;
            reverseHead.next = cur;
            cur = curnext;
        }
        head.next = reverseHead.next;

    }

    /**
     * 4.从尾到头打印单链表【百度，要求方式1:反向遍历。方式2:Stack栈】
     */
    //递归
    public static void printReverseList(HeroNode head) {
        if (head.next == null)
            return;
        HeroNode temp = head.next;
        printReverseList(temp);
        System.out.println(temp.hero);
    }

    //栈
    public static void printReverseList2(HeroNode head) {
        Stack<HeroNode> stack = new Stack<>();
        HeroNode temp = head;
        while (temp.next != null) {
            stack.push(temp.next);
            temp = temp.next;
        }
        while (stack.size() > 0) {
            System.out.println(stack.pop());
        }

    }

    /**
     * 5.合并两个有序的单链表，合并之后的链表依然有序【课后练习.】
     */
    //递归
    //网上的算法好多都是不带头结点的，这里是带头结点的，其实也就是加不加next的区别
    public static HeroNode mergeList(HeroNode head1, HeroNode head2) {
        if (head1.next == null) return head2;
        if (head2.next == null) return head1;
        HeroNode newHeroNode = new HeroNode();
        if (head1.next.hero.no < head2.next.hero.no) {
            newHeroNode.next = head1.next;
            newHeroNode.next.next = mergeList(head1.next, head2).next;
        } else {
            newHeroNode.next = head2.next;
            newHeroNode.next.next = mergeList(head1, head2.next).next;
        }
        return newHeroNode;
    }

    // 迭代
    // 两种方法：遍历方式的区别
    // 1.每个链表用两个临时变量循环遍历，如第三题reverseList2()
    // 2.用一个临时变量循环遍历（每次都摘下这个结点），始终保持为head.next，如第三题reverseList()
    public static HeroNode mergeList2(HeroNode head1, HeroNode head2) {
        HeroNode temp1 = head1.next, temp2 = head2.next;
        HeroNode newHeroNode = new HeroNode();
        HeroNode tail = newHeroNode;
        while (temp1 != null && temp2 != null) {
            if (temp1.hero.no < temp2.hero.no) {
                head1.next = temp1.next;
                temp1.next = null;
                tail.next = temp1;
                tail = tail.next;
                temp1 = head1.next;
            } else {
                head2.next = temp2.next;
                temp2.next = null;
                tail.next = temp2;
                tail = tail.next;
                temp2 = head2.next;
            }
        }
        if (temp1 == null)
            tail.next = temp2;
        if (temp2 == null)
            tail.next = temp1;
        return newHeroNode;
    }
}
