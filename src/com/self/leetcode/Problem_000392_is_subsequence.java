package com.self.leetcode;

import java.util.Arrays;

public class Problem_000392_is_subsequence {


    public static void main(String[] args) {
        Problem_000392_is_subsequence test = new Problem_000392_is_subsequence();

        String s = "abc", t = "ahbgdc";
//        String  s = "axc", t = "ahbgdc";
        System.out.println(test.isSubsequence(s,t));
        System.out.println(test.isSubsequence2(s,t));
        System.out.println(test.isSubsequence3(s,t));
    }

//    Example 1:
//
//    Input: s = "abc", t = "ahbgdc"
//    Output: true
//    Example 2:
//
//    Input: s = "axc", t = "ahbgdc"
//    Output: false
//             
//
//    Constraints:
//
//            0 <= s.length <= 100
//            0 <= t.length <= 104
//    s and t consist only of lowercase English letters.
//
//            来源：力扣（LeetCode）
//    链接：https://leetcode-cn.com/problems/is-subsequence
//    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
    public boolean isSubsequence(String s, String t) {
        if (s.length() > t.length()) return false;
        char[] chars = s.toCharArray();
        char[] chart = t.toCharArray();
        return isSubsequence_recursion(chars,chart,0,0);
    }

    private boolean isSubsequence_recursion(char[] s, char[] t, int currs, int currt) {
        if (currs == s.length) return true;
        if (currt == t.length) return false;

        if (s[currs] == t[currt]){
            return isSubsequence_recursion(s,t,currs + 1,currt + 1);
        }else {
            return isSubsequence_recursion(s,t,currs,currt + 1);
        }
    }

    public boolean isSubsequence2(String s, String t) {
        if (s.length() > t.length()) return false;
        char[] chars = s.toCharArray();
        char[] chart = t.toCharArray();

        int len_s = chars.length;
        int len_t = chart.length;

        boolean[][] dp = new boolean[len_s + 1][len_t + 1];

//        for (int i = 0; i <= len_t; i++) { // 初始化数据
//            dp[len_s][i] = true;
//        }

        Arrays.fill(dp[len_s],true);

        for (int currs = len_s - 1; currs >= 0; currs--) {

            for (int currt = len_t -1; currt >= currs ; currt--) {
                if (chars[currs] == chart[currt]){
                    dp[currs][currt] = dp[currs + 1][currt + 1];
                }else {
                    dp[currs][currt] = dp[currs][currt + 1];
                }
            }
        }

        return dp[0][0];
    }


//  双指针
    public boolean isSubsequence3(String s, String t){
        int len_s = s.length();
        int len_t = t.length();

        int curr_s = 0;
        int curr_t = 0;

        while (curr_s < len_s && curr_t < len_t){


            if (s.charAt(curr_s) == t.charAt(curr_t)){
                curr_s++;
            }
            curr_t++;
        }

        return curr_s == len_s;
    }



    //字符均小写 预处理一个函数f[i][j] ，从位置i开始，第一次出现j字符的位置（字符j的范围0-26） ，i范围（0，t.length()）
}
