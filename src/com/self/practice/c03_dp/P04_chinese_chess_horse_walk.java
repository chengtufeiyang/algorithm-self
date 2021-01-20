package com.self.practice.c03_dp;

import java.util.Arrays;

public class P04_chinese_chess_horse_walk {

    public static void main(String[] args) {
        System.out.println(pos.length);

        int x = 7;
        int y = 7;
        int step = 10;
        System.out.println(normal(x,y,step));
        System.out.println(dp(x,y,step));

    }






    public static int[][] pos = new int[8][2];
    static {
        pos[0] = new int[]{2,-1};
        pos[1] = new int[]{2,1};
        pos[2] = new int[]{1,2};
        pos[3] = new int[]{-1,2};
        pos[4] = new int[]{-2,1};
        pos[5] = new int[]{-2,-1};
        pos[6] = new int[]{-1,-2};
        pos[7] = new int[]{1,-2};
    }

//    象棋问题（左下角（0，0），横线9条，纵坐标10条，左边位置（x,y），步数k,返回“马”从（0，0）位置处方，
//    必须走k步最后落在（x,y）位置的方法）

    /**
     *
     * @param x  目标位置横坐标
     * @param y  目标位置纵坐标
     * @param k  步数
     * @return
     */
    public static int normal(int x,int y,int k){
        if(x <0 || x >= 9 || y <0 || y >=10  || k < 0)
            return 0;
        return recursion(0,0,x,y,k);
    }

    private static int recursion(int curr_row, int curr_clo, int x, int y, int rest) {

        if (curr_row <0 || curr_row >= 9 || curr_clo <0 || curr_clo >=10) return 0;

        if (rest == 0){
            return  (curr_row==x && curr_clo == y) ? 1 :0;
        }

        int ways = 0;
        for (int i = 0; i < pos.length; i++) {
            ways += recursion(curr_row + pos[i][0],curr_clo + pos[i][1],x,y,rest -1);
        }
        return ways;
    }


    public static int dp(int x,int y,int k){
        if(x <0 || x >= 9 || y <0 || y >=10  || k < 0)
            return 0;
        int[][][] dp = new int[9][10][k+1];
        dp[x][y][0] = 1;
        for (int rest = 1; rest < k+1; rest++) {
            for (int curr_row = 0; curr_row < 9; curr_row++) {
                for (int curr_clo = 0; curr_clo < 10; curr_clo++) {
                    int ways = 0;
                    for (int i = 0; i < pos.length; i++) {
                        ways += pick(dp,curr_row + pos[i][0],curr_clo + pos[i][1],rest -1);
                    }
                    dp[curr_row][curr_clo][rest] = ways;
                }
            }
        }
        return dp[0][0][k];
    }


    public static int pick(int[][][] dp,int x,int y,int k){
        if(x <0 || x >= 9 || y <0 || y >=10  || k < 0)
            return 0;
        return dp[x][y][k];
    }

}
