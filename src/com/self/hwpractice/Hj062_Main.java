package com.self.hwpractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Hj062_Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String temp;
        while ((temp = bufferedReader.readLine()) != null) {

            System.out.println(getResult(Integer.valueOf(temp)));
        }
    }

    private static int getResult(int num) {

        int count = 0;
        while (num >0){

            if ((num & 1) ==1){
                count++;
            }
            num = num >> 1;
        }
        return count;
    }
}
