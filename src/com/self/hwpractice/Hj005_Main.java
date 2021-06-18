package com.self.hwpractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Hj005_Main {

    public static void main(String[] args) throws IOException {

        // 直接读取每一行的数据，类型：字符串
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String  input;

        while ((input = bufferedReader.readLine() ) != null){

            String temp = input.substring(2,input.length());
            int sum = 0;
            int len = temp.length();
            for (int i = len - 1; i >= 0; i--) {
                char c = temp.charAt(i);
                int tempNum = (int)c;

                if (tempNum >= 65){
                    tempNum = tempNum - 65 + 10;
                }else {
                    tempNum = tempNum - 48;
                }

                sum += Math.pow(16,len - i - 1) * tempNum;
            }
            System.out.println(sum);
        }


    }

}
