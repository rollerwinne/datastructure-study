package cn.edu.bupt.p16_p29_linkedlist.doubleLinkedList;

public class DoubleLinkedList {
    private HeroNode head;

    public DoubleLinkedList() {
        this(new HeroNode());
    }

    public DoubleLinkedList(HeroNode head) {
        this.head = head;
    }

    public void list() {
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        HeroNode temp = head.next;
        while (temp != null) {
            System.out.println(temp);
            temp = temp.next;
        }
        System.out.println("----------");
    }

    public void add(HeroNode heroNode) {
        HeroNode temp = head;
        while (temp.next != null)
            temp = temp.next;
        temp.next = heroNode;
        heroNode.pre = temp;
        heroNode.next = null;//这句话加不加的含义不太一样。不加：该方法加的节点可以是一个链表；加：该方法只加一个节点。
    }

    public void update(HeroNode heroNode) {
        if (head.next == null)
            System.out.println("链表为空");
        HeroNode temp = head.next;
        boolean flag = false;
        while (temp != null) {
            if (temp.hero.no == heroNode.hero.no) {
                temp.hero.name = heroNode.hero.name;
                temp.hero.nickname = heroNode.hero.nickname;
                flag = true;
            }
            temp = temp.next;
        }
        if (!flag) {
            System.out.println("不存在该节点");
        }
    }

    public void delete(int no) {
        if (head.next == null)
            System.out.println("链表为空，不能删除");
        HeroNode temp = head.next;
        boolean flag = false;
        while (temp != null) {
            if (temp.hero.no == no) {
                temp.pre.next = temp.next;
                if (temp.next != null)//很重要！我开始忘加了
                    temp.next.pre = temp.pre;
                flag = true;
            }
            temp = temp.next;
        }
        if (!flag)
            System.out.printf("不存在no=%d的节点\n", no);
    }

    /**
     * 作业题，按顺序添加结点
     * 下面两个方法都可以，大同小异
     */
    public void addByOrder(HeroNode heroNode) {
        HeroNode temp = head;
        boolean flag = false;
        while (temp.next != null) {
            if (temp.next.hero.no > heroNode.hero.no) {
                heroNode.pre = temp;
                temp.next.pre = heroNode;
                heroNode.next = temp.next;
                temp.next = heroNode;
                break;
            }
            if (temp.next.hero.no == heroNode.hero.no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag)
            System.out.println("编号已存在，添加结点失败");
        else if (temp.next == null) {//重要 在尾结点插入的条件
            heroNode.pre = temp;
            heroNode.next = null;//只加一个结点
            temp.next = heroNode;
        }
    }

    public void addByOrder2(HeroNode heroNode) {
        HeroNode temp = head;
        boolean flag = false;
        while (temp.next != null) {
            if (temp.next.hero.no > heroNode.hero.no) {
                break;
            }
            if (temp.next.hero.no == heroNode.hero.no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag)
            System.out.println("编号已存在，添加结点失败");
        else {
            heroNode.pre = temp;
            if (temp.next != null)
                temp.next.pre = heroNode;
            heroNode.next = temp.next;//尾部时temp.next就是null
            temp.next = heroNode;
        }
    }
}
