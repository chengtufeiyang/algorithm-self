package com.self.practice.c03_dp;

public class P03_longest_palindromic_substring_num {

    public static void main(String[] args) {

        String str  = "aba";
        System.out.println(normal(str));
        System.out.println(dp(str));
    }

    //    最长回文子串（字串---连续 数量
    public static int normal(String str){
        if (null==str || str.length()==0) return 0;

        return process(str,0,str.length()-1);
    }

    private static int process(String str, int curr, int right) {
        if (curr > right ) return 0;
        if (curr==right) return 1;

        int leftLen = process(str,curr,right -1);
        int rightLen = process(str,curr+1,right);

        int mid = process(str,curr+1,right-1);
        if (str.charAt(curr) == str.charAt(right)
           && mid == (right -curr -1) ){
            mid +=2;
        }
        return mid >0 ? mid :(leftLen > rightLen ? leftLen : rightLen);
    }



    public static int dp(String str){
        if (null==str || str.length()==0) return 0;

        int len = str.length();
        int[][] dp = new int[len+1][len+1];
        for (int i = 0; i < len; i++) {
            dp[i][i] = 1;
        }

        for (int i = 1; i < dp[0].length; i++) {
            int left = 0;
            int right = i;
            while (left < len && right < len){
                int leftLen = dp[left][right -1];
                int rightLen = dp[left+1][right];
                int mid = dp[left+1][right-1];
                if (str.charAt(left) == str.charAt(right)
                        && mid == (right -left -1) ){
                    mid +=2;
                }

                dp[left][right] = Math.max(leftLen,Math.max(rightLen,mid));
                left++;
                right++;
            }
        }
        return dp[0][len-1];
    }


}
