package cn.edu.bupt.p030_p042_stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * 计算后缀表达式
 */
public class CaculatorSuffix {
    public static void main(String[] args) {
        // String suffixExpression = "30 4 + 5 * 6 -"; //164
        String suffixExpression = "4 5 * 8 - 60 + 8 2 / +"; //76
        List<String> polishList = getStringList(suffixExpression);
        System.out.println(polishList);
        System.out.println(caculate(polishList));
    }

    private static List<String> getStringList(String suffixExpression) {
        List<String> list = new ArrayList<>();
        String[] splits = suffixExpression.trim().split(" ");
        //Collections.addAll(list,splits);//亦可
        list.addAll(Arrays.asList(splits));//亦可
        // for (String exp : splits) {//亦可
        //     list.add(exp);
        // }
        return list;
    }

    public static int caculate(List<String> polish) {
        Stack<Integer> numStack = new Stack<>();
        for (String ele : polish) {
            if (isNum(ele)) {
                numStack.push(Integer.parseInt(ele));
            } else if (isOper(ele)) {
                int num1 = numStack.pop();
                int num2 = numStack.pop();
                int res = cal(num1, num2, ele);
                numStack.push(res);
            } else {
                throw new RuntimeException("不识别的符号");
            }
        }
        return numStack.pop();
    }

    private static boolean isNum(String a) {
        return a.matches("[0-9]+");
    }

    private static boolean isOper(String a) {
        return a.matches("[\\+\\-\\*/\\^]");//正则匹配+-*/^ :[\+\-\*/\^]
    }

    private static int cal(int a, int b, String oper) {
        int res;
        switch (oper) {
            case "+":
                res = b + a;
                break;
            case "-":
                res = b - a;
                break;
            case "*":
                res = b * a;
                break;
            case "/":
                res = b / a;
                break;
            case "^":
                res = (int) Math.pow(b, a);
                break;
            default:
                throw new RuntimeException("符号不支持");
        }
        return res;
    }
}
