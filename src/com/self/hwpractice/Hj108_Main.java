package com.self.hwpractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Hj108_Main {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String temp ;

        while ((temp = bufferedReader.readLine()) != null){

            int a = Integer.valueOf(temp.split(" ")[0]);
            int b = Integer.valueOf(temp.split(" ")[1]);
            int num = a * b;
            int r = 1;//  最大公约数

            do {
                r = a % b;
                a = b;
                b = r;
            }while (b != 0);

            System.out.println(num / a);

        }

    }
}
