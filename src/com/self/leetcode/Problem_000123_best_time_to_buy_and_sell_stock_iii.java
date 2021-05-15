package com.self.leetcode;

import com.wz.array.ArraysSelf;
import com.wz.array.GenerateArray;

import java.util.Arrays;

public class Problem_000123_best_time_to_buy_and_sell_stock_iii {

    public static void main(String[] args) {
        Problem_000123_best_time_to_buy_and_sell_stock_iii test = new Problem_000123_best_time_to_buy_and_sell_stock_iii();

//        int[] prices = {3,3,5,0,0,3,1,4};
//        int[] prices = {1,2,3,4,5};
//        int[] prices = {7, 6, 4, 3, 1};
//        int[] prices = {1};
//        int[] prices = {3,3,5,0,0,3,1,4,1,5,4,9,0,1,2,3,4,5,7,3,9,1,7,5,0,1,4,3,5,0,0,3,1,4,1,5,4,9,0,1,2,3,4,5,7,3,9,1,7,5,0,1,4};
        int[] prices = {1,4,2};
        System.out.println(test.maxProfit(prices));
        System.out.println(test.maxProfit2(prices));

//        for (int i = 0; i < 10000; i++) {
//            int[] arr = GenerateArray.generateRandomArray(100,100);
//            int val0 = test.maxProfit(arr);
//            int val1 = test.maxProfit2(arr);
//            if (val0 != val1){
//                System.out.println(Arrays.toString(arr));
//                System.out.println(String.format("val0:%d,val1:%d",val0,val1));
//            }
//        }


    }


    //    Example 1:
//
//    Input: prices = [3,3,5,0,0,3,1,4]
//    Output: 6
//    Explanation: Buy on day 4 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.
//    Then buy on day 7 (price = 1) and sell on day 8 (price = 4), profit = 4-1 = 3.
//    Example 2:
//
//    Input: prices = [1,2,3,4,5]
//    Output: 4
//    Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
//    Note that you cannot buy on day 1, buy on day 2 and sell them later, as you are engaging multiple transactions at the same time. You must sell before buying again.
//    Example 3:
//
//    Input: prices = [7,6,4,3,1]
//    Output: 0
//    Explanation: In this case, no transaction is done, i.e. max profit = 0.
//    Example 4:
//
//    Input: prices = [1]
//    Output: 0
//             
//
//    Constraints:
//
//            1 <= prices.length <= 105
//            0 <= prices[i] <= 105
//
//    来源：力扣（LeetCode）
//    链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iii
//    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len == 1) return 0;

        int result = maxProfit_recursion(prices, 0, 2, true);
        return result < 0 ? 0 : result;
    }

    // 执行卖出操作后 -1
    private int maxProfit_recursion(int[] prices, int currIndex, int used, boolean flag) {
        if (used == 0) return 0;
        if (currIndex == prices.length) return 0;
        int temp = Integer.MIN_VALUE >> 1;
        int tempLen = prices.length - currIndex;
        if (flag) { // 买
            if (tempLen == 1) {
                return 0;
            } else if (tempLen == 2) {
                return Math.max(0,prices[currIndex + 1] - prices[currIndex]);
            } else {
                temp = Math.max(temp, maxProfit_recursion(prices, currIndex + 1, used, flag ? false : true) - prices[currIndex]);
                temp = Math.max(temp, maxProfit_recursion(prices, currIndex + 1, used, flag));
                return temp;
            }
        } else { // 卖
            if (tempLen == 1) {
                return prices[currIndex];
            } else {
                return Math.max(maxProfit_recursion(prices, currIndex + 1, used - 1, flag ? false : true) + prices[currIndex],
                        maxProfit_recursion(prices, currIndex + 1, used, flag));
            }
        }
    }

    public int maxProfit2(int[] prices) {
        int len = prices.length;
        if (len == 1) return 0;

        int[][][] dp = new int[len + 1][3][2];// 坐标，可使用事务次数， 0  卖，1  买

        for (int currIndex = len - 1; currIndex >= 0; currIndex--) {

            for (int used = 1; used < 3; used++) {

                for (int flag = 0; flag < 2; flag++) { // 0-true   1-false

                    int temp = Integer.MIN_VALUE >> 1;
                    int tempLen = prices.length - currIndex;
                    if (flag == 0) { // 买
                        if (tempLen == 1) {
                            temp = 0;
                        } else if (tempLen == 2) {
                            temp = Math.max(0,prices[currIndex + 1] - prices[currIndex]);
                        } else {
                            temp = Math.max(temp, dp[ currIndex + 1][ used][ flag == 0 ? 1 : 0] - prices[currIndex]);
                            temp = Math.max(temp, dp[ currIndex + 1][used][flag]);

                        }
                    } else { // 卖
                        if (tempLen == 1) {
                            temp = prices[currIndex];
                        } else {
                            temp = Math.max(dp[ currIndex + 1][ used - 1][ flag == 0 ? 1 : 0] + prices[currIndex],
                                    dp[ currIndex + 1][ used][ flag]);
                        }
                    }
                    dp[currIndex][used][flag] = temp;
                }
            }
        }

        return dp[0][2][0] < 0 ? 0 : dp[0][2][0];
    }



    // 官方题解 todo
//    由于我们最多可以完成两笔交易，因此在任意一天结束之后，我们会处于以下五个状态中的一种：
//
//    未进行过任何操作；
//
//    只进行过一次买操作；
//
//    进行了一次买操作和一次卖操作，即完成了一笔交易；
//
//    在完成了一笔交易的前提下，进行了第二次买操作；
//
//    完成了全部两笔交易。
//
//    作者：LeetCode-Solution
//    链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iii/solution/mai-mai-gu-piao-de-zui-jia-shi-ji-iii-by-wrnt/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

}
