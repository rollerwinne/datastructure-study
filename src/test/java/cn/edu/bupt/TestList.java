package cn.edu.bupt;

import java.util.ArrayList;
import java.util.List;

public class TestList {
    public static void main(String[] args) {
        List<String> testList = new ArrayList<String>() {
            {
                add("aa");
                add("bb");
                add("cc");
            }
        };
        String[] array2 = testList.toArray(new String[testList.size()]);
        for (int i = 0; i < array2.length; i++) {
            System.out.println(array2[i]);
        }
    }
}
