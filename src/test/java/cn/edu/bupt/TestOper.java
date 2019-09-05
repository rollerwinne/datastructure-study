package cn.edu.bupt;

import org.junit.Test;

public class TestOper {
    @Test
    public void testOper(){
        String[] oper={"+","-","*","/","^","."};
        String regex="[\\+\\-\\*/\\^.]";
        regex="\\.";
        for (String ch : oper){
            System.out.println(ch.matches(regex));
        }
        System.out.println(regex);
    }
}
