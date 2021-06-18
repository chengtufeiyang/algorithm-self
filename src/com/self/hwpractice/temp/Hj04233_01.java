package com.self.hwpractice.temp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Hj04233_01 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String temp;
        while ((temp = bufferedReader.readLine()) != null) {

            int one = 0;
            int depth = 0;

            for (int i = 0; i < temp.length(); i++) {

                char curr = temp.charAt(i);
                if (curr == '('){
                    one++;
                }else {
                    one--;
                }
                depth = Math.max(depth,one);

            }
            System.out.println(depth);

        }
    }
}
