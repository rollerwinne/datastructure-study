package cn.edu.bupt.p16_p29_linkedlist;

public class HeroNode {
    public Hero hero;
    public HeroNode next;

    public HeroNode() {
    }

    public HeroNode(Hero hero) {
        this.hero = hero;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "hero=" + hero +
//                ", next=" + next +
                '}';
    }
}
