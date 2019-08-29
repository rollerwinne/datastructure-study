package cn.edu.bupt.p16_p29_linkedlist;

public class Hero{
    public int no;
    public String name;
    public String nickname;

    public Hero() {
    }

    public Hero(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "Hero{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }

}
