package com.self.leetcode;

import java.util.HashSet;
import java.util.Set;

public class Problem_000421_maximum_xor_of_two_numbers_in_an_array {
    public static void main(String[] args) {
        Problem_000421_maximum_xor_of_two_numbers_in_an_array test = new Problem_000421_maximum_xor_of_two_numbers_in_an_array();
//        int[] nums = {3,10,5,25,2,8};
//        int[] nums = {0};
//        int[] nums = {2,4};
        int[] nums = {8,10,2};
//        int[] nums = {14,70,53,83,49,91,36,80,92,51,66,70};
        System.out.println(test.findMaximumXOR(nums));
        System.out.println(test.findMaximumXOR2(nums));
        System.out.println(test.findMaximumXOR3(nums));
    }



    public int findMaximumXOR(int[] nums) {
        int len = nums.length ;
        if (len == 1) return 0;
        int result = 0;
        int temp = 0;
        for (int i = 0; i < len; i++) {
            temp = nums[i];
            for (int j = i + 1; j < len; j++) {
                result = Math.max(result,temp ^ nums[j]);
            }
        }
        return result;
    }




// hash
    public int findMaximumXOR2(int[] nums) {
        int maxBit = 30;// 最大坐标位置
        int result = 0;

        Set<Integer> set = null;
        boolean flag;
        for (int i = maxBit; i >= 0; i--) {
            set = new HashSet<>();
            for (int num:nums
                 ) {
                set.add(num >> i);
            }

            result = result * 2 + 1;// 预设当前最大值
            flag = false;

            for (int num:nums
            ) {
                if (set.contains((num >> i) ^ result)){
                    flag = true;
                    break;
                }
            }

            if (!flag){
                result -= 1;
            }
        }

        return result;
    }


// tries
    Tries root;
    public int findMaximumXOR3(int[] nums) {
        int len = nums.length;
        if (len == 1) return 0;
        int result = 0;
        root = new Tries();
        for (int i = 1; i < len; i++) {
            addTries(nums[i - 1]); //  将数据添加到前缀树种
            result = Math.max(result,checkTries(nums[i]));// 使用当前位置值，到前缀树中查找最大值
        }
        return result;
    }
    int maxBit = 30; // 整数最大位
    private int checkTries(int num) {
        Tries curr = root;
        int result = 0;
        int temp ;
        for (int i = maxBit; i >= 0 ; i--) {
            temp = (num >> i) & 1;// 如果当前数值，当前位置是1，需要找个0  ；如果当前位置是0，则需要找个1

            if (temp == 1){

                if (null != curr.right){
                    result = 2 * result + 1;
                    curr = curr.right;
                }else {
                    result = 2 * result;
                    curr = curr.left;
                }
            }else {

                if (null != curr.left ){
                    result = 2 * result + 1;
                    curr = curr.left;
                }else {
                    result = 2 * result;
                    curr = curr.right;
                }
            }
        }
        return result;
    }

    private void addTries(int num) {

        int temp ;
        Tries curr = root;
        for (int i = maxBit; i >= 0 ; i--) {
            temp = (num >> i) & 1; //  当前位置是0 ，创建左子树 ，当前位置 是1创建右子树
            if (temp == 0){
                if (null == curr.right){
                    curr.right = new Tries();
                }
                curr = curr.right;
            }else {
                if (null == curr.left){
                    curr.left = new Tries();
                }
                curr = curr.left;
            }
        }
    }

   class Tries{

        private Tries left;
        private Tries right;

    }
}
