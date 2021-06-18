package com.self.hwpractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Hj090_Main {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String temp;
        while ((temp = bufferedReader.readLine()) != null) {

            String[] strs = temp.split("\\.");
            int count = 0;
            for (int i = 0; i < strs.length; i++) {
                String tempStr = strs[i];
                if (isNum(tempStr)){
                    if (!(Integer.valueOf(tempStr)>= 0 && Integer.valueOf(tempStr) <= 255)){
                        System.out.println("NO");
                        count++;
                    }
                }else {
                    System.out.println("NO");
                    count++;
                }
            }
            if (count == 0)            System.out.println("YES");
        }
    }

    public static boolean isNum(String str){


        for (int i = 0; i < str.length(); i++) {
            if (!(str.charAt(i) >= '0' && str.charAt(i) <= '9')){
                return false;
            }
        }
        return true;
    }
}
