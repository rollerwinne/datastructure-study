package cn.edu.bupt;

public class TestExtends {
    public static void main(String[] args) {
        new Son().fun();
    }
}

class Father{
    public void fun(){
        this.print();
    }
    //如果现在父类使用了private定义，那么就表示该方法只能被父类使用，子类无法使用，换句话说，子类是不知道父类有这样的方法的。
    private void print(){
        System.out.println("Father类的print方法");
    }
}
class Son extends Father{
    //这个时候该方法只是子类新定义的新方法而已，和父类的方法没有任何关系。
    public void print(){
        System.out.println("Son类的print方法");
    }
}