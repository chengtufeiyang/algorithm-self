package com.self.practice.c03_dp;

public class P09_bit_monster {

    public static void main(String[] args) {

        int n = 6;
        int m = 3;
        int k = 3;
        System.out.println(normal(n, m, k));
        System.out.println(dp1(n, m, k));
        System.out.println(dp2(n, m, k));

    }

//    打怪兽：N---怪兽有N滴血，M---每次打击怪兽掉血最大值，K---打击怪兽次数，求击杀怪兽概率

    /**
     * @param n 怪兽有N滴血
     * @param m 每次打击怪兽掉血最大值
     * @param k 打击怪兽次数
     * @return
     */
    public static double normal(int n, int m, int k) {
        if (n <= 0) return 100;
        if (k <= 0 || m <= 0) return 0;

        return recursion(n, m, k) * 100 / Math.pow(m + 1, k);
    }

    private static double recursion(int n, int m, int k) {
        if (k == 0) return n <= 0 ? 1 : 0;

        int ways = 0;
        for (int i = 0; i <= m; i++) {
            ways += recursion(n - i, m, k - 1);
        }
        return ways;
    }


    public static double dp1(int n, int m, int k) {
        if (n <= 0) return 100;
        if (k <= 0 || m <= 0) return 0;

        double[][] dp = new double[n + 1][k + 1];
        dp[0][0] = 1;

        for (int nn = 0; nn < (n + 1); nn++) {
            for (int kk = 1; kk < (k + 1); kk++) {
                int ways = 0;
                for (int i = 0; i <= m; i++) {
                    ways += pick(dp, nn - i, kk - 1, m);
                }
                dp[nn][kk] = ways;
            }
        }
        return dp[n][k] * 100 / Math.pow(m + 1, k);
    }


    public static double pick(double[][] dp, int i, int j, int m) {
        if (i >= 0) {
            return dp[i][j];
        } else {
            if (j >= 0) {
                return Math.pow(m + 1, j);
            } else {
                return 0;
            }
        }
    }


    public static double dp2(int n, int m, int k) {
        if (n <= 0) return 100;
        if (k <= 0 || m <= 0) return 0;

        double[][] dp = new double[n + 1][k + 1];
        dp[0][0] = 1;
        for (int kk = 1; kk < (k + 1); kk++){
            for (int nn = 0; nn < (n + 1); nn++)  {
                dp[nn][kk] = dp[nn][kk -1] +
                        pick(dp,nn-1,kk,m) - pick(dp,nn - m -1,kk - 1,m);
//                        dp[nn -1][kk] - dp[nn - m][kk -1];
            }
        }
        return dp[n][k] * 100 / Math.pow(m+1,k);
    }




}
