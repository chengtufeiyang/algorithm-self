package com.self.hwpractice;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class Hj031_Main {

    // 单词倒排
    public static void main(String[] args) throws IOException {

        InputStream in = System.in;

        List<String> list = new ArrayList<>();

        char curr = (char)in.read();

        StringBuilder sb = new StringBuilder();
        while (curr != '\n'){

            if ((curr >= 'a' && curr <= 'z')
                    || (curr >= 'A' && curr <= 'Z')){
                sb.append(curr);
            }else {
                list.add(sb.toString());
                if(list.size() > 0 && list.get(list.size() - 1) != " " ) list.add(" ");
                sb = new StringBuilder();
            }
            curr = (char)in.read();
        }
        list.add(sb.toString());

        int len = list.size();
        sb = new StringBuilder();
        for (int i = len - 1; i >=0; i--) {
            sb.append(list.get(i));
        }
        System.out.println(sb.toString());
    }
}
