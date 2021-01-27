package com.uzgf.top.interview;

import java.util.Stack;

/**
 * 括号有效配对是指：
 * 1) 任何一个左括号都能找到和其正确配对的右括号
 * 2) 任何一个右括号都能找到和其正确配对的左括号
 * 有效的：(()) ()() (()()) 等
 * 无效的：(() )( 等
 * 问题一： 怎么判断一个括号字符串有效?
 * 问题二：如果一个括号字符串无效, 返回至少填几个字符能让其整体有效
 */
public class Q002_ParenthesisMatch {

    public static boolean judgeValidWithStack(String str) {
        if (str == null || str.equals("")) {
            return true;
        }
        char[] cs = str.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (char c : cs) {
            if (c == '(') {
                stack.push(c);
                continue;
            }
            if (stack.isEmpty()) {
                return false;
            }
            stack.pop();
        }
        return stack.isEmpty();
    }

    public static boolean judgeValid(String str) {
        if (str == null || str.equals("")) {
            return true;
        }

        int count = 0;
        char[] cs = str.toCharArray();
        for (char c : cs) {
            if (c == '(') {
                count++;
                continue;
            }
            count--;
            if (count < 0) {
                return false;
            }
        }
        return count == 0;
    }

    public static int minAddNum(String str) {
        int count = 0;
        int res = 0;
        char[] cs = str.toCharArray();
        for (char c : cs) {
            if (c == '(') {
                count++;
                continue;
            }
            if (count - 1 < 0) {
                res++;
            } else {
                count--;
            }
        }
        return res + count;
    }

    public static void main(String[] args) {
        String str = "(";
        System.out.println(str + ":" + judgeValidWithStack(str) + ":" + judgeValid(str) + ":" + minAddNum(str));
        str += ")";
        System.out.println(str + ":" + judgeValidWithStack(str) + ":" + judgeValid(str));
        str += "()";
        System.out.println(str + ":" + judgeValidWithStack(str) + ":" + judgeValid(str));
        str += ")(";
        System.out.println(str + ":" + judgeValidWithStack(str) + ":" + judgeValid(str) + ":" + minAddNum(str));
    }



}
