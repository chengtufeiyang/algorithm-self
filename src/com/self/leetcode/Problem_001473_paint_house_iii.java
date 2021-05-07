package com.self.leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Problem_001473_paint_house_iii {


    public static void main(String[] args) {
        Problem_001473_paint_house_iii test = new Problem_001473_paint_house_iii();
//// 9
//        int[] houses = {0, 0, 0, 0, 0};
//        int[][] cost = {{1, 10}, {10, 1}, {10, 1}, {1, 10}, {5, 1}};
//        int m = 5, n = 2, target = 3;

//// -1
//        int[] houses = {3, 1, 2, 3};
//        int[][] cost = {{1, 1,1}, {1, 1,1}, {1, 1,1}, {1, 1,1}, {1, 1,1}};
//        int m = 4, n = 3, target = 3;

////  5
//        int[] houses = {0, 0, 0, 0, 0};
//        int[][] cost = {{1, 10}, {10, 1}, {1, 10}, {10, 1}, {1, 10}};
//        int m = 5, n = 2, target = 5;

//// 6
//        int[] houses = {0, 0};
//        int[][] cost = {{1, 10}, {5, 1}};
//        int m = 2, n = 2, target = 1;

// 11
        int[] houses = {0, 2, 1, 2, 0};
        int[][] cost = {{1, 10}, {10, 1}, {10, 1}, {1, 10}, {5, 1}};
        int m = 5, n = 2, target = 3;


//        // //  4
//       int[] houses = {0,0,0,3};
//        int[][] cost = {{2,2,5},{1,5,5},{5,1,2},{5,2,5}};
//        int m = 4, n = 3,target = 3;

        System.out.println("final:" + test.minCost(houses, cost, m, n, target));
        System.out.println("final2:" + test.minCost2(houses, cost, m, n, target));
        System.out.println("final3:" + test.minCost3(houses, cost, m, n, target));
    }


//    There is a row of m houses in a small city, each house must be painted with one of the n colors (labeled from 1 to n),
//    some houses that have been painted last summer should not be painted again.
//
//    A neighborhood is a maximal group of continuous houses that are painted with the same color.
//
//    For example: houses = [1,2,2,3,3,2,1,1] contains 5 neighborhoods [{1}, {2,2}, {3,3}, {2}, {1,1}].
//    Given an array houses, an m x n matrix cost and an integer target where:
//
//    houses[i]: is the color of the house i, and 0 if the house is not painted yet.
//    cost[i][j]: is the cost of paint the house i with the color j + 1.
//    Return the minimum cost of painting all the remaining houses in such a way that there are exactly target neighborhoods. If it is not possible, return -1.
//

//    m == houses.length == cost.length
//    n == cost[i].length
//1 <= m <= 100
//            1 <= n <= 20
//            1 <= target <= m
//0 <= houses[i] <= n
//1 <= cost[i][j] <= 10^4
//    来源：力扣（LeetCode）
//    链接：https://leetcode-cn.com/problems/paint-house-iii
//    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

    int result = -1;

    public int minCost(int[] houses, int[][] cost, int m, int n, int target) {
        if (m == 1 && target != 1) return -1;
        minCost_recursion(houses, cost, target, 0, 0, 0, 0);
        return result;
    }

    /**
     * @param houses  房子数组
     * @param cost    不同位置房子的粉刷不同颜色的成本
     * @param target  目标划分区域
     * @param index   当前需粉刷位置（实际是否需要粉刷-待定）
     * @param preClor 前一个位置粉刷颜色
     * @param preNum  当前位置之前部分划分区域
     * @param preCost 当前位置之前的消耗成本
     * @return
     */
    private int minCost_recursion(int[] houses, int[][] cost, int target, int index, int preClor, int preNum, int preCost) {
        if (index == houses.length) {
//            if (preNum == target) System.out.println(String.format("target:%d,preNum:%d,preCost:%d",target,preNum,preCost));
            int temp = preNum == target ? preCost : -1; // 如果已到结尾，且划分区域与要求相同，则返回此刻消耗，否则，此情况无法满足要求
            result = result == -1 || temp == -1 ? Math.max(result, temp) : Math.min(result, temp);
            return temp;
        }
        if (target - preNum > houses.length - index)
            return -1; //如果剩余房子数量，每个都涂抹不同颜色，都不够满足target要求，则无需进行后续判断，直接返回无法满足要求即可
        // 以下分析划分区域 < target ,且仍有房子待粉刷情况


        //首先判断当前位置是否需要进行颜色选择
        if (houses[index] > 0) { // 已经粉刷过，无成本消耗
            return minCost_recursion(houses, cost, target, index + 1, houses[index],
                    index - 1 >= 0 ? (houses[index] == preClor ? preNum : preNum + 1) : 1
                    , preCost);
        } else {
            // 选择和前一个相同的颜色的消耗
            int same = -1;
            if (preClor > 0) {
                same = minCost_recursion(houses, cost, target, index + 1, preClor, preNum, preCost + cost[index][preClor - 1]);
            }

            // 选择和前一个不同的颜色的消耗
            int diff = -1;
            int n = cost[0].length;
            for (int i = 0; i < n; i++) {
                if (i + 1 != preClor) { // 排除上一个已选择颜色
                    int temp = minCost_recursion(houses, cost, target, index + 1, i + 1, preNum + 1, preCost + cost[index][i]);
                    diff = diff == -1 ? temp : Math.min(diff, temp);
                }
            }


//            System.out.println(String.format("index:%d,preColor:%d,preNum:%d,preCost:%d,same:%d,diff:%d",
//                    index,preClor,preNum,preCost,same,diff));
            return same == -1 || diff == -1 ? Math.max(same, diff) : Math.min(same, diff); // 如果存在不可达情况，则取最小成本消耗（最大值）；如果两种方式都可达，则取最小成本消耗（最小值）
        }
    }


    Map<String, Integer> map = new HashMap<>();
    int result2 = -1;

    public int minCost2(int[] houses, int[][] cost, int m, int n, int target) {
        if (m == 1 && target != 1) return -1;
        minCost_recursion2(houses, cost, target, 0, 0, 0, 0);
        return result2;
    }

    /**
     * @param houses  房子数组
     * @param cost    不同位置房子的粉刷不同颜色的成本
     * @param target  目标划分区域
     * @param index   当前需粉刷位置（实际是否需要粉刷-待定）
     * @param preClor 前一个位置粉刷颜色
     * @param preNum  当前位置之前部分划分区域
     * @param preCost 当前位置之前的消耗成本
     * @return
     */
    private int minCost_recursion2(int[] houses, int[][] cost, int target, int index, int preClor, int preNum, int preCost) {
        if (index == houses.length) {
            int temp = preNum == target ? preCost : -1; // 如果已到结尾，且划分区域与要求相同，则返回此刻消耗，否则，此情况无法满足要求
            result2 = result2 == -1 || temp == -1 ? Math.max(result2, temp) : Math.min(result2, temp);
            return temp;
        }
        if (target - preNum > houses.length - index)
            return -1; //如果剩余房子数量，每个都涂抹不同颜色，都不够满足target要求，则无需进行后续判断，直接返回无法满足要求即可
        // 以下分析划分区域 <= target ,且仍有房子待粉刷情况


        String flag = index + "_" + preClor + "_" + preNum + "_" + preCost;
        if (null != map.get(flag)) {
            return map.get(flag);
        }

        //首先判断当前位置是否需要进行颜色选择
        if (houses[index] > 0) { // 已经粉刷过，无成本消耗

            int temp = minCost_recursion2(houses, cost, target, index + 1, houses[index],
                    index - 1 >= 0 ? (houses[index] == preClor ? preNum : preNum + 1) : 1
                    , preCost);
            map.put(flag, temp);
            return temp;
        } else {
            // 选择和前一个相同的颜色的消耗
            int same = -1;
            if (preClor > 0) {
                same = minCost_recursion2(houses, cost, target, index + 1, preClor, preNum, preCost + cost[index][preClor - 1]);
            }

            // 选择和前一个不同的颜色的消耗
            int diff = -1;
            int n = cost[0].length;
            for (int i = 0; i < n; i++) {
                if (i + 1 != preClor) { // 排除上一个已选择颜色
                    int temp = minCost_recursion2(houses, cost, target, index + 1, i + 1, preNum + 1, preCost + cost[index][i]);
                    diff = diff == -1 ? temp : Math.min(diff, temp);
                }
            }

            int temp = same == -1 || diff == -1 ? Math.max(same, diff) : Math.min(same, diff); // 如果存在不可达情况，则取最小成本消耗（最大值）；如果两种方式都可达，则取最小成本消耗（最小值）
            map.put(flag, temp);
            return temp;
        }
    }


    int def = Integer.MAX_VALUE >> 1;

    public int minCost3(int[] houses, int[][] cost, int m, int n, int target) {
        if (m == 1 && target != 1) return -1;



        int[][][] dp = new int[m + 1][n + 1][target + 1];//  第几个房间   涂抹颜色   划分区域数量
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                for (int h = 0; h <= target; h++) {
                    dp[i][j][h] = (i == 0 && h == 0 )? 0 : def;//  0间房，0个分区认为其cost为0，实际此值无意义
                 }
            }
        }


        for (int i = 1; i <= m; i++) { // 从第一间房开始

            int color = houses[i - 1];

            for (int j = 1; j <= n; j++) { // 待涂抹颜色从1开始到n结束


                for (int h = 1; h <= i &&  h <= target; h++) { //  划分分区从1开始


                    if (color == 0){ // 未涂抹颜色状态

                        int temp = dp[i - 1][j][h];// 与前一个位置颜色相同

                        for (int j0 = 1; j0 <= n; j0++) {
                            if (j0 != j){
                                temp = Math.min(temp,dp[i - 1][j0][h - 1] );
                            }
                        }

                        dp[i][j][h] = temp + cost[i - 1][j - 1];

                    }else { // 已存在颜色情况
                        if (j == color){
                            int temp = dp[i - 1][color][h];// 与前一个位置颜色相同

                            for (int j0 = 1; j0 <= n; j0++) {
                                if (j != j0){
                                    temp = Math.min(temp,dp[i - 1][j0][h - 1]);
                                }
                            }
                            dp[i][j][h] = temp;
                        }
//                        else {
//                            dp[i][j][h] = def;
//                        }

                    }
                }
            }
        }

        int ans = def;
        for (int i = 1; i <= n; i++) {
            ans = Math.min(ans,dp[m][i][target]);
        }

        return ans == def ? -1 : ans;
    }


    private int maxOfCost(int[][] cost) {

        int max = -1;
        for (int i = 0; i < cost.length; i++) {
            for (int j = 0; j < cost[0].length; j++) {
                max = Math.max(max, cost[i][j]);
            }
        }
        return max;
    }


}
