package cn.edu.bupt.p30_p41_stack;

import java.util.HashMap;
import java.util.Map;

/**
 * 练习:直接计算带括号的中缀表达式
 * 思路:遇到'('直接入栈 遇到')'则计算到'('
 * 扩展:加上了'^'运算
 * 可以再考虑扩展为double(to be finished)
 *
 * @author mmc 502358401@qq.com
 */
public class CaculatorPro {

    public static void main(String[] args) {
        int res = caculate("15-2*((20-3*3-2*2)-2)");
        System.out.println(res);
    }

    private static Map<Character, Integer> priority = new HashMap<>();

    static {//定义运算符级别(为静态成员变量初始化)
        priority.put('(', -1);//栈内优先级为最低(谁都可以放在它上面)
        priority.put('+', 0);
        priority.put('-', 0);
        priority.put('*', 1);
        priority.put('/', 1);
        priority.put('^', 2);
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
            } else if (isOper(ch)) {//每次扫描的是一个符号
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
            } else if (ch == '(') {//每次扫描的是左括号
                operStack.push(ch);
            } else if (ch == ')') {//每次扫描的是右括号
                char oper;
                while (true) {
                    if (operStack.isEmpty())
                        throw new RuntimeException("括号匹配有误");
                    oper = operStack.pop();
                    if (oper == '(')
                        break;
                    int num1 = numStack.pop();
                    int num2 = numStack.pop();
                    int res = cal(num1, num2, oper);
                    numStack.push(res);
                }
            } else {//不是数字 不是操作符 不是括号 抛异常
                throw new RuntimeException("不支持的符号");
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

    public static boolean isOper(char a) {
        return a == '+' ||
                a == '-' ||
                a == '*' ||
                a == '/' ||
                a == '^';
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
            case '^':
                res = (int) Math.pow(b, a);
            default:
                throw new RuntimeException("符号不支持");
        }
        return res;
    }
}
