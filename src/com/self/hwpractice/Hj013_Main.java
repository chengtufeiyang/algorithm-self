package com.self.hwpractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Hj013_Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String temp ;

        while ((temp = bufferedReader.readLine()) != null){

            StringBuilder sb = new StringBuilder();
            String[] strs = temp.split(" ");
            for (int i = strs.length - 1; i >= 0; i--) {
                sb.append(strs[i]).append(" ");
            }

            System.out.println(sb);
        }
    }
}
