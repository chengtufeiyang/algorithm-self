package com.self.practice.c03_dp;

import java.util.HashMap;
import java.util.Map;

public class P13_coin_target {

    public static void main(String[] args) {
        int[] arr = {1, 2};
        int aim = 5;
        System.out.println(NoLimitCoin.normal1(arr, aim));
        System.out.println(NoLimitCoin.normal1Dp(arr, aim));
        System.out.println(NoLimitCoin.normalDp2(arr, aim));
        System.out.println("sec----------------------------");
        int[] arr1 = {1, 2, 1, 1, 2, 1, 2};
        int aim1 = 4;
        System.out.println(SameValSameCoin.normal(arr1, aim1));
        System.out.println(SameValSameCoin.normalDp1(arr1, aim1));
        System.out.println(SameValSameCoin.normalDp2(arr1, aim1));

        System.out.println("third----------------------------");
        int[] arr2 = {1, 1, 1};
        int aim2 = 2;
        System.out.println(SameValDiffCoin.normal(arr2,aim2));
        System.out.println(SameValDiffCoin.normalDp(arr2,aim2));

    }

//    （a:硬币面值数组arr,值均为正数，无重复值，每种数值无限量，给定目标数值aim
//    返回可组合成aim的方法数；

//    b:硬币面值数组arr,值均为正数每种数值仅一个，且相同值相同，给定目标数aim，返回方法数，例如：
//    arr{1,2,1,1,2,1,2},aim =4 ,方法数：3种（{1，1，1，1}、{1，1，2}、{2，2}）；

//    c:硬币数组arr,值均为正数，每种数值仅一个，且相同值不同，给定目标数aim,放回方法数，例如：
//    arr{1,1,1},aim=2， 方法数：3种 （{1，1}，{1，1}，{1，1}））


    /**
     * 每种硬币数量无限制模型
     */
    private static class NoLimitCoin {
        public static int normal1(int[] arr, int aim) {
            if (aim < 0 || null == arr || arr.length == 0) return 0;

            return normal1Recursion(arr, 0, aim);
        }

        /**
         * 递归求取正确组合方式
         *
         * @param arr
         * @param currIndex
         * @param aimrest
         * @return
         */
        private static int normal1Recursion(int[] arr, int currIndex, int aimrest) {
//        if (aimrest == 0) return 1;
//        if (currIndex >= arr.length) return 0;
            // 下标值最大值与数组长度相等
            if (currIndex == arr.length) return aimrest == 0 ? 1 : 0;

            int curr = arr[currIndex];
            int result = 0;
            for (int i = 0; i * curr <= aimrest; i++) {//重点步骤，第一次手敲是未使用循环写法，导致无法观察到改写dp方式
                result += normal1Recursion(arr, currIndex + 1, aimrest - i * curr);
            }
            return result;
        }


        /**
         * 无限使用硬币dp方法
         *
         * @param arr
         * @param aim
         * @return
         */
        public static int normal1Dp(int[] arr, int aim) {
            if (aim < 0 || null == arr || arr.length == 0) return 0;
            int len = arr.length;
            int[][] dp = new int[len + 1][aim + 1];
            dp[len][0] = 1;// 根据base case

            for (int i = len - 1; i >= 0; i--) {
                for (int j = 0; j <= aim; j++) {
                    int curr = arr[i];
                    for (int k = 0; k * curr <= j; k++) {//重点步骤，第一次手敲是未使用循环写法，导致无法观察到改写dp方式
                        dp[i][j] += dp[i + 1][j - k * curr];
                    }
                }
            }
            return dp[0][aim];
        }


        /**
         * dp1优化方法
         *
         * @param arr
         * @param aim
         * @return
         */
        public static int normalDp2(int[] arr, int aim) {
            if (null == arr || arr.length == 0 || aim < 0) return 0;
            int len = arr.length;
            int[][] dp = new int[len + 1][aim + 1];
            dp[len][0] = 1;
            for (int currIndex = len - 1; currIndex >= 0; currIndex--) {
                for (int rest = 0; rest <= aim; rest++) {
                    int curr = arr[currIndex];
                    // 左侧数据存储了收集右侧数据基础数据
                    dp[currIndex][rest] = (rest - curr >= 0 ? dp[currIndex][rest - curr] : 0) + dp[currIndex + 1][rest];
                }
            }
            return dp[0][aim];
        }
    }


    /**
     * 硬币数组均为正数，且数组中相同数值认为是相同情况
     */
    private static class SameValSameCoin {

        private static class InfoCoin { //存储硬币种类及每种硬币对应数量
            public int[] vals;
            public int[] nums;

            public InfoCoin(int[] vals, int[] nums) {
                this.vals = vals;
                this.nums = nums;
            }

            public InfoCoin() {
            }
        }

