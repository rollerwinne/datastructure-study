package cn.edu.bupt.p16_p29_linkedlist.doubleLinkedList;

import cn.edu.bupt.p16_p29_linkedlist.Hero;

public class DoubleLinkedListDemo {
    public static void main(String[] args) {
//        testLink();
        testAddByOrder();
    }
    public static void testLink(){
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();

        doubleLinkedList.list();
        HeroNode heroNode1 = new HeroNode(new Hero(1, "宋江", "及时雨"));
        HeroNode heroNode2 = new HeroNode(new Hero(2, "卢俊义", "玉麒麟"));
        HeroNode heroNode3 = new HeroNode(new Hero(3, "吴用", "智多星"));
        HeroNode heroNode4 = new HeroNode(new Hero(4, "林冲", "豹子头"));


        doubleLinkedList.add(heroNode1);
        doubleLinkedList.add(heroNode3);
        doubleLinkedList.add(heroNode2);
        doubleLinkedList.add(heroNode4);

        doubleLinkedList.list();

        doubleLinkedList.update(new HeroNode(new Hero(2,"hhh","fadfa")));

        doubleLinkedList.list();

        doubleLinkedList.delete(3);
        doubleLinkedList.list();

        doubleLinkedList.delete(4);
        doubleLinkedList.list();
    }

    public static void testAddByOrder(){
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();

        doubleLinkedList.list();
        HeroNode heroNode1 = new HeroNode(new Hero(1, "宋江", "及时雨"));
        HeroNode heroNode2 = new HeroNode(new Hero(2, "卢俊义", "玉麒麟"));
        HeroNode heroNode3 = new HeroNode(new Hero(3, "吴用", "智多星"));
        HeroNode heroNode4 = new HeroNode(new Hero(4, "林冲", "豹子头"));

        doubleLinkedList.addByOrder2(heroNode2);
        doubleLinkedList.addByOrder2(heroNode2);
        doubleLinkedList.addByOrder2(heroNode3);
        doubleLinkedList.addByOrder2(heroNode1);
        doubleLinkedList.addByOrder2(heroNode4);

        doubleLinkedList.list();
    }
}