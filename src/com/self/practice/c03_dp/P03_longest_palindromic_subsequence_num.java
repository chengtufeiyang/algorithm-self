package com.self.practice.c03_dp;

public class P03_longest_palindromic_subsequence_num {

    public static void main(String[] args) {

        String str = "abadcdabaaaaaaaaaaaaaaaabcdfgegefa";
//        String str = "aba";
        System.out.println(dp(str));

//        System.out.println(normal(str));

    }

    //    最长回文子串（子序列---不连续）长度
    public static int normal(String str) {
        if (null == str || str.length() == 0) return 0;

        return recursion(str, 0, str.length() - 1);
    }


    public static int recursion(String str, int left, int right) {
        if (left > right) return 0;
        if (left == right) return 1;

        int leftLen = recursion(str, left, right - 1);
        int rightLen = recursion(str, left + 1, right);

        int mid = recursion(str, left + 1, right - 1);

        if (mid == (right - left - 1) && str.charAt(left) == str.charAt(right)) {
            mid += 2;
        }
        return Math.max(leftLen, Math.max(rightLen, mid));
    }


    public static int dp(String s) {
        if (null == s || s.length() == 0) return 0;
        int len = s.length();
        int[][] dp = new int[len + 1][len + 1];
        for (int i = 0; i < len; i++) {
            dp[i][i] = 1;
        }
        //left >= right

        for (int i = 1; i < len; i++) {
            int left = 0;
            int right = i;
            while (left < len && right < len) {
                int leftLen = dp[left][right - 1];
                int rightLen = dp[left + 1][right];
                int mid = dp[left + 1][right - 1];
                if (flag(s,left) && flag(s,right)  && s.charAt(left) == s.charAt(right)) {
                    mid += 2;
                }
                dp[left][right] = Math.max(leftLen, Math.max(rightLen, mid));
                left++;
                right++;
            }

        }
        return dp[0][len - 1];
    }


    public static boolean flag(String str, int index) {

        int len = str.length()-1;
        return (index >=0 && index <= len) ? true :false;
    }

}
