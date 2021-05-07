package com.self.leetcode;

public class Problem_001486_xor_operation_in_an_array {

    public static void main(String[] args) {
        Problem_001486_xor_operation_in_an_array test = new Problem_001486_xor_operation_in_an_array();

//        int n = 5, start = 0;
//        int n = 4, start = 3;
//        int n = 1, start = 7;
        int n = 10, start = 5;
        System.out.println(test.xorOperation(n,start));

    }


//    https://leetcode-cn.com/problems/xor-operation-in-an-array/
//Given an integer n and an integer start.
//
//    Define an array nums where nums[i] = start + 2*i (0-indexed) and n == nums.length.
//
//    Return the bitwise XOR of all elements of nums.
//
// 
//
//    Example 1:
//
//    Input: n = 5, start = 0
//    Output: 8
//    Explanation: Array nums is equal to [0, 2, 4, 6, 8] where (0 ^ 2 ^ 4 ^ 6 ^ 8) = 8.
//    Where "^" corresponds to bitwise XOR operator.
//            Example 2:
//
//    Input: n = 4, start = 3
//    Output: 8
//    Explanation: Array nums is equal to [3, 5, 7, 9] where (3 ^ 5 ^ 7 ^ 9) = 8.
//    Example 3:
//
//    Input: n = 1, start = 7
//    Output: 7
//    Example 4:
//
//    Input: n = 10, start = 5
//    Output: 2
//             
//
//    Constraints:
//
//            1 <= n <= 1000
//            0 <= start <= 1000
//    n == nums.length
//
//


    public int xorOperation(int n, int start) {
        int result = 0;
        for (int i = 0; i < n; i++) {
            result = result ^ (start + 2 * i);
        }
        return result;
    }
}
