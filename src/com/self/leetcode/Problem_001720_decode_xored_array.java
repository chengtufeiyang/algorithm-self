package com.self.leetcode;

import java.util.Arrays;

public class Problem_001720_decode_xored_array {

    public static void main(String[] args) {
        Problem_001720_decode_xored_array test = new Problem_001720_decode_xored_array();

//        int[] encoded = {1, 2, 3};
//        int first = 1;
//
//        int[] encoded = {6,2,7,3};
//        int first = 4;

        int[] encoded = {1};
        int first = 1;

        System.out.println(Arrays.toString(
                test.decode(encoded, first)
        ));

    }

    // 限制条件
//    2 <= n <= 104
//    encoded.length == n - 1
//            0 <= encoded[i] <= 105
//            0 <= first <= 105

//    https://leetcode-cn.com/problems/decode-xored-array/


//    22 iinc 5 by 1					 Increment local variable by constant          ---核心

    public int[] decode(int[] encoded, int first) {
        int len = encoded.length;
        int[] result = new int[len + 1];
        result[0] = first;
        int index = 1;
        for (int i = 0; i < len; i++) {
            result[index++] = result[i] ^ encoded[i];
        }
        return result;
    }


//    public int[] decode2(int[] encoded, int first) {
//        int len = encoded.length;
//        int[] result = new int[len + 1];
//        result[0] = first;
//        int index = 1;
//        result[index++] =  (result[index - 1] ^ encoded[0]);
////        for (int i = 0; i < len; i++) {
//////            System.out.println("act:"+(result[index - 1] ^ encoded[i]));
//////            System.out.println("pre:"+Arrays.toString(result));
//////            result[index++] =  (result[index - 1] ^ encoded[i]);
//////            index++;
//////            System.out.println("aft:"+Arrays.toString(result));
////
////        }
//        return result;
//    }
}
