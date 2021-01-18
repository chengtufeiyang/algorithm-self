package com.self.practice.c03_dp;


import com.self.practice.comm_tools.Constants;

public class P03_longest_palindromic_subsequence {

    public static void main(String[] args) {
        String s = "afadaea";
        System.out.println(normal(s));
        System.out.println(dp(s));
    }


    //    最长回文子串（子序列---不连续） 字符串

    public static String normal(String s){
        if (null == s || s.length() ==0) return Constants.EMPTY_STR;
        return  recursion(s,0,s.length()-1);
    }


    public static String recursion(String s,int left ,int right){
        if (left > right) return Constants.EMPTY_STR;
        if (left == right) return String.valueOf(s.charAt(left));

        String leftStr = recursion(s,left,right-1);
        String rightStr = recursion(s,left+1,right);
        String midStr = recursion(s,left+1,right-1);
        if (s.charAt(left) == s.charAt(right)){
            midStr += String.valueOf(s.charAt(right));
            midStr = String.valueOf(s.charAt(left)) + midStr;
        }

        int leftLen = leftStr.length();
        int rightLen = rightStr.length();
        int midLen = midStr.length();
        int len = Math.max(midLen,Math.max(leftLen,rightLen));
        return len == leftLen ? leftStr : (len == rightLen ? rightStr : midStr);
    }



    public static String dp(String s){
        if (null == s || s.length() ==0) return Constants.EMPTY_STR;
        int len = s.length();
        String[][] dp = new String[len][len];
        for (int i = 0; i < dp.length; i++) {
            for (int i1 = 0; i1 < dp[0].length; i1++) {
                dp[i][i1] = Constants.EMPTY_STR;
            }
        }
        for (int i = 0; i < len; i++) { //初始化 横纵坐标相等情况
            dp[i][i] = String.valueOf(s.charAt(i));
        }

        for (int left = len-2; left >=0; left--) {  // left
            for (int right = left; right < len; right++) { // right
                String leftStr = pick(dp,left,right-1);
                String rightStr = pick(dp,left+1,right);
                String midStr = pick(dp,left+1,right-1);
                if (s.charAt(left) == s.charAt(right)){
                    if (left == right){
                        midStr += String.valueOf(s.charAt(right));
                    }else {
                        midStr += String.valueOf(s.charAt(right));
                        midStr = String.valueOf(s.charAt(left)) + midStr;
                    }
                }

                int leftLen = leftStr.length();
                int rightLen = rightStr.length();
                int midLen = midStr.length();
                int result = Math.max(midLen,Math.max(leftLen,rightLen));
                dp[left][right] = result == leftLen ? leftStr : (result == rightLen ? rightStr : midStr);
            }
        }
        return  dp[0][len-1];
    }


    public static String pick(String[][]  arr , int left ,int right){
        if (left < 0 || right <0 || left >= arr.length || right >= arr[0].length )return Constants.EMPTY_STR;

        return arr[left][right];
    }

}
