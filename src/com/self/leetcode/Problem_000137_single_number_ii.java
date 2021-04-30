package com.self.leetcode;

import edu.princeton.cs.algs4.In;

import java.util.Arrays;

public class Problem_000137_single_number_ii {

    public static void main(String[] args) {
////        System.out.println(2 ^ 2);
//        Problem_000137_single_number_ii test = new Problem_000137_single_number_ii();
////        int[] nums = {2,2,3,2};
//        int[] nums = {0,1,0,1,0,1,99};
//        System.out.println(test.singleNumber(nums));
//        System.out.println(test.singleNumber2(nums));

//        System.out.println(Integer.toBinaryString(99)); // 1100011
//        System.out.println(Integer.toBinaryString(99 >> 1)); //
//        System.out.println(Integer.toBinaryString(1 << 99));
//        System.out.println(1 << 30);
//        for (int i = 0; i < 5; i++) {
//            System.out.println("左移位置"+i+":"+(i << 1));  // i  左移动1位
//        }
//
//        System.out.println("----------------------------------------");
//        for (int i = 0; i < 5; i++) {
//            System.out.println(Integer.toBinaryString(i));
//            System.out.println("右移位置"+i+":"+(i >> 1));  // i 右移动 1个位置
//        }





    }


    /**
     * https://leetcode-cn.com/problems/single-number-ii/
     * 
     * 1 <= nums.length <= 3 * 104
     * -231 <= nums[i] <= 231 - 1
     * nums 中，除某个元素仅出现 一次 外，其余每个元素都恰出现 三次
     *  
     *
     * 链接：https://leetcode-cn.com/problems/single-number-ii
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        if (nums.length==1) return nums[0];
        Arrays.sort(nums);//排序

        int len = nums.length;
        int curr = nums[0];
        int currInde = 0;
        for (int i = 1; i < len;) {
            if ((curr ^ nums[i]) != 0){
                return curr;
            }
            currInde += 3;
            if (currInde >= len - 1) return nums[len -1];
            curr = nums[currInde];
            i = currInde + 1;
        }
        return -1;
    }


    /**
     * m >> n   : m  向右移动n个位置
     * m << n   : m 向左移动n个位置
     * @param nums
     * @return
     */
    public int singleNumber2(int[] nums) {
        if (nums.length==1) return nums[0];

        int len = nums.length;
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            // i 统计当前位置1 的数量

            int temp = 0;  // 临时统计某位置二进制数1的数量
            for (int j = 0; j < len; j++) {
                // 获取原数组中 第j个位置的二进制数
//                if (((nums[j] >> i) & 1) == 1){
//                    temp++;
//                }
                temp += (nums[j] >> i) & 1;
            }
            if (temp % 3 != 0 ){
                ans |= (1 << i) ;
//                ans += (1 << i);
            }
        }
        return ans;
    }

}
