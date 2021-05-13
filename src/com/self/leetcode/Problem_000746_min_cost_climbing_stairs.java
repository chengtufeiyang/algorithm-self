package com.self.leetcode;

public class Problem_000746_min_cost_climbing_stairs {

//    Example 1:
//
//    Input: cost = [10,15,20]
//    Output: 15
//    Explanation: Cheapest is: start on cost[1], pay that cost, and go to the top.
//            Example 2:
//
//    Input: cost = [1,100,1,1,1,100,1,1,100,1]
//    Output: 6
//    Explanation: Cheapest is: start on cost[0], and only step on 1s, skipping cost[3].
//             
//
//    Constraints:
//
//            2 <= cost.length <= 1000
//            0 <= cost[i] <= 999
//
//    来源：力扣（LeetCode）
//    链接：https://leetcode-cn.com/problems/min-cost-climbing-stairs
//    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

    public static void main(String[] args) {
        Problem_000746_min_cost_climbing_stairs test = new Problem_000746_min_cost_climbing_stairs();
//        int[] cost = {10,15,20};
        int[] cost = {1,100,1,1,1,100,1,1,100,1};

        System.out.println(test.minCostClimbingStairs(cost));
        System.out.println(test.minCostClimbingStairs2(cost));
    }

    // 最后一个阶梯不是楼顶，坑死人🕳
    public int minCostClimbingStairs(int[] cost) {
        return Math.min(minCostClimbingStairs_recursion(0 , cost) ,
                minCostClimbingStairs_recursion(1 , cost));
    }

    private int minCostClimbingStairs_recursion(int use, int[] cost) {
        if (use == cost.length - 1) return cost[cost.length - 1]; // 最后一步一定到最后一个位置
        if (use == cost.length - 2) return cost[cost.length - 2];

        int temp = minCostClimbingStairs_recursion(use + 1,cost) + cost[use];
        temp = Math.min(minCostClimbingStairs_recursion(use + 2,cost) + cost[use],temp);
        return temp;
    }



    public int minCostClimbingStairs2(int[] cost) {

        int len = cost.length;
        int[] dp = new int[len];

        dp[len - 1] = cost[len - 1];
        dp[len - 2] = cost[len - 2];

        for (int i = len - 3; i >= 0; i--) {
            dp[i] = Math.min(dp[i + 1],dp[i + 2] ) + cost[i];
        }
        return Math.min(dp[0],dp[1]);
    }



    public int minCostClimbingStairs3(int[] cost) {

        int len = cost.length;
//        int[] dp = new int[len];

        int two = cost[len - 1];
        int one = cost[len - 2];
        int temp = 0;
        for (int i = len - 3; i >= 0; i--) {
            temp = Math.min(one,two) + cost[i];
            two = one;
            one = temp;
        }
        return Math.min(one,two);
    }
}
