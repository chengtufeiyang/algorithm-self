package com.self.hwpractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Hj004_Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String temp ;

        while ( (temp = bufferedReader.readLine()) != null ){

            temp = complete(temp);

            for (int i = 0; i < temp.length() - 7; i += 8) {
                System.out.println(temp.substring(i,i + 8));
            }
        }
    }

    public static String complete(String str){
        if (str.length() % 8 == 0) return str;
        int num = 8 - str.length() % 8;

        for (int i = 0; i < num; i++) {
            str += "0";
        }
        return str;
    }


}
