package com.self.hwpractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Hj081_Main {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String temp;
        while ((temp = bufferedReader.readLine()) != null) {


            String str2 = bufferedReader.readLine();

            Map<Character,Integer> map = new HashMap<>();
            for (int i = 0; i < str2.length(); i++) {
                map.put(str2.charAt(i),1);
            }

            boolean flag = true;
            for (int i = 0; i < temp.length(); i++) {
                if (map.get(temp.charAt(i)) == null) {
                    flag = false;
                    break;
                }
            }
            if (flag){
                System.out.println(true);
            }else {
                System.out.println(false);
            }
        }
    }
}
