package cn.edu.bupt;

public class TestNull {
    public static void main(String[] args) {
        // System.out.println(null);
        testNull(null);
        System.out.println(null==null);
        System.out.println((String) null);
        System.out.println(((String)null).toString());
    }

    public static void testNull(String arg){
        String s=arg;
        System.out.println(s);
    }
}
