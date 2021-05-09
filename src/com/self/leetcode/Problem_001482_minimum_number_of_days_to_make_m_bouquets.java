package com.self.leetcode;

import java.util.Arrays;

public class Problem_001482_minimum_number_of_days_to_make_m_bouquets {
    public static void main(String[] args) {
        Problem_001482_minimum_number_of_days_to_make_m_bouquets test = new Problem_001482_minimum_number_of_days_to_make_m_bouquets();

//        int[] bloomDay = {1, 10, 3, 10, 2};
//        int m = 3, k = 1;

//        int[] bloomDay = {1,10,3,10,2};
//        int m = 3, k = 2;

//        int[] bloomDay = {7,7,7,7,12,7,7};
//        int m = 2, k = 3;
//        int [] bloomDay ={1,10,2,9,3,8,4,7,5,6};
//        int m = 4 , k = 2;


        int[] bloomDay = {1542,5142,4695,4385,2629,2492,933,1068,151,3960,3790,1196,3842,5147,5526,5528,2259,1708,2714,5462,3016,3262,1175,4348,4826,80,789,5285,3855,3455,3480,4277,648,1748,625,4256,3931,4938,4553,2129,4480,824,3048,2383,3036,2192,2156,7,438,5258,2430,2459,3769,1694,1687,5130,70,3219,4140,2341,1159,3952,4934,4335,2786,3124,5344,803,4586,1000,2821,4769,629,4673,3920,3437,4533,2984,3576,5364,1255,1876,2309,5619,2402,1978,4127,1668,147,4139,292,1499,1786,2435,1988,146,500,3377,3789,1301,1193,1686,3501,3895,1321,1587,4263,593,1580,3652,1638,4905,1927,567,2797,2082,1349,4158,679,4944,4638,4770,3458,2117,2620,938,4121,2374,1478,5269,5548,5125,5237,1693,2188,690,4640,827,2721,2329,430,4423,5510,2312,2493,4884,223,1904,4660,5124,2851,5227,4160,694,5660,5571,834,1704,4550,988,573,3373,5419,311,4280,399,5319,4723,5467,1155,4267,303,4233,770,3087,3306,1042,4192,3736,893,5087,1903,3650,393,5304,2767,3562,5501,4789,1863,1653,2528,5521,3802,3925,2718,5402,2642,304,4171,4356,5486,1426,4526,4541,4310,2160,4542,2850,2396,1612,4780,3921,5219,2585,4027,1861,3799,101,1434,996,203,1216,1654,4382,3791,3417,1912,5337,814,352,3892,3851,3432,2400};
        int m = 49;
        int k = 4;

        System.out.println(test.minDays2(bloomDay, m, k));
    }
//    Given an integer array bloomDay, an integer m and an integer k.
//
//    We need to make m bouquets. To make a bouquet, you need to use k adjacent flowers from the garden.
//
//    The garden consists of n flowers, the ith flower will bloom in the bloomDay[i] and then can be used in exactly one bouquet.
//
//    Return the minimum number of days you need to wait to be able to make m bouquets from the garden. If it is impossible to make m bouquets return -1.
//
//             
//
//    Example 1:
//
//    Input: bloomDay = [1,10,3,10,2], m = 3, k = 1
//    Output: 3
//    Explanation: Let's see what happened in the first three days. x means flower bloomed and _ means flower didn't bloom in the garden.
//    We need 3 bouquets each should contain 1 flower.
//    After day 1: [x, _, _, _, _]   // we can only make one bouquet.
//    After day 2: [x, _, _, _, x]   // we can only make two bouquets.
//    After day 3: [x, _, x, _, x]   // we can make 3 bouquets. The answer is 3.
//    Example 2:
//
//    Input: bloomDay = [1,10,3,10,2], m = 3, k = 2
//    Output: -1
//    Explanation: We need 3 bouquets each has 2 flowers, that means we need 6 flowers. We only have 5 flowers so it is impossible to get the needed bouquets and we return -1.
//    Example 3:
//
//    Input: bloomDay = [7,7,7,7,12,7,7], m = 2, k = 3
//    Output: 12
//    Explanation: We need 2 bouquets each should have 3 flowers.
//            Here's the garden after the 7 and 12 days:
//    After day 7: [x, x, x, x, _, x, x]
//    We can make one bouquet of the first three flowers that bloomed. We cannot make another bouquet from the last three flowers that bloomed because they are not adjacent.
//    After day 12: [x, x, x, x, x, x, x]
//    It is obvious that we can make two bouquets in different ways.
//    Example 4:
//
//    Input: bloomDay = [1000000000,1000000000], m = 1, k = 1
//    Output: 1000000000
//    Explanation: You need to wait 1000000000 days to have a flower ready for a bouquet.
//    Example 5:
//
//    Input: bloomDay = [1,10,2,9,3,8,4,7,5,6], m = 4, k = 2
//    Output: 9
//             
//
//    Constraints:
//
//    bloomDay.length == n
//1 <= n <= 10^5
//            1 <= bloomDay[i] <= 10^9
//            1 <= m <= 10^6
//            1 <= k <= n
//
//    来源：力扣（LeetCode）
//    链接：https://leetcode-cn.com/problems/minimum-number-of-days-to-make-m-bouquets
//    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

