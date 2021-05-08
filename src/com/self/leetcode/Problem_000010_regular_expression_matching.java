package com.self.leetcode;

import java.util.Arrays;

public class Problem_000010_regular_expression_matching {


    public static void main(String[] args) {

        Problem_000010_regular_expression_matching test = new Problem_000010_regular_expression_matching();

//        String s = "aa" ,p = "a";

//        String s = "aa", p = "a*";

        String s = "ab", p = ".*";

//        String s = "aab" ,p = "c*a*b";

//        String s = "mississippi", p = "mis*is*p*.";

//        String s = "aaa", p = "a*a";

//        String s = "bbbba",p = ".*a*a";

//        String s = "a",p = ".*a*a";

        System.out.println(test.isMatch(s, p));
        System.out.println(test.isMatch2(s, p));

        System.out.println(test.isMatch3(s, p));
    }

    /**
     * 给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
     * <p>
     * '.' 匹配任意单个字符
     * '*' 匹配零个或多个前面的那一个元素
     * 所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。
     * <p>
     *  
     * 示例 1：
     * <p>
     * 输入：s = "aa" p = "a"
     * 输出：false
     * 解释："a" 无法匹配 "aa" 整个字符串。
     * 示例 2:
     * <p>
     * 输入：s = "aa" p = "a*"
     * 输出：true
     * 解释：因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a' 重复了一次。
     * 示例 3：
     * <p>
     * 输入：s = "ab" p = ".*"
     * 输出：true
     * 解释：".*" 表示可匹配零个或多个（'*'）任意字符（'.'）。
     * 示例 4：
     * <p>
     * 输入：s = "aab" p = "c*a*b"
     * 输出：true
     * 解释：因为 '*' 表示零个或多个，这里 'c' 为 0 个, 'a' 被重复一次。因此可以匹配字符串 "aab"。
     * 示例 5：
     * <p>
     * 输入：s = "mississippi" p = "mis*is*p*."
     * 输出：false
     *  
     * <p>
     * 提示：
     * <p>
     * 0 <= s.length <= 20
     * 0 <= p.length <= 30
     * s 可能为空，且只包含从 a-z 的小写字母。
     * p 可能为空，且只包含从 a-z 的小写字母，以及字符 . 和 *。
     * 保证每次出现字符 * 时，前面都匹配到有效的字符
     * <p>
     * <p>
     * 链接：https://leetcode-cn.com/problems/regular-expression-matching
     *
     * @param s
     * @param p
     * @return
     */

    char dot = '.';
    char asterisk = '*';

    public boolean isMatch(String s, String p) {
        return isMatch_recursion(s, p, 0, 0);
    }

    private boolean isMatch_recursion(String s, String p, int si, int pi) {
        if (si == s.length()) { // 如果si越界
            if (pi == p.length()) return true; // 同时pi也越界，则true

            if (pi + 1 < p.length() && p.charAt(pi + 1) == asterisk) { // 若pi+1不越界，且其值 ！= ‘*’，则进入递归
                return isMatch_recursion(s, p, si, pi + 2);
            }
            return false;

        }

        if (pi == p.length()) { // 如果s未结束，p结束，则直接返回false
            return false;
        }

// 后续无*
        if (pi + 1 >= p.length() || p.charAt(pi + 1) != asterisk) { // 列举pi + 1 位置非* 情况
            if (p.charAt(pi) == dot || p.charAt(pi) == s.charAt(si)) { // 若当前位置字符是 ‘.’ or pi字符与si字符相同 ，则进入下一轮递归
                return isMatch_recursion(s, p, si + 1, pi + 1);
            }
            return false;
        }

// 明确以下情况已确认为 pi + 1 是 * 的情况
        if (isMatch_recursion(s, p, si, pi + 2)) return true;// 递归判断若*以及之前字符为0次含义是否满足要求


        if ((s.charAt(si) == p.charAt(pi) || p.charAt(pi) == dot) && isMatch_recursion(s, p, si + 1, pi)) {
            return true;
        }

//        while (si < s.length() && (s.charAt(si) == p.charAt(pi) || p.charAt(pi) == dot)) {// si字符与pi字符相等 or pi字符是 . 的情况，根据相同字符情况，列举*重复次数后面的数据情况
//
//            if (isMatch_recursion(s, p, si + 1, pi + 2)) {// 重复1次 2次 3次 。。。。
//                return true;
//            }
//            si++;
//        }

        return false;
    }

