package com.self.hwpractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Hj056_Main {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String temp;
        while ((temp = bufferedReader.readLine()) != null) {

            System.out.println(getResult(Integer.valueOf(temp)));
        }

    }

    private static int getResult(int num) {

        int count = 0;
        for (int i = 1; i < num; i++) {

            if (isPerfact(i)){
                count++;
            }
        }
        return count;
    }

    private static boolean isPerfact(int val) {

        int sum = 0;
        for (int i = 1; i < val; i++) {
            if (val % i == 0){
                sum += i;
            }
        }
        return sum == val ? true : false;
    }
}
