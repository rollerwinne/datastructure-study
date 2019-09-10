package cn.edu.bupt.p016_p029_linkedlist.singleLinkedList;

import cn.edu.bupt.p016_p029_linkedlist.Hero;

public class SingleLinkedListDemo {
    public static void main(String[] args) {
        //test1();
        //test2();
//        test3();
//        utilsTest1();
//        utilsTest2();
//        utilsTest3();
        utilsTest4();
    }

    private static void test1() {
        HeroNode heroNode1 = new HeroNode(new Hero(1, "宋江", "及时雨"));
        HeroNode heroNode2 = new HeroNode(new Hero(2, "卢俊义", "玉麒麟"));
        HeroNode heroNode3 = new HeroNode(new Hero(3, "吴用", "智多星"));
        HeroNode heroNode4 = new HeroNode(new Hero(4, "林冲", "豹子头"));

        SingleLinkedList singleLinkedList = new SingleLinkedList();
        singleLinkedList.add(heroNode1);
        singleLinkedList.add(heroNode2);
        singleLinkedList.add(heroNode3);
        singleLinkedList.add(heroNode4);

        singleLinkedList.list();
    }

//    private static void test2(){
//        HeroNode heroNode1 = new HeroNode(new Hero(1, "宋江", "及时雨"));
//        HeroNode heroNode2 = new HeroNode(new Hero(2, "卢俊义", "玉麒麟"));
//        HeroNode heroNode3 = new HeroNode(new Hero(3, "吴用", "智多星"));
//        HeroNode heroNode4 = new HeroNode(new Hero(4, "林冲", "豹子头"));
//
//        singleLinkedList singleLinkedList = new singleLinkedList();
//        singleLinkedList.addByOrderOld(heroNode4);
//        singleLinkedList.addByOrderOld(heroNode4);
//        singleLinkedList.addByOrderOld(heroNode1);
//        singleLinkedList.addByOrderOld(heroNode3);
//        singleLinkedList.addByOrderOld(heroNode2);
//
//        singleLinkedList.list();
//    }

    private static void test3() {
        HeroNode heroNode1 = new HeroNode(new Hero(1, "宋江", "及时雨"));
        HeroNode heroNode2 = new HeroNode(new Hero(2, "卢俊义", "玉麒麟"));
        HeroNode heroNode3 = new HeroNode(new Hero(3, "吴用", "智多星"));
        HeroNode heroNode4 = new HeroNode(new Hero(4, "林冲", "豹子头"));

        SingleLinkedList singleLinkedList = new SingleLinkedList();
        singleLinkedList.addByOrder(heroNode4);
        singleLinkedList.addByOrder(heroNode1);
        singleLinkedList.addByOrder(heroNode3);
        singleLinkedList.addByOrder(heroNode2);

        singleLinkedList.list();

        HeroNode newHeroNode = new HeroNode(new Hero(2, "卢22", "玉22"));
        singleLinkedList.update(newHeroNode);

        System.out.println("-----");
        singleLinkedList.list();

        singleLinkedList.delete(2);
        System.out.println("-----");
        singleLinkedList.list();
    }

    public static void utilsTest1(){
            HeroNode heroNode1 = new HeroNode(new Hero(1, "宋江", "及时雨"));
            HeroNode heroNode2 = new HeroNode(new Hero(2, "卢俊义", "玉麒麟"));
            HeroNode heroNode3 = new HeroNode(new Hero(3, "吴用", "智多星"));
            HeroNode heroNode4 = new HeroNode(new Hero(4, "林冲", "豹子头"));

            SingleLinkedList singleLinkedList = new SingleLinkedList();
            singleLinkedList.addByOrder(heroNode4);
            singleLinkedList.addByOrder(heroNode1);
            singleLinkedList.addByOrder(heroNode3);
            singleLinkedList.addByOrder(heroNode2);

            HeroNode head = singleLinkedList.getHead();

            System.out.println(LinkedListUtils.getlength(head));

            System.out.println(LinkedListUtils.findLastIndexNode(head,5));
            System.out.println(LinkedListUtils.findLastIndexNode2(head,5));

    }

