package com.self.leetcode;

import java.util.Arrays;
import java.util.Map;

public class Problem_001269_number_of_ways_to_stay_in_the_same_place_after_some_steps {


    public static void main(String[] args) {
        Problem_001269_number_of_ways_to_stay_in_the_same_place_after_some_steps test = new Problem_001269_number_of_ways_to_stay_in_the_same_place_after_some_steps();


//        int steps = 3, arrLen = 2;
//        int steps = 2, arrLen = 4;
//        int steps = 4, arrLen = 2;
//        int steps = 27 , arrLen = 7;
//        int steps = 47 , arrLen = 38;
        int steps = 430, arrLen =        148488;

        System.out.println(test.numWays(steps,arrLen));
        System.out.println(test.numWays2(steps,arrLen));
        System.out.println(test.numWays3(steps,arrLen));

//        System.out.println(Math.pow(10,9)+ 7);

    }



//    example 1:
//
//    Input: steps = 3, arrLen = 2
//    Output: 4
//    Explanation: There are 4 differents ways to stay at index 0 after 3 steps.
//            Right, Left, Stay
//            Stay, Right, Left
//    Right, Stay, Left
//            Stay, Stay, Stay
//    Example 2:
//
//    Input: steps = 2, arrLen = 4
//    Output: 2
//    Explanation: There are 2 differents ways to stay at index 0 after 2 steps
//            Right, Left
//    Stay, Stay
//    Example 3:
//
//    Input: steps = 4, arrLen = 2
//    Output: 8
//             
//
//    Constraints:
//
//            1 <= steps <= 500
//            1 <= arrLen <= 10^6
//
//    来源：力扣（LeetCode）
//    链接：https://leetcode-cn.com/problems/number-of-ways-to-stay-in-the-same-place-after-some-steps
//    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
    public int numWays(int steps, int arrLen) {
        //  left right stay
        // 注意第一个位置，和最后一个位置情况 判断
        long[][]  dp = new long[steps + 1][arrLen + 1];
        for (int i = 0; i <= steps; i++) {
            Arrays.fill(dp[i],-1);
        }
        return (int)(numWays_recursion(1,steps,Math.min(arrLen,steps),dp) % (Math.pow(10,9) + 7));
    }

    /**
     *
     * @param curr      当前位置，从1开始
     * @param steps     剩余选择步数
     * @param arrLen    整体长度
     * @return
     */
    private long numWays_recursion(int curr, int steps, int arrLen,long[][]  dp ) {
        if (steps == 0){
            return curr == 1 ? 1 : 0;
        }
        if (dp[steps][curr] != -1) return dp[steps][curr];
        if (curr == 1){
            dp[steps][curr] = numWays_recursion(curr,steps - 1,arrLen,dp) + numWays_recursion(curr + 1,steps - 1,arrLen,dp);
            dp[steps][curr]  =    dp[steps][curr]  % (long)(Math.pow(10,9) + 7);

        }else if (curr == arrLen){
            dp[steps][curr] =  numWays_recursion(curr,steps - 1,arrLen,dp) +
                   numWays_recursion(curr - 1,steps - 1,arrLen,dp) ;
            dp[steps][curr]  =    dp[steps][curr]  % (long)(Math.pow(10,9) + 7);
        }else {
            dp[steps][curr] =  numWays_recursion(curr,steps - 1,arrLen,dp) +
                   numWays_recursion(curr + 1,steps - 1,arrLen ,dp)+
                   numWays_recursion(curr - 1,steps - 1,arrLen,dp);
            dp[steps][curr]  =    dp[steps][curr]  % (long)(Math.pow(10,9) + 7);
        }
        return  dp[steps][curr];
    }



    public int numWays2(int steps, int arrLen) {
        //  left right stay
        // 注意第一个位置，和最后一个位置情况 判断
        arrLen = Math.min(arrLen,steps);

        long[][]  dp = new long[arrLen + 1][steps + 1];
        dp[1][0] = 1;// 根据base case
        for (int col = 1; col <= steps; col++) {

            for (int row = arrLen; row >= 1; row--) {

                if (row == 1){
                    dp[row][col] = dp[row][col - 1] + dp[row + 1][col - 1];

                }else if (row == arrLen){
                    dp[row][col] =dp[row][col - 1] +
                            dp[row - 1][col - 1];
                }else {
                    dp[row][col] =dp[row][col - 1] +
                            dp[row + 1][col - 1]+
                            dp[row - 1][col - 1];
                }

                dp[row][col] =  dp[row][col] % (long)(Math.pow(10,9) + 7);

            }
        }
        return (int)(dp[1][steps]);
    }


    final int MODULO = 1000000007;
    public int numWays3(int steps, int arrLen) {
        //  left right stay
        // 注意第一个位置，和最后一个位置情况 判断
        arrLen = Math.min(arrLen,steps/2 + 1);

        long[][]  dp = new long[arrLen + 1][2];
        dp[1][0] = 1;// 根据base case    0列已设置完成
        int curr = 0;
        int pre = 1;
        for (int col = 1; col <= steps; col++) {
            pre = curr;
            curr ^= 1; // 明确需设置列
            for (int row = arrLen; row >= 1; row--) {

                if (row == 1){
                    dp[row][curr] = dp[row][pre] + dp[row + 1][pre];

                }else if (row == arrLen){
                    dp[row][curr] =dp[row][pre] +
                            dp[row - 1][pre];
                }else {
                    dp[row][curr] =dp[row][pre] +
                            dp[row + 1][pre]+
                            dp[row - 1][pre];
                }

                dp[row][curr] =  dp[row][curr] % MODULO;
            }
        }
        return (int)(dp[1][curr]);
    }

}
