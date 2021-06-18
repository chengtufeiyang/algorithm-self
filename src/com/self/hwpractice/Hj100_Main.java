package com.self.hwpractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Hj100_Main {

    public static void main(String[] args) throws IOException {

        // 初始值 2   差值 3

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String temp;

        int a1 = 2;
        int d = 3;
        while ((temp = bufferedReader.readLine()) != null){

            int n = Integer.valueOf(temp);

            System.out.println(n * a1 + n * (n - 1) * d / 2);
        }


    }
}