    public static void utilsTest2(){
        HeroNode heroNode1 = new HeroNode(new Hero(1, "宋江", "及时雨"));
        HeroNode heroNode2 = new HeroNode(new Hero(2, "卢俊义", "玉麒麟"));
        HeroNode heroNode3 = new HeroNode(new Hero(3, "吴用", "智多星"));
        HeroNode heroNode4 = new HeroNode(new Hero(4, "林冲", "豹子头"));

        SingleLinkedList singleLinkedList = new SingleLinkedList();
        singleLinkedList.addByOrder(heroNode4);
//        singleLinkedList.addByOrder(heroNode1);
        singleLinkedList.addByOrder(heroNode3);
        singleLinkedList.addByOrder(heroNode2);

        singleLinkedList.list();
        HeroNode head = singleLinkedList.getHead();

        LinkedListUtils.reverseList2(head);
        System.out.println("-----");
        singleLinkedList.list();
    }

    public static void utilsTest3(){
        HeroNode heroNode1 = new HeroNode(new Hero(1, "宋江", "及时雨"));
        HeroNode heroNode2 = new HeroNode(new Hero(2, "卢俊义", "玉麒麟"));
        HeroNode heroNode3 = new HeroNode(new Hero(3, "吴用", "智多星"));
        HeroNode heroNode4 = new HeroNode(new Hero(4, "林冲", "豹子头"));

        SingleLinkedList singleLinkedList = new SingleLinkedList();
        singleLinkedList.addByOrder(heroNode4);
//        singleLinkedList.addByOrder(heroNode1);
        singleLinkedList.addByOrder(heroNode3);
        singleLinkedList.addByOrder(heroNode2);

        singleLinkedList.list();
        HeroNode head = singleLinkedList.getHead();

        LinkedListUtils.printReverseList2(head);
    }

    public static void utilsTest4(){
        HeroNode heroNode1 = new HeroNode(new Hero(1, "宋江", "及时雨"));
        HeroNode heroNode2 = new HeroNode(new Hero(2, "卢俊义", "玉麒麟"));
        HeroNode heroNode3 = new HeroNode(new Hero(3, "吴用", "智多星"));
        HeroNode heroNode4 = new HeroNode(new Hero(4, "林冲", "豹子头"));

        SingleLinkedList singleLinkedList1 = new SingleLinkedList();
        singleLinkedList1.addByOrder(heroNode4);
        singleLinkedList1.addByOrder(heroNode1);
        singleLinkedList1.addByOrder(heroNode3);
        singleLinkedList1.addByOrder(heroNode2);

        HeroNode heroNode5 = new HeroNode(new Hero(1, "宋江", "及时雨"));
        HeroNode heroNode6 = new HeroNode(new Hero(2, "卢俊义", "玉麒麟"));
        HeroNode heroNode7 = new HeroNode(new Hero(3, "吴用", "智多星"));
        HeroNode heroNode8 = new HeroNode(new Hero(4, "林冲", "豹子头"));

        SingleLinkedList singleLinkedList2 = new SingleLinkedList();
        singleLinkedList2.addByOrder(heroNode5);
        singleLinkedList2.addByOrder(heroNode6);
        singleLinkedList2.addByOrder(heroNode7);
        singleLinkedList2.addByOrder(heroNode8);

        HeroNode head1 = singleLinkedList1.getHead();
        HeroNode head2 = singleLinkedList2.getHead();

        HeroNode newHead = LinkedListUtils.mergeList2(head1,head2);
//        System.out.println(newHead);
        HeroNode temp =newHead;
        while (temp.next!=null){
            System.out.println(temp.next);
            temp=temp.next;
        }
//        for (int i = 0; i < 16; i++) {
//            System.out.println("temp = " + temp+ "\thashCode"+ temp.hashCode());
//            temp=temp.next;
//        }
        //new singleLinkedList(newHead).list();
    }
}
