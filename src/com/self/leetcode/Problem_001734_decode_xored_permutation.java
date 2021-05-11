package com.self.leetcode;

import java.util.Arrays;

public class Problem_001734_decode_xored_permutation {
    public static void main(String[] args) {

        Problem_001734_decode_xored_permutation test = new Problem_001734_decode_xored_permutation();

//        int[] encoded = {3,1};
        int[] encoded = {6,5,4,6};
        System.out.println(Arrays.toString(test.decode(encoded)));
    }


// a1     a2     a3       a4      a5      a6       ---求取数组
// a1^a2  a2^a3  a3^a4    a4^a5   a5^a6            ---已知数组
//    There is an integer array perm that is a permutation of the first n positive integers, where n is always odd.
//
//    It was encoded into another integer array encoded of length n - 1, such that encoded[i] = perm[i] XOR perm[i + 1].
//    For example, if perm = [1,3,2], then encoded = [2,1].
//
//    Given the encoded array, return the original array perm. It is guaranteed that the answer exists and is unique.
//
//
//    Example 1:
//
//    Input: encoded = [3,1]
//    Output: [1,2,3]
//    Explanation: If perm = [1,2,3], then encoded = [1 XOR 2,2 XOR 3] = [3,1]
//    Example 2:
//
//    Input: encoded = [6,5,4,6]
//    Output: [2,4,1,5,3]
//
//    Constraints:
//
//            3 <= n < 105
//    n is odd.
//    encoded.length == n - 1
//
//    来源：力扣（LeetCode）
//    链接：https://leetcode-cn.com/problems/decode-xored-permutation
//    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。


    // 前置条件，前n个正整数的排列
    public int[] decode(int[] encoded) {
        int allxor = 1;
        for (int i = 2; i <= encoded.length +1; i++) {// 根据前置条件获取所有数据异或结果
            allxor ^= i;
        }

        for (int i = 1; i < encoded.length; i += 2) { // 获取初始位置值
            allxor ^= encoded[i];
        }
        int[] result = new int[encoded.length + 1];
        result[0] = allxor;
        int index = 1;
        for (int i = 0; i < encoded.length; i++) {
            int temp = result[index - 1] ^ encoded[i];
            result[index++] = temp;
        }
        return result;
    }
}
