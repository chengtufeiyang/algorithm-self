package com.self.hwpractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Hj099_Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String temp;

        while ((temp = bufferedReader.readLine()) != null){

            System.out.println(CalcAutomorphicNumbers(Integer.valueOf(temp)));

        }

    }

//  只有以0  1  5  6  结尾的数字才有可能是自守数
    public static int CalcAutomorphicNumbers(int n ){
        int count = 0;

        for (int i = 0; i <= n; i++) {
          if (i % 10 == 0 || i % 10 == 1 || i % 10 == 5 || i % 10 == 6 ){
              if (comStr1Str2(String.valueOf(i),String.valueOf((int)Math.pow(i,2)))){
                  count++;
              }
          }
        }

        return count;
    }


    public static boolean comStr1Str2(String str1 ,String str2){

        //  默认知道str1 短  str2 长

        int len = str1.length();

        return str1.equals(str2.substring(str2.length() - len));
    }

}
