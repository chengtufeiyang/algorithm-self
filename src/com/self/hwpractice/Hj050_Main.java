package com.self.hwpractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class Hj050_Main {


    public static void main(String[] args) throws IOException {

//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        String temp;
//        while ((temp = bufferedReader.readLine()) != null) {
//
//            System.out.println(result(temp));
//        }

//        System.out.println(result("(1+2)*(2+1)-3"));
//        System.out.println(result("(2+1)-9"));
//        System.out.println(result("3+2*{1+2*[-4/(8-6)+7]}"));

//        System.out.println(result("3*5-1*3-6"));
        System.out.println(result("5-3+9*6*(6-10-2)"));

    }

    static int pos;

    public static int result(String str) {

        Deque<Integer> stack = new ArrayDeque<>();
        int num = 0;

        char currChar = '+';

        while (pos < str.length()) {

            char tempChar = str.charAt(pos);

            if (tempChar == '{' || tempChar == '[' || tempChar == '(') {
                pos++;
                num = result(str);
            }

            while (pos < str.length() && Character.isDigit(str.charAt(pos)) ){

                num = num * 10 + (str.charAt(pos) - '0');
                pos++;

            }


            switch (currChar){
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

            num = 0;

            if (pos < str.length()){

                currChar = str.charAt(pos);
                if (currChar == '}' || currChar == ']' || currChar == ')'){
                    pos++;
                    break;
                }
            }
            pos++;
        }


        int sum = 0;
        while (!stack.isEmpty()) {
            sum += stack.pollLast();
        }
        return sum;
    }


}
