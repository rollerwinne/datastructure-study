package cn.edu.bupt;

import com.atguigu.algorithm.Test;
import org.omg.PortableInterceptor.INACTIVE;

import java.util.Set;
import java.util.TreeSet;

public class TestSet {
    public static Set<Integer> instanceCloseStatus= new TreeSet<>();
    static {
        instanceCloseStatus.add(3);
        instanceCloseStatus.add(5);
        instanceCloseStatus.add(6);
        instanceCloseStatus.add(7);
        instanceCloseStatus.add(9);
        instanceCloseStatus.add(11);
    }
    public static void main(String[] args) {
        int status=5;
        if (TestSet.instanceCloseStatus.contains(status))
            System.out.println("关了");
        else
            System.out.println("没关");
    }
}
