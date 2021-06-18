package com.self.hwpractice;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class Hj002_Main {

    // 计算某字母出现次数
    public static void main(String[] args) throws IOException {

        InputStream in = System.in;

        Map<Character,Integer> map = new HashMap<>();

        char curr = (char)in.read();
        while (curr != '\n'){

            map.put(curr,map.getOrDefault(curr,0) + 1);
            curr = (char)in.read();
        }

        curr = (char)in.read();
        if (curr >= 'a' && curr <= 'z'){
            System.out.println(map.getOrDefault(curr,0)
            + map.getOrDefault((char)(curr - 32),0));
        }

        if (curr >= 'A' && curr <= 'Z'){
            System.out.println(map.getOrDefault(curr,0)
                    + map.getOrDefault((char)(curr + 32),0));
        }


    }
}
