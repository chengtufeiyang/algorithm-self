package com.self.practice.c03_dp;

import edu.princeton.cs.algs4.In;

import java.util.Arrays;

public class P12_path_min_sum {

    public static void main(String[] args) {

        int rowSize = 10;
        int colSize = 10;
        int[][] m = generateRandomMatrix(rowSize, colSize);
        System.out.println(noral(m));
        System.out.println(dp(m));
        System.out.println(dp2(m));
        System.out.println(minPathSum1(m));

    }
//    -空间压缩：路径最小累加和） 二维数组arr,位置(0，0)，目标位置aim(a,b),只可向下或者向右

    public static int noral(int[][] arr) {
        if (null == arr || arr.length == 0) return -1;
        int result = recursion(arr, 0, 0, arr.length - 1, arr[0].length - 1);
        return result == Integer.MAX_VALUE ? -1 : result;
    }

    private static int recursion(int[][] arr, int curr_a, int curr_b, int a, int b) {
        if (curr_a > a || curr_b > b) return Integer.MAX_VALUE;
        if (curr_a == a && curr_b == b) return arr[curr_a][curr_b];

        return Math.min(recursion(arr, curr_a, curr_b + 1, a, b),
                recursion(arr, curr_a + 1, curr_b, a, b)) + arr[curr_a][curr_b];
    }


    /**
     * 普通二维数组
     * @param arr
     * @return
     */
    public static int dp(int[][] arr) {
        if (null == arr || arr.length == 0) return -1;
        int row = arr.length;
        int col = arr[0].length;
        int[][] dp = new int[row][col];
        dp[row - 1][col - 1] = arr[row - 1][col - 1];
        for (int curr_a = row - 1; curr_a >= 0; curr_a--) {
            for (int curr_b = col - 1; curr_b >= 0; curr_b--) {
                int min = Math.min(pick(dp, row, col, curr_a, curr_b + 1),
                        pick(dp, row, col, curr_a + 1, curr_b));
                dp[curr_a][curr_b] = (min == Integer.MAX_VALUE ? 0 : min)
                        + arr[curr_a][curr_b];
            }
        }
        return dp[0][0];
    }

    public static int pick(int[][] dp, int row, int col, int curr_a, int curr_b) {
        if (curr_a < 0 || curr_b < 0 || curr_a >= row || curr_b >= col) return Integer.MAX_VALUE;

        return dp[curr_a][curr_b];
    }

    /**
     * 优化为一维数组
     * @param arr
     * @return
     */
    public static int dp2(int[][] arr){
        if (null == arr || arr.length == 0) return -1;
        int row = arr.length - 1;
        int col = arr[0].length;
        int[] dp = new int[col + 1];
//        dp[col-1] = arr[arr.length-1][col -1 ];
        for (int i = 0; i <= col; i++) {  // 初始化
            dp[i] = Integer.MAX_VALUE;
        }

        for (int i = col - 1; i  >= 0; i--) {
            int temp = Math.min(dp[i],dp[i + 1]);
            dp[i] = (temp == Integer.MAX_VALUE ? 0 : temp) + arr[row--][i];
        }
        return dp[0];
    }


    // for test
    public static int[][] generateRandomMatrix(int rowSize, int colSize) {
        if (rowSize < 0 || colSize < 0) {
            return null;
        }
        int[][] result = new int[rowSize][colSize];
        for (int i = 0; i != result.length; i++) {
            for (int j = 0; j != result[0].length; j++) {
                result[i][j] = (int) (Math.random() * 100);
            }
        }
        return result;
    }


    public static int minPathSum1(int[][] m) {
        if (m == null || m.length == 0 || m[0] == null || m[0].length == 0) {
            return 0;
        }
        int row = m.length;
        int col = m[0].length;
        int[][] dp = new int[row][col];
        dp[0][0] = m[0][0];
        for (int i = 1; i < row; i++) {
            dp[i][0] = dp[i - 1][0] + m[i][0];
        }
        for (int j = 1; j < col; j++) {
            dp[0][j] = dp[0][j - 1] + m[0][j];
        }
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + m[i][j];
            }
        }
        return dp[row - 1][col - 1];
    }


}
