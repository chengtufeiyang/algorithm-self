package com.self.hwpractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Hj009_Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String temp ;

        while ((temp = bufferedReader.readLine()) != null){

            Map<Character,Integer> map = new HashMap<>();
            map.put(temp.charAt(temp.length() - 1),1);
            StringBuilder sb = new StringBuilder();
            sb.append(temp.charAt(temp.length() - 1));
            for (int i = temp.length() - 2; i >= 0; i--) {
                if (map.getOrDefault(temp.charAt(i),0) == 0){
                    sb.append(temp.charAt(i));
                    map.put(temp.charAt(i),1);
                }
            }
            System.out.println(sb);
        }


    }
}
