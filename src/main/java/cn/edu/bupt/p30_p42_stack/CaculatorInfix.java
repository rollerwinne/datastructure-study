package cn.edu.bupt.p30_p42_stack;

import java.util.HashMap;
import java.util.Map;

/**
 * 中缀表达式四则运算
 *
 * @author mmc 502358401@qq.com
 */
public class CaculatorInfix {

    public static void main(String[] args) {
        int res = caculate("39-10*1-10*2+2*5*6");
        System.out.println(res);
    }

    private static Map<Character, Integer> priority = new HashMap<>();

    static {//定义运算符级别(为静态成员变量初始化)
        priority.put('+', 0);
        priority.put('-', 0);
        priority.put('*', 1);
        priority.put('/', 1);
    }

    public static int caculate(String expression) {
        ArrayStack<Integer> numStack = new ArrayStack<>(20);
        ArrayStack<Character> operStack = new ArrayStack<>(20);
        char ch;//每次扫描的符号
        for (int index = 0; index < expression.length(); index++) {
            ch = expression.charAt(index);
            if (isNum(ch)) {//每次扫描的是一个数字
                String numStr = "";//处理多位数
                numStr += ch;
                if (index == expression.length() - 1)
                    numStack.push(ch - '0');
                else {
                    while (index != expression.length() - 1 && isNum(expression.charAt(index + 1))) {
                        index++;
                        numStr += expression.charAt(index);
                    }
                    numStack.push(Integer.parseInt(numStr));
                }
            } else {//每次扫描的是一个符号
                if (operStack.isEmpty()) {//栈空则入符号栈
                    operStack.push(ch);
                } else {//栈不空则比较优先级
                    //这里要用while而不是if,韩老师考虑不周
                    while (!operStack.isEmpty() && //感觉以上三行有效代码可以合并啊,算了,为了逻辑清楚
                            priority.get(ch) <= priority.get(operStack.peek())) {
                        int num1 = numStack.pop();
                        int num2 = numStack.pop();
                        char oper = operStack.pop();
                        int res = cal(num1, num2, oper);
                        numStack.push(res);
                    }
                    operStack.push(ch);
                }
            }
        }
        while (!operStack.isEmpty()) {
            int num1 = numStack.pop();
            int num2 = numStack.pop();
            char oper = operStack.pop();
            int res = cal(num1, num2, oper);
            numStack.push(res);
        }
        return numStack.pop();
    }

    public static boolean isNum(char a) {
        return a >= '0' && a <= '9';
    }

    public static int cal(int a, int b, char oper) {
        int res;
        switch (oper) {
            case '+':
                res = b + a;
                break;
            case '-':
                res = b - a;
                break;
            case '*':
                res = b * a;
                break;
            case '/':
                res = b / a;
                break;
            default:
                throw new RuntimeException("符号不支持");
        }
        return res;
    }
}
