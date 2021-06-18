package com.self.hwpractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Hj096_Main {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String temp;
        while ((temp = bufferedReader.readLine()) != null) {

            StringBuilder sb = new StringBuilder();
            if (temp.charAt(0) >= '0' && temp.charAt(0) <= '9') {
                sb.append("*").append(temp.charAt(0));
            }else {
                sb.append(temp.charAt(0));
            }
            for (int i = 1; i < temp.length(); i++) {
                char curr = temp.charAt(i);
                char pre = temp.charAt(i - 1);
                if (curr >= '0' && curr <= '9'){// 数字

                    if (pre >= '0' && pre <= '9'){
                        sb.append(curr);
                    }else {
                        sb.append("*").append(curr);
                    }

                }else {
                    if (pre >= '0' && pre <= '9'){
                        sb.append("*").append(curr);
                    }else {
                        sb.append(curr);
                    }
                }
            }

            if (temp.charAt(temp.length() - 1) >= '0' && temp.charAt(temp.length() - 1) <= '9'){
                sb.append("*");
            }

            System.out.println(sb);
        }

    }
}
