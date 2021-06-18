package com.self.hwpractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Hj021_Main {


    /**
     * 描述
     * 密码是我们生活中非常重要的东东，我们的那么一点不能说的秘密就全靠它了。哇哈哈. 接下来渊子要在密码之上再加一套密码，虽然简单但也安全。
     * <p>
     * 假设渊子原来一个BBS上的密码为zvbo9441987,为了方便记忆，他通过一种算法把这个密码变换成YUANzhi1987，
     * 这个密码是他的名字和出生年份，怎么忘都忘不了，而且可以明目张胆地放在显眼的地方而不被别人知道真正的密码。
     * <p>
     * 他是这么变换的，大家都知道手机上的字母： 1--1， abc--2, def--3, ghi--4, jkl--5, mno--6, pqrs--7, tuv--8 wxyz--9, 0--0,
     * 就这么简单，渊子把密码中出现的小写字母都变成对应的数字，数字和其他的符号都不做变换，
     * <p>
     * 声明：密码中没有空格，而密码中出现的大写字母则变成小写之后往后移一位，如：X，先变成小写，再往后移一位，不就是y了嘛，简单吧。记住，z往后移是a哦。
     * <p>
     * 输入描述：
     * 输入包括多个测试数据。输入是一个明文，密码长度不超过100个字符，输入直到文件结尾
     * <p>
     * 输出描述：
     * 输出渊子真正的密文
     * <p>
     * 示例1
     * 输入：
     * YUANzhi1987
     * 输出：
     * zvbo9441987
     */

    static Map<Character, Integer> map = new HashMap<>();

    static {

        map.put('a', 2);
        map.put('b', 2);
        map.put('c', 2);
        map.put('d', 3);
        map.put('e', 3);
        map.put('f', 3);
        map.put('g', 4);
        map.put('h', 4);
        map.put('i', 4);
        map.put('j', 5);
        map.put('k', 5);
        map.put('l', 5);
        map.put('m', 6);
        map.put('n', 6);
        map.put('o', 6);
        map.put('p', 7);
        map.put('q', 7);
        map.put('r', 7);
        map.put('s', 7);
        map.put('t', 8);
        map.put('u', 8);
        map.put('v', 8);
        map.put('w', 9);
        map.put('x', 9);
        map.put('y', 9);
        map.put('z', 9);
    }


    public static void main(String[] args) throws IOException {

        //  1、大写字母则变成小写之后往后移一位，意思是使用其后面以为的字符，均小写，循环方式
        //  2、小写字母都变成对应的数字
        //  3、数字和其他的符号都不做变换


        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String temp;
        while ((temp = bufferedReader.readLine()) != null) {


            StringBuilder sb = new StringBuilder();
            char curr ;
            for (int i = 0; i < temp.length(); i++) {
                curr = temp.charAt(i);
                if (curr >= 'a' && curr <= 'z'){
                    sb.append(map.get(curr));
                }else if (curr >= 'A' && curr <= 'Z'){
                    curr += 33;
                    if (curr <= 'z'){
                        sb.append(curr);
                    }else {
                        sb.append('a');
                    }
                }else {
                    sb.append(curr);
                }

            }

            System.out.println(sb);
        }
    }
}
