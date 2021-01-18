package com.self.practice.c03_dp;

public class P07_str_str_to_num_str {

    public static void main(String[] args) {
//        String s = "7210231231232031203123";
        String s = "111";
        System.out.println(normal(s));
        System.out.println(dp(s));
    }


    //    7、字符串转换问题（1--A,2---B...26---Z）,任意给出数字字符串，计算出有多少种字符字符串组合方式
//    （例如： “111”---“AAA”、“KA”、“AK”）
    public static int normal(String s) {
        if (null == s || s.length() == 0) return 0;

        return recursion(s, 0);
    }

    public static int recursion(String s, int curr) {
        if (curr >= s.length() - 1 ) return 1;  //说明已走通此路
        if (s.charAt(curr) == '0') return 0;   //当前字符不可为‘0’

        int p1 = 0;
        int p2 = 0;
        char temp = s.charAt(curr);
        if (temp > '0' && temp <= '9') {
            p1 = recursion(s, curr + 1);
        }
        if (curr + 1 < s.length()) {
            int temp2 = (Integer.valueOf(String.valueOf(temp)) * 10 +
                    Integer.valueOf(String.valueOf(s.charAt(curr + 1))));
            if (temp2 > 9 && temp2 <= 26) {
                p2 = recursion(s, curr + 2);
            }
        }
        return p1 + p2;
    }

    public static int dp(String s){
        if (null == s || s.length() == 0) return 0;
        int len = s.length();
        int[] dp = new int[len+1];
        dp[len] = 1;
        for (int i = len-1; i  >=0; i--) {
            int temp = 0;
            char curr = s.charAt(i);
            if (curr > '0' && curr <= '9'){
                temp = dp[i+1];
            }
            if ((i +1) < len ){
                int temp2 = (Integer.valueOf(String.valueOf(curr)) * 10 +
                        Integer.valueOf(String.valueOf(s.charAt(i + 1))));
                if (temp2 > 9 && temp2 <= 26) {
                    temp += dp [i + 2];
                }
            }
            dp[i] = temp;
        }

        return dp[0];
    }

    public static char pick(String s,int inde){
        if (inde<0 || inde >= s.length()) return 0;
        return s.charAt(inde);
    }
}
