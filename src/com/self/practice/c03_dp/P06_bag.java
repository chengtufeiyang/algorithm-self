package com.self.practice.c03_dp;

public class P06_bag {
    public static void main(String[] args) {

        int[] weights = {3, 2, 4, 7, 3, 1, 7};
        int[] values = {5, 6, 3, 19, 12, 4, 2};
        int bag = 15;
        System.out.println(normal(weights, values, bag));
        System.out.println(dp(weights,values,bag));

    }

    //    6、背包问题（数组w[]---重量，v[]---价值数组，bag---书包容量）
//  可承载最大价值
    public static int normal(int[] w, int[] v, int bag) {
        if (bag < 0 || null == w || w.length == 0 || null == v || v.length == 0) return 0;

        return recursion(w, v, 0, bag);
    }

    public static int recursion(int[] w, int[] v, int index, int rest) {
        if (rest < 0) return -1;
        if (index >= w.length) return 0;

        //选择当前
        int curr = 0;
        int p = recursion(w, v, index + 1, rest - w[index]);
        if (p != -1) curr = v[index] + p;
        //不选择当前
        int noCurr = recursion(w, v, index + 1, rest);
        return Math.max(curr, noCurr);
    }


    public static int dp(int[] w, int[] v, int bag) {
        if (bag < 0 || null == w || w.length == 0 || null == v || v.length == 0) return 0;
        int len = w.length;
        int[][] dp = new int[len+1][bag + 1];

        for (int j = 1; j < dp[0].length; j++) {
            for (int i = len-1; i >=0; i--) {
                int p1 = pick(dp, i + 1, j - w[i]);  // 选取当前数值
                int p2 = pick(dp, i + 1, j); // 不取当前数值
                if (p1 != -1){
                    p1 += v[i];
                }
                dp[i][j] = Math.max(p1,p2);
            }
        }
        return dp[0][bag];
    }


    public static int pick(int[][] dp, int i, int j) {
        if (j < 0) return -1;
        if (i >= dp.length) return 0;

        return dp[i][j];

    }

}
