package com.self.leetcode;

public class Interview_17_16_the_masseuse_lcci {

//    Example 1:
//
//    Input:  [1,2,3,1]
//    Output:  4
//    Explanation:  Accept request 1 and 3, total minutes = 1 + 3 = 4
//    Example 2:
//
//    Input:  [2,7,9,3,1]
//    Output:  12
//    Explanation:  Accept request 1, 3 and 5, total minutes = 2 + 9 + 1 = 12
//    Example 3:
//
//    Input:  [2,1,4,5,3,1,1,3]
//    Output:  12
//    Explanation:  Accept request 1, 3, 5 and 8, total minutes = 2 + 4 + 3 + 3 = 12
//
//    来源：力扣（LeetCode）
//    链接：https://leetcode-cn.com/problems/the-masseuse-lcci
//    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。


    public static void main(String[] args) {
        Interview_17_16_the_masseuse_lcci test = new Interview_17_16_the_masseuse_lcci();
//        int[] nums = {1,2,3,1};
//        int[] nums = {2,7,9,3,1};
        int[] nums = {2,1,4,5,3,1,1,3};
        System.out.println(test.massage(nums));
        System.out.println(test.massage2(nums));
        System.out.println(test.massage3(nums));
    }


    public int massage(int[] nums) {
        if (null == nums || nums.length == 0) return 0;


        return massage_recursion(0,nums);
    }

    private int massage_recursion(int curr, int[] nums) {
        if (curr >= nums.length) return 0;

        int one = massage_recursion(curr + 2,nums) + nums[curr];

        int two = massage_recursion(curr + 1,nums);

        return Math.max(one, two);
    }


    public int massage2(int[] nums) {
        if (null == nums || nums.length == 0) return 0;
        int len = nums.length;
        int[] dp = new int[len + 2];

        for (int i = len - 1; i >= 0; i--) {
            dp[i] = Math.max(dp[i + 2] + nums[i],dp[i + 1]);
        }
        return dp[0];
    }

    public int massage3(int[] nums) {
        if (null == nums || nums.length == 0) return 0;
        int len = nums.length;
//        int[] dp = new int[len + 2];
        int one = 0;
        int two = 0;

        int temp = 0;
        for (int i = len - 1; i >= 0; i--) {
            temp = Math.max(two + nums[i],one);
            two = one;
            one = temp;
        }
        return one;
    }
}
