package com.self.leetcode;

import java.util.Arrays;

public class Problem_001011_capacity_to_ship_packages_within_d_days {

    public static void main(String[] args) {
        Problem_001011_capacity_to_ship_packages_within_d_days test = new Problem_001011_capacity_to_ship_packages_within_d_days();
//        int[] weights = {1,2,3,4,5,6,7,8,9,10};
//        int D = 5;

//        int[] weights = {3,2,2,4,1,4};
//        int D = 3;

        int[] weights = {1,2,3,1,1};
        int D = 4;

        System.out.println(test.shipWithinDays(weights,D));
        System.out.println(test.shipWithinDays2(weights,D));
    }

//
//    1 <= D <= weights.length <= 50000
//            1 <= weights[i] <= 500

//    https://leetcode-cn.com/problems/capacity-to-ship-packages-within-d-days/


//    A conveyor belt has packages that must be shipped from one port to another within D days.
//
//    The ith package on the conveyor belt has a weight of weights[i]. Each day,
//    we load the ship with packages on the conveyor belt (in the order given by weights).
//    We may not load more weight than the maximum weight capacity of the ship.
//
//    Return the least weight capacity of the ship that will result in all the packages on the conveyor belt being shipped within D days.
//
//
//    Example 1:
//
//    Input: weights = [1,2,3,4,5,6,7,8,9,10], D = 5
//    Output: 15
//    Explanation: A ship capacity of 15 is the minimum to ship all the packages in 5 days like this:
//            1st day: 1, 2, 3, 4, 5
//            2nd day: 6, 7
//            3rd day: 8
//            4th day: 9
//            5th day: 10
//
//    Note that the cargo must be shipped in the order given,
//    so using a ship of capacity 14 and splitting the packages into parts like (2, 3, 4, 5), (1, 6, 7), (8), (9), (10) is not allowed.
//            Example 2:
//
//    Input: weights = [3,2,2,4,1,4], D = 3
//    Output: 6
//    Explanation: A ship capacity of 6 is the minimum to ship all the packages in 3 days like this:
//            1st day: 3, 2
//            2nd day: 2, 4
//            3rd day: 1, 4
//    Example 3:
//
//    Input: weights = [1,2,3,1,1], D = 4
//    Output: 3
//    Explanation:
//            1st day: 1
//            2nd day: 2
//            3rd day: 3
//            4th day: 1, 1
//             
//
//    Constraints:
//
//            1 <= D <= weights.length <= 5 * 104
//            1 <= weights[i] <= 500

    /**
     * 暴力解法：从最小可能为结果的承载量，进行验证，逐渐递增，一定可以找到最终结果，最大值限定为数组中所有数据的和
     * @param weights
     * @param D
     * @return
     */
    public int shipWithinDays(int[] weights, int D) {

        int len = weights.length;// 数组长度
        int sum = 0;
        int max = 0;
        for (int i = 0; i < len; i++) {
            sum += weights[i];
            max = Math.max(max,weights[i]);
        }
        int avg =Math.max(sum / D  +  (sum % D == 0 ? 0 : 1),max);


        while (avg <= sum){
            int count = D;
            int tempVal = avg;
            for (int i = 0; i < len; i++) {
                if (tempVal < weights[i]){
                    count--;
                    tempVal = avg - weights[i];
                }else {
                    tempVal -= weights[i];
                }
            }
            if (count >= 1) return avg;
            avg++;
        }
        return -1;
    }


    public int shipWithinDays2(int[] weights, int D) {

        int len = weights.length;// 数组长度

        int right = Arrays.stream(weights).sum();//流方法获取数组和
        int left = Arrays.stream(weights).max().getAsInt();// 流方法获取一维数组中最大值

        int result = 0;
        while (left <= right){
            int count = D;
            int tempVal = left + (right - left) / 2; // 二分法思想
            for (int i = 0; i < len; i++) {
                if (tempVal < weights[i]){
                    count--;
                    tempVal = (left + (right - left) / 2) - weights[i];
                }else {
                    tempVal -= weights[i];
                }
            }
            if (count >= 1) result =left + (right - left) / 2;

            if (count <1){
                left = left + (right - left) / 2 + 1;
            }else {
                right = left + (right - left) / 2 - 1;
            }
        }
        return result;
    }
}


