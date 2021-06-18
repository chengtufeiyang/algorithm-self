package com.self.hwpractice;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class Hj010_Main {
    public static void main(String[] args) throws IOException {

        InputStream in = System.in;

        char curr = (char)in.read();

        Map<Character,Integer> map = new HashMap<>();

        while (curr != '\n'){

            if (curr >= 0 && curr <= 127 ){
                map.put(curr,1);
            }
            curr = (char)in.read();
        }
        System.out.println(map.keySet().size());

    }
}
