package com.self.allpractice;

import edu.princeton.cs.algs4.In;

public class Problem001_brackets {

    public static void main(String[] args) {
        String str = "(()(())))";
        System.out.println(isCorrect(str));
        System.out.println(depth(str));
        System.out.println(lagestLong(str));
        System.out.println(correctForNum(str));
    }


    static char leftChar = '('; //左括号字符
    static char rightChar = ')';//右括号字符

    /**
     * 判断字符串是否满足括号成对出现的情况（不符合要求情况：")("，符合要求情况"(())"）
     *
     * @param str
     * @return
     */
    public static boolean isCorrect(String str) {
        if (null == str || str.length() < 2) return false;
        // 统计过程中，左括号数量>= 右括号数量，  统计完成后，二者数据量一定相等
        int count = 0;  // 记录左括号数量，如果遇到右括号，则抵消一个
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == leftChar) {
                count++;
            } else {
                count--;
            }
            if (count < 0) return false;
        }
        return count == 0 ? true : false;
    }


    /**
     * 给定字符串判断需要补充多少字符可，将字符串补全为符合左右括号对应字符串
     *
     * @param str
     * @return
     */
    public static int correctForNum(String str) {

        if (null == str || str.length() == 0) return 0; // 本题认为空字符串或者null情况下符合条件

        // 如果出现右括号多的情况，必须增加一个左括号 ，此条件为解题关键
        int need = 0;  // 记录最终结果
        int count = 0; // 统计过程中左右括号消耗情况
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == leftChar) {
                count++;
            } else {
                if (count == 0) {
                    need++;
                } else {
                    count--;
                }
            }
        }
        return need;
    }


    /**
     * 求取字符串中符合左右括号对应最大长度子串
     *
     * @param str
     * @return
     */
    public static int lagestLong(String str) {

        // 以当前位置为结尾点，统计其向左扩展最长符合左右括号对应条件字符串
        if (null == str || str.length() < 2) return 0;
        char[] chars = str.toCharArray();
        int len = chars.length;
        int[] dp = new int[len]; // 记录以当前位置为结点符合条件字符串长度，dp[0]默认一定为0
        int max = Integer.MIN_VALUE;
        for (int i = 1; i < len; i++) {
            if (chars[i] == rightChar) {
                int pre = i - dp[i - 1] - 1;
                if (pre >= 0 && chars[pre] == leftChar) {
                    dp[i] = dp[i - 1] + 2 + (pre > 0 ? dp[pre - 1] : 0);
                }
            }
            max = Math.max(dp[i], max);
        }
        return max;
    }


    public static int depth(String str) {
        if (null == str || str.length() < 2) return 0;
        char[] chars = str.toCharArray();
        int len = chars.length;
        int depth = 0;
        int count = 0;
        for (int i = 0; i < len; i++) {
            if (chars[i] == leftChar){
                count++;
            }else {
                count--;
            }
            depth = Math.max(depth,count);
        }
        return depth;
    }


}
