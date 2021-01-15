package com.self.practice.c03_dp;

import com.self.practice.comm_tools.Constants;

public class P03_longest_palindromic_substring {

    public static void main(String[] args) {
            String str = "bbabcba";

        System.out.println(recursion(str));
        System.out.println(dp(str));
    }

//    最长回文子串（字串---连续，子序列---不连续）
    public static String recursion(String str){
        if (null == str || str.length()==0) return Constants.EMPTY_STR;
        return recursionDet(str,0,str.length()-1);
    }

    /**
     * 获取范围内最大回文子串
     * @param str
     * @param left
     * @param right
     * @return
     */
    private static String recursionDet(String str, int left, int right) {
        if(left >=str.length() || right < 0 ) return "";
        if (left==right){
            return String.valueOf(str.charAt(left));
        }
        String leftStr = recursionDet(str,left,right-1);
        String rightStr = recursionDet(str,left+1,right);
        String midStr = recursionDet(str,left+1,right-1);
        if (left+1 < str.length() && left<right
                && str.charAt(left)==str.charAt(right)
                && midStr.equals(str.substring(left+1,right))){
            midStr = str.substring(left,right+1);
        }

        int leftLen = leftStr.length();
        int rightLen = rightStr.length();
        int midLen = midStr.length();
        int result = Math.max(leftLen,Math.max(rightLen,midLen));
        return result == leftLen ? leftStr : (result == rightLen ? rightStr : midStr);
    }



    public static String dp(String str){
        if (null == str || str.length()==0) return Constants.EMPTY_STR;
        String[][] dp = new String[str.length()][str.length()];

        for (int i = 0; i < dp.length; i++) { //初始化dp数组  数组下半部分不会用到
            for (int i1 = 0; i1 < dp[0].length; i1++) {
                dp[i][i1] = i ==i1 ? String.valueOf(str.charAt(i)) : "";
            }
        }


        for (int i = 1; i < dp[0].length; i++) {
            int left = 0;
            int right = i;
            while (right < str.length()){
                String leftStr = dp[left][right-1];
                String rightStr = dp[left+1][right];
                String midStr = dp[left+1][right -1];
                if (str.charAt(left) == str.charAt(right)  && midStr.length() == (right-left -1)){
                    midStr = str.substring(left,right+1);
                }
                int leftLen = leftStr.length();
                int rightLen = rightStr.length();
                int midLen = midStr.length();
                int result = Math.max(leftLen,Math.max(rightLen,midLen));
               dp[left][right] = result== leftLen ? leftStr : (result == rightLen ? rightStr : midStr);
                left++;
                right++;
            }
        }
        return dp[0][str.length()-1];
    }


}


