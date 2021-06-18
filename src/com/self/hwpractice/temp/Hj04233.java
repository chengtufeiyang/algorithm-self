package com.self.hwpractice.temp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 合法情况下直接统计左侧字符即可
 */
public class Hj04233 {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String temp;
        while ((temp = bufferedReader.readLine()) != null) {

            System.out.println(maxDepth(temp));

        }

    }

    private static int maxDepth(String str) {

        Deque<Character> stack = new ArrayDeque<>();

        int depth = 0;
        for (int i = 0; i < str.length(); i++) {
            char curr = str.charAt(i);

            if (curr == '(' || curr == '[' || curr == '{'){
                stack.addLast(curr);
                depth = Math.max(depth,stack.size());
                continue;
            }

            if (curr == ')'){
                if ('(' == stack.pollLast()){
                    continue;
                }else {
                    return 0;
                }
            }

            if (curr == ']'){
                if ('[' == stack.pollLast()){
                    continue;
                }else {
                    return 0;
                }
            }


            if (curr == '}'){
                if ('{' == stack.pollLast()){
                    continue;
                }else {
                    return 0;
                }
            }
        }

        return depth;
    }
}
