package cn.edu.bupt.p016_p029_linkedlist.doubleLinkedList;

import cn.edu.bupt.p016_p029_linkedlist.Hero;

public class HeroNode {
    public Hero hero;
    public HeroNode pre;
    public HeroNode next;

    public HeroNode() {
    }

    public HeroNode(Hero hero){
        this.hero=hero;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "hero=" + hero +
                '}';
    }
}
