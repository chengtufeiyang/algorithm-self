package com.self.hwpractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Hj017_Main {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String temp;

        int left_right = 0; // A -   D +
        int up_down = 0;  //   W +   S -
        while ((temp = bufferedReader.readLine()) != null){

            String[] str = temp.split(";");
            for (int i = 0; i < str.length; i++) {

                String tempstr = str[i];
                if (tempstr.length() > 0 && normal(tempstr) ){

                    if (tempstr.charAt(0) == 'A'){
                        left_right -= Integer.valueOf(tempstr.substring(1));
                    }

                    if (tempstr.charAt(0) == 'D'){
                        left_right += Integer.valueOf(tempstr.substring(1));
                    }

                    if (tempstr.charAt(0) == 'W'){
                        up_down += Integer.valueOf(tempstr.substring(1));
                    }

                    if (tempstr.charAt(0) == 'S'){
                        up_down -= Integer.valueOf(tempstr.substring(1));
                    }

                }

            }

            System.out.println(left_right+ "," + up_down);

        }

    }

    private static boolean normal(String tempstr) {
        int len = tempstr.length();
        for (int i = 1; i < len; i++) {
               if (tempstr.charAt(i) < '0' || tempstr.charAt(i) > '9' ) return false;
        }
        return true;
    }
}