        /**
         * 生成数据种类与每个种类数据间的对应关系
         *
         * @param arr
         * @return
         */
        public static InfoCoin getInfo(int[] arr) {//当数组有值才执行此方法
            if (null == arr || arr.length == 0) return new InfoCoin();
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < arr.length; i++) {
                map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
            }

            int[] vals = new int[map.size()];
            int[] nums = new int[map.size()];
            int curr = 0;
            for (Map.Entry<Integer, Integer> count : map.entrySet()
            ) {
                vals[curr] = count.getKey();
                nums[curr++] = count.getValue();
            }
            return new InfoCoin(vals, nums);
        }


        //    b:硬币面值数组arr,值均为正数每种数值仅一个，且相同值相同，给定目标数aim，返回方法数，例如：
//    arr{1,2,1,1,2,1,2},aim =4 ,方法数：3种（{1，1，1，1}、{1，1，2}、{2，2}）；

        public static int normal(int[] arr, int aim) {
            if (null == arr || arr.length == 0 || aim < 0) return 0;

            InfoCoin infoCoin = getInfo(arr);
            return normalRecusion(infoCoin.vals, infoCoin.nums, 0, aim);
        }

        private static int normalRecusion(int[] vals, int[] nums, int curr, int rest) {
            if (curr == vals.length)
                return rest == 0 ? 1 : 0;

            int currVal = vals[curr];
            int num = nums[curr];
            int ways = 0;
            for (int i = 0; i <= num && i * currVal <= rest; i++) {
                ways += normalRecusion(vals, nums, curr + 1, rest - i * currVal);
            }
            return ways;
        }


        public static int normalDp1(int[] arr, int aim) {
            if (null == arr || arr.length == 0 || aim < 0) return 0;
            InfoCoin infoCoin = getInfo(arr);
            int len = infoCoin.vals.length;
            int[][] dp = new int[len + 1][aim + 1];
            dp[len][0] = 1;

            for (int curr = len - 1; curr >= 0; curr--) {

                for (int rest = 0; rest <= aim; rest++) {
                    int currVal = infoCoin.vals[curr];
                    int num = infoCoin.nums[curr];
                    int ways = 0;
                    for (int i = 0; i <= num && i * currVal <= rest; i++) {
                        ways += dp[curr + 1][rest - i * currVal];
                    }
                    dp[curr][rest] = ways;
                }
            }
            return dp[0][aim];
        }


        public static int normalDp2(int[] arr, int aim) {
            if (null == arr || arr.length == 0 || aim < 0) return 0;
            InfoCoin infoCoin = getInfo(arr);
            int len = infoCoin.vals.length;
            int[][] dp = new int[len + 1][aim + 1];
            dp[len][0] = 1; //base case

            for (int curr = len - 1; curr >= 0; curr--) {
                for (int rest = 0; rest <= aim; rest++) {
                    int currVal = infoCoin.vals[curr];
                    int num = infoCoin.nums[curr];
                    dp[curr][rest] = getArrayValByIndex(dp, curr, rest - currVal)
                            - getArrayValByIndex(dp, curr + 1, rest - (num + 1) * currVal) +
                            dp[curr + 1][rest];
                }
            }
            return dp[0][aim];
        }
    }


    /**
     * 硬币数组均为正数，且数组中相同数值认为是不同情况
     */
    private static class SameValDiffCoin{


        public static int normal(int[] arr ,int aim){
            if (null == arr || arr.length ==0 || aim < 0) return 0;

            return normalRecusion(arr,0,aim);
        }

        private static int normalRecusion(int[] arr, int curr, int rest) {

            if (curr == arr.length)
                return rest == 0 ? 1 : 0;
            return normalRecusion(arr,curr +1 ,rest - arr[curr]) +
                    normalRecusion(arr,curr + 1 ,rest);
        }

        public static int normalDp(int[] arr,int aim){
            if (null == arr || arr.length ==0 || aim < 0) return 0;
            int len = arr.length;
            int[][] dp = new int[len + 1][aim + 1];
            dp[len][0] = 1;//base case

            for (int curr = len - 1; curr >= 0 ; curr--) {
                for (int rest = 0; rest <= aim; rest++) {

                    dp[curr][rest] = getArrayValByIndex(dp,curr +1 ,rest - arr[curr]) +
                            dp[curr + 1 ][rest];
                }
            }
            return dp[0][aim];
        }





    }


    /**
     * 提供获取数据数据方法，统一进行边界条件判断
     *
     * @param arr
     * @param row
     * @param col
     * @return
     */
    public static int getArrayValByIndex(int[][] arr, int row, int col) {
        if (row < 0 || row >= arr.length || col < 0 || col >= arr[0].length) return 0;
        return arr[row][col];
    }


}
