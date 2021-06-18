package com.self.hwpractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Hj076_Main {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String temp;
        while ((temp = bufferedReader.readLine()) != null) {
            int num = Integer.valueOf(temp);

            int start = num* num - num + 1;

            System.out.print(start);

            for (int i = 0; i < num - 1; i++) {
                System.out.print("+"+(start+=2));
            }
            System.out.println();

        }

        bufferedReader.close();
    }
}
