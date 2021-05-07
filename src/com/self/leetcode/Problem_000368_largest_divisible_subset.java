package com.self.leetcode;

import java.util.*;

public class Problem_000368_largest_divisible_subset {

    public static void main(String[] args) {
//        int x = 2;
//        int y = 1;
//        System.out.println(x % y);
//        System.out.println(y % x);


        Problem_000368_largest_divisible_subset test = new Problem_000368_largest_divisible_subset();
        int[] nums = {1,2,3};
//        int[] nums = {1,2,4,8};
//        int[] nums = {5,9,18,54,108,540,90,180,360,720};
//        int[] nums = {4,8,10,240};
        System.out.println(test.largestDivisibleSubset(nums));
        System.out.println(test.largestDivisibleSubset2(nums));

//        System.out.println(4 ^ 2);
//        System.out.println(6 ^ 3);
    }



//    给你一个由 无重复 正整数组成的集合 nums ，请你找出并返回其中最大的整除子集 answer ，子集中每一元素对 (answer[i], answer[j]) 都应当满足：
//    answer[i] % answer[j] == 0 ，或
//    answer[j] % answer[i] == 0
//    如果存在多个有效解子集，返回其中任何一个均可。
//
//    示例 1：
//
//    输入：nums = [1,2,3]
//    输出：[1,2]
//    解释：[1,3] 也会被视为正确答案。
//    示例 2：
//
//    输入：nums = [1,2,4,8]
//    输出：[1,2,4,8]
//
//    提示：
//
//            1 <= nums.length <= 1000
//            1 <= nums[i] <= 2 * 109
//    nums 中的所有整数 互不相同

    List<Integer> temp = new ArrayList<>();
    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> result = new ArrayList<>();
        if (nums.length == 1) {
            result.add(nums[0]);
            return result;
        }
        largestDivisibleSubset_recursion(nums,0,result);
        return temp;
    }

    private List<Integer> largestDivisibleSubset_recursion(int[] nums, int curr, List<Integer> result) {
        if (curr == nums.length){
//            System.out.println("temep:"+result);
            if (result.size() == 0) return new ArrayList<Integer>();
            if (result.size() > temp.size()){
                // 验证result包含数组符合整除子集条件
                temp = new ArrayList<>(result);
            }
            return temp;
        }


        // no
        List<Integer> no = largestDivisibleSubset_recursion(nums,curr + 1 ,result);
        // yes
        List<Integer> yes = null;
        if (result.size() == 0 || (divide(nums[curr],result))){
            result.add(nums[curr]);
            yes = largestDivisibleSubset_recursion(nums,curr + 1 ,result);
            result.remove(result.size() - 1);
        }
        return no == null ? yes : ( yes != null && no.size() >= yes.size() ? no : yes);
    }

    public static boolean divide(int x ,List<Integer> result){
        if (null == result) return false;
        for (int i = 0; i < result.size(); i++) {
            if (!divide(x,result.get(i))){
                return false;
            }
        }
        return true;
    }


    public static boolean divide(int x ,int y){

        return (x % y == 0  ||  y % x == 0) ? true : false;
    }


    /**
     * 排序后已当前位置为最大值求取结果子集
     * @param nums
     * @return
     */
    public List<Integer> largestDivisibleSubset2(int[] nums) {
        List<Integer> result = new ArrayList<>();
        int len = nums.length;
        if (len == 1) {
            result.add(nums[0]);
            return result;
        }
        Arrays.sort(nums); // 数组排序
        int[] dp = new int[len];
        Arrays.fill(dp,1);
        // dp数组 赋值,同时记录最大值以及最大值的位置
        int max = 1;
        int index = 0;
        for (int i = 1; i < len; i++) {
            int temp = nums[i] ; //  此刻需
            for (int j = i -1; j >= 0; j--) {
                if (divide(temp,nums[j])){
                    dp[i] = dp[j] + 1 > dp[i] ? dp[j] + 1 : dp[i];
                    if (dp[i] > max){
                        max = dp[i];
                        index = i;
                    }
                }
            }
        }

        result.add(nums[index--]);
        max--;
        for (int i = index; i >= 0; i--) {
            if (max==0)break;
            if (dp[i] == max && divide(nums[i],result.get(result.size()-1))){
                result.add(nums[i]);
                max--;
            }
        }
        return result;
    }



    class Solution {
        public List<Integer> largestDivisibleSubset(int[] nums) {
            int len = nums.length;
            Arrays.sort(nums);

            // 第 1 步：动态规划找出最大子集的个数、最大子集中的最大整数
            int[] dp = new int[len];
            Arrays.fill(dp, 1);
            int maxSize = 1;
            int maxVal = dp[0];
            for (int i = 1; i < len; i++) {
                for (int j = 0; j < i; j++) {
                    // 题目中说「没有重复元素」很重要
                    if (nums[i] % nums[j] == 0) {
                        dp[i] = Math.max(dp[i], dp[j] + 1);
                    }
                }

                if (dp[i] > maxSize) {
                    maxSize = dp[i];
                    maxVal = nums[i];
                }
            }

            // 第 2 步：倒推获得最大子集
            List<Integer> res = new ArrayList<Integer>();
            if (maxSize == 1) {
                res.add(nums[0]);
                return res;
            }

            for (int i = len - 1; i >= 0 && maxSize > 0; i--) {
                if (dp[i] == maxSize && maxVal % nums[i] == 0) {
                    res.add(nums[i]);
                    maxVal = nums[i];
                    maxSize--;
                }
            }
            return res;
        }
    }

}
