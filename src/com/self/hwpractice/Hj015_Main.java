package com.self.hwpractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Hj015_Main {
    public static void main(String[] args) throws IOException {


        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String temp ;


        while ((temp = bufferedReader.readLine()) != null){

            int count = 0;
            int num = Integer.parseInt(temp);

            while (num > 0){
                if ((num & 1) == 1){
                    count++;
                }
                num = num >> 1;
            }
            System.out.println(count);
        }




//        while ((temp = bufferedReader.readLine()) != null){
//
//            String str = Integer.toBinaryString(Integer.valueOf(temp));
//            int count = 0;
//            for (int i = 0; i < str.length(); i++) {
//                if (str.charAt(i) == '1'){
//                    count++;
//                }
//            }
//            System.out.println(count);
//        }
    }
}