    /**
     * 记忆化搜索方式，优化可能利用*多次匹配的情况
     *
     * @param s
     * @param p
     * @return
     */
    public boolean isMatch2(String s, String p) {
        int[][] dp = new int[s.length() + 1][p.length() + 1]; // -1 未计算， 0 false   1 true
        for (int i = 0; i <= s.length(); i++) {
            Arrays.fill(dp[i], -1);
        }

        return isMatch_recursion2(s, p, 0, 0, dp);
    }

    private boolean isMatch_recursion2(String s, String p, int si, int pi, int[][] dp) {

        if (dp[si][pi] != -1) return dp[si][pi] == 1 ? true : false;

        if (si == s.length()) { // 如果si越界
            if (pi == p.length()) {

                dp[si][pi] = 1;
                return true; // 同时pi也越界，则true
            }

            if (pi + 1 < p.length() && p.charAt(pi + 1) == asterisk) { // 若pi+1不越界，且其值 ！= ‘*’，则进入递归
                boolean ans = isMatch_recursion2(s, p, si, pi + 2, dp);
                dp[si][pi] = ans == true ? 1 : 0;
                return ans;
            }

            dp[si][pi] = 0;
            return false;

        }

        if (pi == p.length()) { // 如果s未结束，p结束，则直接返回false
            dp[si][pi] = 0;
            return false;
        }

// 后续无*
        if (pi + 1 >= p.length() || p.charAt(pi + 1) != asterisk) { // 列举pi + 1 位置非* 情况
            if (p.charAt(pi) == dot || p.charAt(pi) == s.charAt(si)) { // 若当前位置字符是 ‘.’ or pi字符与si字符相同 ，则进入下一轮递归

                boolean ans = isMatch_recursion2(s, p, si + 1, pi + 1, dp);
                dp[si][pi] = ans == true ? 1 : 0;
                return ans;
            }
            dp[si][pi] = 0;
            return false;
        }

// 明确以下情况已确认为 pi + 1 是 * 的情况
        if (isMatch_recursion2(s, p, si, pi + 2, dp)) {

            dp[si][pi] = 1;
            return true;// 递归判断若*以及之前字符为0次含义是否满足要求
        }


        if ((s.charAt(si) == p.charAt(pi) || p.charAt(pi) == dot) && isMatch_recursion2(s, p, si + 1, pi, dp)) {
            dp[si][pi] = 1;
            return true;
        }

//        while (si < s.length() && (s.charAt(si) == p.charAt(pi) || p.charAt(pi) == dot)) {// si字符与pi字符相等 or pi字符是 . 的情况，根据相同字符情况，列举*重复次数后面的数据情况
//
//            if (isMatch_recursion2(s, p, si + 1, pi + 2,dp)) {// 重复1次 2次 3次 。。。。
//                dp[si][pi] = 1;
//                return true;
//            }
//            si++;
//        }

        dp[si][pi] = 0;
        return false;
    }

    public boolean isMatch3(String s, String p) {

        int m = s.length();
        int n = p.length();

        boolean[][] dp = new boolean[m + 1][n + 1]; // m ~ end   n ~ end
        dp[m][n] = true;
//        dp[si < m ][n]// s有余量，p无余量
        // s无余量，p有余量
        for (int pi = n - 1; pi >= 0; ) {  // 默认认为字符串中无连续** 情况,且如果存在*，其前方一定有一个非*字符
            if (p.charAt(pi) != asterisk) {
                break;
            }
            dp[m][pi - 1] = true;
            pi -= 2;
        }

        for (int si = m - 1; si >= 0; si--) {

            for (int pi = n - 1; pi >= 0; pi--) {
                boolean temp = false;
                if (pi + 1 >= n || p.charAt(pi + 1) != asterisk) { // 列举pi + 1 位置非* 情况
                    if (p.charAt(pi) == dot || p.charAt(pi) == s.charAt(si)) { // 若当前位置字符是 ‘.’ or pi字符与si字符相同 ，则进入下一轮递归
                        temp = dp[si + 1][pi + 1];
                    }
                } else  {
                    // 明确以下情况已确认为 pi + 1 是 * 的情况
                    if (dp[si][pi + 2]) {
                        temp = true;// 递归判断若*以及之前字符为0次含义是否满足要求
                    }else {
                        if ((s.charAt(si) == p.charAt(pi) || p.charAt(pi) == dot) && dp[ si + 1][ pi]) {
                            temp = true;
                        }
                    }
                }
                dp[si][pi] = temp;
            }
        }
        return dp[0][0];
    }


    public boolean isvalide(String s, String p, int si, int pi) {

        if (p.charAt(pi) == dot || s.charAt(si) == p.charAt(pi)) return true;

        return false;
    }


}
