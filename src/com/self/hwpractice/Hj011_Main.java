package com.self.hwpractice;

import javax.swing.text.TabExpander;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Hj011_Main {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String temp ;

        while ((temp = bufferedReader.readLine()) != null){

            StringBuilder sb = new StringBuilder(temp);
            System.out.println(sb.reverse());

        }

    }
}
