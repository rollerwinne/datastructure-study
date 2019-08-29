package cn.edu.bupt.p16_p29_linkedlist.singleLinkedList;

import cn.edu.bupt.p16_p29_linkedlist.Hero;

public class SingleLinkedList {
    private HeroNode head ;

    public HeroNode getHead(){
        return this.head;
    }

    public SingleLinkedList(){
        this.head = new HeroNode(new Hero());
    }
    public SingleLinkedList(HeroNode head){
        this.head=head;
    }
    public void add(HeroNode heroNode) {
        HeroNode node = head;
        while (node.next != null)
            node = node.next;
        node.next = heroNode;
        //下面的方法是不可行的
//        HeroNode node =head.next;
//        while (!(node==null))
//            node=node.next;
//        node=heroNode;
    }

//    public void addByOrderOld(HeroNode heroNode) {
//        HeroNode tmp = head;
//        while (tmp.next != null) {
//            if (tmp.next.hero.compareTo(heroNode.hero)==0)
//                throw new RuntimeException("该节点已存在");
//            if (tmp.hero.compareTo(heroNode.hero) < 0
//                    && tmp.next.hero.compareTo(heroNode.hero) > 0){
//                heroNode.next=tmp.next;
//                tmp.next=heroNode;
//                return;
//            }
//            tmp=tmp.next;
//        }
//        tmp.next=heroNode;
//    }

    public void addByOrder(HeroNode heroNode) {
        HeroNode tmp = head;
        boolean flag = false;
        while (tmp.next != null) {
            if (tmp.next.hero.no > heroNode.hero.no) {
                break;
            }
            if (tmp.next.hero.no == heroNode.hero.no) {
                flag = true;
                break;
            }
            tmp = tmp.next;
        }
        if (flag) {
            throw new RuntimeException("编号已存在");
        } else {
            heroNode.next = tmp.next;
            tmp.next = heroNode;
        }
    }

    public void update(HeroNode newHeroNode) {
//        if (head.next==null){
//            throw new RuntimeException("链表为空");
//        }
        HeroNode tmp = head;
        boolean flag = false;
        while (tmp.next != null) {
            if (tmp.next.hero.no == newHeroNode.hero.no) {
                tmp.next.hero.name = newHeroNode.hero.name;
                tmp.next.hero.nickname = newHeroNode.hero.nickname;
                flag = true;
                break;
            }
            tmp = tmp.next;
        }
        if (!flag) {
            throw new RuntimeException("该节点不存在");
        }
    }

    public void delete(int no) {
        HeroNode tmp = head;
        boolean flag = false;
        while (tmp.next != null) {
            if (tmp.next.hero.no == no) {
                tmp.next = tmp.next.next;
                flag = true;
                break;
            }
            tmp = tmp.next;
        }
        if (!flag) {
            throw new RuntimeException("要删除的节点" + no + "不存在");
        }
    }

    public void list() {
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
//        HeroNode node = head;
//        while (!(node.next==null)){
//            System.out.println(node);
//            node=node.next;
//        }
//        HeroNode node = head.next;
//        while (!(node==null)){
//            System.out.println(node);
//            node=node.next;
//        }
        HeroNode node = head;
        while (node.next != null) {
            System.out.println(node.next);
            node = node.next;
        }
    }
}
