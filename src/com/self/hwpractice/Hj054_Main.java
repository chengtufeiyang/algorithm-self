package com.self.hwpractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class Hj054_Main {


    /**
     * 给定一个字符串描述的算术表达式，计算出结果值。
     * <p>
     * 输入字符串长度不超过100，合法的字符包括”+, -, *, /, (, )”，”0-9”，字符串内容的合法性及表达式语法的合法性由做题者检查。本题目只涉及整型计算。
     * <p>
     * 输入描述：
     * 输入算术表达式
     * <p>
     * 输出描述：
     * 计算出结果值
     * <p>
     * 示例1
     * 输入：
     * 400+5
     * 复制
     * 输出：
     * 405
     */


    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String temp;
        while ((temp = bufferedReader.readLine()) != null) {
            System.out.println(getResult(temp));
        }

//        System.out.println(getResult("400+5"));

    }

    /**
     * 遇到括号递归计算
     *
     * @param temp
     * @return
     */
    static int pos; //当前读取位置信息

    private static int getResult(String temp) {

        char curr = '+';//默认使用加法运算
        Deque<Integer> stack = new ArrayDeque<>(); //  存储数值，最终均使用加法运算

        while (pos < temp.length()) {

            int num = 0;
            if (pos < temp.length() && temp.charAt(pos) == '(') { //遇括号进入递归逻辑
                pos++;
                num = getResult(temp);
            }

            //尽量统计所有数字
            while (pos < temp.length() && temp.charAt(pos) >= '0' && temp.charAt(pos) <= '9') {

                num = num * 10 + Integer.valueOf(String.valueOf(temp.charAt(pos)));
                pos++;
            }

            switch (curr) {
                case '+':
                    stack.addLast(num);
                    break;
                case '-':
                    stack.addLast(-num);
                    break;
                case '*':
                    stack.addLast(stack.pollLast() * num);
                    break;
                case '/':
                    stack.addLast(stack.pollLast() / num);
                    break;
            }

            if (pos < temp.length()) {

                if (temp.charAt(pos) == ')') {
                    pos++;
                    break;
                } else {
                    curr = temp.charAt(pos++);
                }
            }
        }


        int sum = 0;
        while (!stack.isEmpty()) {
            sum += stack.pollLast();
        }
        return sum;
    }

}
