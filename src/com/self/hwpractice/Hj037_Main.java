package com.self.hwpractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Hj037_Main {

    public static void main(String[] args) throws IOException {


        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String temp;
        while ((temp = bufferedReader.readLine()) != null) {
            int num = Integer.valueOf(temp);

            System.out.println(getNum(num));
        }


//        System.out.println(getNum(9));
    }

    private static int getNum(int num) {

        if (num == 1 || num == 2 ) return 1;

        // 满足三个月 num - 2 新出生
        return getNum(num - 2)  + getNum(num - 1);
    }
}
