package com.self.practice.c03_dp;


import com.self.practice.comm_tools.ArraysSelf;

public class P14_bob_go_hell {
    public static void main(String[] args) {

        System.out.println(normal(50,50,6,6,10));
        System.out.println(normalDP(50,50,6,6,10));
    }

//    空间压缩：Bob死亡概率）所在区域（N*M） ,BOB当前位置（row,col）,可以走k步数，区域内活，区域外死亡，
//    可上下左右移动，移动概率相同

    //问题：边界问题，例如：50*50棋盘，下标最大为49 * 49
          // 越界判断问题；横纵坐标有一个越界即为越界
    public static double normal(int n,int m,int row,int col,int k){
        //限制条件判断省略
        // TODO: 3/9/2021
//总次数
        return normalRecusion(n,m,row,col,k)/ Math.pow(4,k);
    }


    private static int normalRecusion(int n, int m, int row, int col, int rest) {
        if (rest ==0)
            return row >=0 && row <n && col >=0 && col < m ? 1 : 0;

        if (row <0 || row >=n || col <0 || col >= m){ //已经越界
            return 0;
        }else {
            // up down left right
            return normalRecusion(n,m,row - 1 ,col,rest - 1)
                    + normalRecusion(n,m,row + 1 ,col,rest - 1)
                    + normalRecusion(n, m, row, col -1 , rest - 1)
                    + normalRecusion(n,m,row,col + 1,rest - 1);
        }
    }


    public static double normalDP(int n,int m,int row,int col,int k){
                //限制条件判断省略
        // TODO: 3/9/2021
        int [][][] dp = new int[n][m][k + 1];
        for (int i = 0; i < n; i++) { //根据base case 初始化数组
            for (int j = 0; j < m; j++) {
                dp[i][j][0] = 1;
            }
        }

        for (int rest = 1; rest <= k; rest++) {
            for (int row_n = 0; row_n < n; row_n++) {
                for (int col_m = 0; col_m < m; col_m++) {
                    dp[row_n][col_m][rest] = ArraysSelf.query(dp,row_n - 1 ,col_m,rest - 1)
                            + ArraysSelf.query(dp,row_n + 1 ,col_m,rest - 1)
                            + ArraysSelf.query(dp, row_n, col_m -1 , rest - 1)
                            + ArraysSelf.query(dp,row_n,col_m + 1,rest - 1);
                    if (row == row_n && col == col_m && rest == k) break;
                }
            }
        }
        return dp[row][col][k]/Math.pow(4,k);
    }





}
