package com.self.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Interview_08_01_three_steps_problem_lcci {


    public static void main(String[] args) {

        Interview_08_01_three_steps_problem_lcci test = new Interview_08_01_three_steps_problem_lcci();
//        int n =3;
//        int n = 5;
        int n = 1000000;
//        int n = 2;
//        int n = 0;
//        System.out.println(test.waysToStep(n));
        System.out.println(test.waysToStep2(n));
        System.out.println(test.waysToStep3(n));
    }


    //    Example1:
//
//    Input: n = 3
//    Output: 4
//    Example2:
//
//    Input: n = 5
//    Output: 13
//    Note:
//
//            1 <= n <= 1000000
//
//    来源：力扣（LeetCode）
//    链接：https://leetcode-cn.com/problems/three-steps-problem-lcci
//    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
    int val = 1000000007;
    Map<Integer, Integer> map = new HashMap<>();

    public int waysToStep(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        return (waysToStep_r(n - 1) + waysToStep_r(n - 2) + waysToStep_r(n - 3)) % val;
    }

    private int waysToStep_r(int n) {
        if (n < 0) return 0;
        if (n == 0) return 1;
        if (null != map.get(n)) return map.get(n);

        map.put(n, waysToStep_r(n - 1) + waysToStep_r(n - 2) + waysToStep_r(n - 3));
        return map.get(n);
    }


    public int waysToStep2(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        if (n == 2) return 2;
        if (n == 3) return 4;


        long[] dp = new long[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        for (int i = 4; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2] + dp[i - 3]) % val;
        }
        return (int) dp[n];
    }


    public int waysToStep3(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        if (n == 2) return 2;
        if (n == 3) return 4;


        long one = 1;
        long two = 2;
        long three = 4;

        long temp = 0;
        for (int i = 4; i <= n; i++) {
            temp = (one + two + three) % val;
            one = two;
            two = three;
            three = temp;
        }
        return (int) three;
    }


}
