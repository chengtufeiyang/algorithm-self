package com.self.practice.c03_dp;

public class P01_left_right_move_target {
    public static void main(String[] args) {

        System.out.println(normal(7,3,8,5));
        System.out.println(dp(7,3,8,5));
        System.out.println("-----------------------");
        System.out.println(normal(4,2,2,4));
        System.out.println(dp(4,2,2,4));

    }

    // N个位置（N>=2）,M位置（开始位置 1=<M <= N）,K步（M可以左右移动的总步数），P位置(结束位置 1=<P <= N)
    // 移至目标位置共有多少种方法

    /**
     *
     * @param n  共多少位置
     * @param m  开始处于位置
     * @param k  可以移动多少步
     * @param p  移动目标位置
     * @return
     */
    public static int normal(int n,int m,int k,int p){
        if (m<=0 || m >n || k <0 || p <=0 || p > n || n <0)return 0;
        return process(n,m,k,p);
    }

    /**
     *
     * @param n
     * @param curr 当前位置
     * @param rest 剩余步数
     * @param p
     * @return
     */
    public static int process(int n,int curr,int rest,int p){
        if (curr <=0 || curr >=n+1) return 0;
        if (rest==0){
            return curr==p ? 1:0;
        }
        int left = process(n,curr-1,rest-1,p);//向左移动可获取多少种方法
        int right = process(n,curr+1,rest-1,p);//向右移动可获取多少种方法
        return left + right;
    }

    /**
     * dp方法
     * @param n  共多少位置
     * @param m  开始处于位置
     * @param k  可以移动多少步
     * @param p  移动目标位置
     * @return
     */
    public static int dp(int n,int m,int k,int p){
        if (m<=0 || m >n || k <0 || p <=0 || p > n || n <0)return 0;
        int[][] dp = new int[n+1][k+1];
        dp[p][0] = 1; // 剩余步骤为0，当前位置即为目标位置
        boolean flag = false;  //标记是否可以结束统计
            for (int j = 1; j <= k; j++) {  //步数范围只能是 0-k，0的情况已做初始化
                for (int i = 1; i <= n; i++){ //位置范围只能是1-n
                    dp[i][j] = sumInAndOut(dp,i-1,j-1,i+1,j-1);
                    if(i==m && j == k){
                        flag=true;
                        break;
                    }
                }
                if (flag){//为true说明已经统计到需要数值，可以跳出循环
                    break;
                }
            }

        return dp[m][k];
    }

    public static int sumInAndOut(int[][] dp,int a,int b,int c,int d){
        int lenRow = dp.length-1;
        int lenCol = dp[0].length-1;
        int result = 0;

        if (a >=0 && a <= lenRow && b >=0 && b <= lenCol) {
            result += dp[a][b];
        }
        if (c >=0 && c <= lenRow && d >=0 && d <= lenCol) {
            result += dp[c][d];
        }

        return result;
    }


}