    int result = 0;
    int[][]  preArray = null;
    public int minDays(int[] bloomDay, int m, int k) {
        int len = bloomDay.length; // 所有花的数量
        if (m * k > len) return -1; // 如果花的数量 < 需要数量  ,则无意义
        int maxArray = Arrays.stream(bloomDay).max().getAsInt();
        if (m * k == len) return maxArray; // 如果花的数量 == 需要数量 因为存在花朵必须连续的条件，直接返回最大值即可
        preArray = maxVal(bloomDay);
        //  可知结果范围为
        result = maxArray;
        minDays_recursion(bloomDay, m, k, 0, 0, 0);
        return result;
    }

    /**
     * @param bloomDay
     * @param m
     * @param k
     * @param num       已经选择了几束花
     * @param currIndex 当前可选位置
     * @param currMax   当前已确定满足条件的最大时间
     */
    private void minDays_recursion(int[] bloomDay, int m, int k, int num, int currIndex, int currMax) {

        if (num == m) { // 花束已经选择完成
            result = Math.min(currMax,result);
            return;
        }

        int rest = m * k - num * k; // 全部需要花朵数量 - 剩余需要花朵数量
        int len = bloomDay.length;
        if (len - currIndex < rest) { // 剩余花朵不足以支撑满足剩余花束的条件，因此为无效路径
            return;
        }

        for (int i = currIndex; i < len && (i + k - 1) < len && (m - num) * k <= (len - i ) ; i++) { // 尝试每一个可选择位置

            //如果当前尝试范围内的最大值已是后续过程中的最大值，则无需进行后续判断,直接结束此流程
            if (preArray[i][i + k - 1] >= preArray[i][len - 1]){
                minDays_recursion(bloomDay,m,k,m,i  + k,Math.max(currMax,preArray[i][i + k - 1]));
            }else {
                minDays_recursion(bloomDay,m,k,num + 1,i  + k,Math.max(currMax,preArray[i][i + k - 1]));
            }
        }
    }



    public int[][] maxVal(int[] bloomDay){

        int len = bloomDay.length;
        int[][]  result = new int[len][len]; // 只填上半区域即可

        for (int i = 0; i < len; i++) {
            result[i][i] = bloomDay[i];
        }


        for (int i = 0; i < len; i++) {
            int curr = bloomDay[i]; // 当前值
            for (int j = i + 1; j < len; j++) {
                curr = Math.max(curr,bloomDay[j]);
                result[i][j] = curr;
            }
        }
        return result;
    }




    public int minDays2(int[] bloomDay, int m, int k) {
        int len = bloomDay.length; // 所有花的数量
        if (m * k > len) return -1; // 如果花的数量 < 需要数量  ,则无意义
        int maxArray = Arrays.stream(bloomDay).max().getAsInt();
        if (m * k == len) return maxArray; // 如果花的数量 == 需要数量 因为存在花朵必须连续的条件，直接返回最大值即可
        int minArray = Arrays.stream(bloomDay).min().getAsInt();

        int left = minArray;
        int right = maxArray;


        while (left < right){

            int mid = left + (right - left) / 2;

            if (checkDays(bloomDay,m,k,mid)){
                right = mid;
            }else {
                left = mid + 1;
            }
        }

        return left;
    }

    /**
     * 检查该天数是否满足要求
     * @param bloomDay
     * @param m
     * @param k
     * @param days
     * @return
     */
    private boolean checkDays(int[] bloomDay, int m, int k, int days) {

        int len = bloomDay.length;

        int flowNum = 0;
        int totalNum = 0;

        for (int i = 0; i < len && totalNum < m; i++) {

            if (bloomDay[i] <= days){
                flowNum++;
                if (flowNum == k){ // 构成一束花
                    totalNum ++;
                    flowNum = 0;
                }
            }else {
                flowNum = 0;
            }
        }

        return totalNum >= m;

    }


}
