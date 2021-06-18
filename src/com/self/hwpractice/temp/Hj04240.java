package com.self.hwpractice.temp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;


/**
 * 构造递增序列，求最小值
 *
 * 构造递减序列，求最大值
 */
public class Hj04240 {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String temp;
        while ((temp = bufferedReader.readLine()) != null) {

            int num = Integer.valueOf(bufferedReader.readLine());
            System.out.println(getResult(temp,num));
        }
    }

    private static int getResult(String str,int count) {

        Deque<Integer> stack = new ArrayDeque<>();

        stack.addLast(Integer.valueOf(String.valueOf(str.charAt(0))));

        int use = 0;

        for (int i = 1; i < str.length(); i++) {
            int pre = stack.peekLast();
            int curr = Integer.valueOf(String.valueOf(str.charAt(i)));

            if (curr >= pre){
                stack.addLast(curr);
            }else {
                while (!stack.isEmpty() && curr < pre && use < count){
                    stack.pollLast();
                    pre =null == stack.peekLast() ? 0 : stack.peekLast();
                    use++;
                }
                stack.addLast(curr);
            }
        }

        int num = (count - use);
        while (num > 0 ){
            stack.pollLast();
        }

        int result =0;

        while (!stack.isEmpty()){

            result = result * 10 + stack.pollFirst();
        }
        return result;
    }
}
