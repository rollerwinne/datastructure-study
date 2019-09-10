package cn.edu.bupt;

public class TestRegex {
    public static void main(String[] args) {
        String regex="^\\w+,[\\w\\-]+,[\\d:]+,admin,.*$";
        String str="DEBUG,2019-09-09,12:25:26,admin,查询用户信息列表,ALL,成功,";
        System.out.println(str.matches(regex));
    }
}
