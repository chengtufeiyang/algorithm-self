package com.self.hwpractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Hj084_Main {

    public static void main(String[] args) throws IOException {


        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String temp;
        while ((temp = bufferedReader.readLine()) != null) {

            int count = 0;
            for (int i = 0; i < temp.length(); i++) {

                if (temp.charAt(i) >= 'A' && temp.charAt(i) <= 'Z') {
                    count++;
                }
            }

            System.out.println(count);
        }
    }
}
