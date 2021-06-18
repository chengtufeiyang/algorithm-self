package com.self.hwpractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Hj003_Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String temp;
        TreeSet<Integer> set = new TreeSet<>();

        while ((temp = bufferedReader.readLine()) != null){

            int lines = Integer.parseInt(temp);

            while (lines-- > 0 ){
                int num = Integer.parseInt(bufferedReader.readLine());
                set.add(num);
            }

            for ( int num : set) {
                System.out.println(num);
            }
            set.clear();
        }
    }
}
