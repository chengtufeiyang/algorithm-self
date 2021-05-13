package com.self.leetcode;

public class Jian_zhi_offer_42 {

    public static void main(String[] args) {
        Jian_zhi_offer_42 test = new Jian_zhi_offer_42();

        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(test.maxSubArray(nums));

    }
//    示例1:
//
//    输入: nums = [-2,1,-3,4,-1,2,1,-5,4]
//    输出: 6
//    解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
//             
//
//    提示：
//
//            1 <= arr.length <= 10^5
//            -100 <= arr[i] <= 100
//
//    来源：力扣（LeetCode）
//    链接：https://leetcode-cn.com/problems/lian-xu-zi-shu-zu-de-zui-da-he-lcof
//    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。


    public int maxSubArray(int[] nums) {

        int one = nums[0];
        int max = one;
        for (int i = 1; i < nums.length; i++) {
            if (one >= 0){
                one += nums[i];
            }else {
                one = nums[i];
            }
            max = Math.max(max,one);
        }
        return max;
    }
}
