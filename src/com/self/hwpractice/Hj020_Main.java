package com.self.hwpractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * 密码要求:
 * <p>
 * 1.长度超过8位
 * <p>
 * 2.包括大小写字母.数字.其它符号,以上四种至少三种
 * <p>
 * 3.不能有相同长度大于2的子串重复    -----如果存在长度为4的相同子串，那么一定存在长度为3的相同子串
 *
 */
public class Hj020_Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String temp;
        while ((temp = bufferedReader.readLine()) != null) {
            System.out.println(getResult(temp));
        }
    }

    private static String getResult(String str) {

        if (null == str || str.length() <= 8) return "NG";
        int len = str.length();

        Pattern one = Pattern.compile("[a-z]");
        Pattern two = Pattern.compile("[A-Z]");
        Pattern three = Pattern.compile("[0-9]");
        Pattern four = Pattern.compile("[^a-zA-Z0-9]");

        int type = 0;
        if (one.matcher(str).find()){
            type++;
        }
        if (two.matcher(str).find()){
            type++;
        }
        if (three.matcher(str).find()){
            type++;
        }
        if (four.matcher(str).find()){
            type++;
        }

        if (type < 3) return "NG";//  判断种类是否合规

// 统计所有长度3以及以上子串，，并记录其数量
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {

            if ((i + 2 + 1) <= len){
                String temp = str.substring(i, i + 2 + 1); // 需设置部分字符串
                if (null == map.get(temp)) {
                    map.put(temp, 1);
                } else {
                    return "NG";
                }
            }
        }
        return "OK";
    }
}
