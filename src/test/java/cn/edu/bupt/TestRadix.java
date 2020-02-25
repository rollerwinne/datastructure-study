package cn.edu.bupt;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestRadix {
    public static void main(String[] args) {
        String str = "00000000000000000000000010101000";
        // System.out.println(Integer.parseInt(str,2));
        // System.out.println(Integer.toBinaryString(Integer.parseInt(str,2)));
        // System.out.println((byte)Integer.parseInt(str,2));
        // System.out.println(Byte.parseByte(str,2));
        System.out.println(Byte.parseByte("-10000000", 2));
        System.out.println(Integer.toBinaryString(-1));

        Map<String, Integer> map = new HashMap<>();
        int a = map.get("");
        System.out.println(a);

    }
}
