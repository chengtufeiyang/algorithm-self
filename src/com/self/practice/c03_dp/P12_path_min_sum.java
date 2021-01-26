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


        int right = recursion(arr, curr_a, curr_b + 1, a, b);
        int down = recursion(arr, curr_a + 1, curr_b, a, b);
//        if (right != Integer.MAX_VALUE && curr_b + 1 <= b){
//            right += arr[curr_a][curr_b + 1];
//        }
//
//        if (down != Integer.MAX_VALUE){
//            down += curr_a;
//        }
        return Math.min(right, down) + arr[curr_a][curr_b];
    }


    public static int dp(int[][] arr) {
        if (null == arr || arr.length == 0) return -1;
        int row = arr.length;
        int col = arr[0].length;
        int[][] dp = new int[row][col];
        for (int curr_a = col - 1; curr_a >= 0; curr_a--) {
            for (int curr_b = row - 2; curr_b >= 0; curr_b--) {
//                int right = dp[curr_a][curr_b + 1];
//                int down = dp[curr_a + 1][curr_b];
                dp[curr_a][curr_b] = Math.min(pick(dp,row,col,curr_a,curr_b + 1),
                        pick(dp,row,col,curr_a + 1,curr_b)) + arr[curr_a][curr_b];
            }
        }
        return dp[0][0];
    }

    public static int pick(int[][] dp, int row, int col, int curr_a, int curr_b) {
        if (curr_a < 0 || curr_b < 0 || curr_a >= row || curr_b >= col) return Integer.MAX_VALUE;

        return dp[curr_a][curr_b];
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
