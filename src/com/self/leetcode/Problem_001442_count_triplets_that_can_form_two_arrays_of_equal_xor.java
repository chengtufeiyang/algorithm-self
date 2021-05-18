package com.self.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Problem_001442_count_triplets_that_can_form_two_arrays_of_equal_xor {

    public static void main(String[] args) {
        Problem_001442_count_triplets_that_can_form_two_arrays_of_equal_xor test = new Problem_001442_count_triplets_that_can_form_two_arrays_of_equal_xor();

//        int[] arr = {2,3,1,6,7};
        int[] arr = {1,1,1,1,1};
//        int[] arr = {2,3};
//        int[] arr = {1,3,5,7,9};
//        int[] arr = {7,11,12,9,5,2,7,17,22};
        System.out.println(test.countTriplets(arr));
        System.out.println(test.countTriplets2(arr));

    }
//    Given an array of integers arr.
//
//    We want to select three indices i, j and k where (0 <= i < j <= k < arr.length).
//
//    Let's define a and b as follows:
//
//    a = arr[i] ^ arr[i + 1] ^ ... ^ arr[j - 1]
//    b = arr[j] ^ arr[j + 1] ^ ... ^ arr[k]
//    Note that ^ denotes the bitwise-xor operation.
//
//    Return the number of triplets (i, j and k) Where a == b.
//
// 
//
//    Example 1:
//
//    Input: arr = [2,3,1,6,7]
//    Output: 4
//    Explanation: The triplets are (0,1,2), (0,2,2), (2,3,4) and (2,4,4)
//    Example 2:
//
//    Input: arr = [1,1,1,1,1]
//    Output: 10
//    Example 3:
//
//    Input: arr = [2,3]
//    Output: 0
//    Example 4:
//
//    Input: arr = [1,3,5,7,9]
//    Output: 3
//    Example 5:
//
//    Input: arr = [7,11,12,9,5,2,7,17,22]
//    Output: 8
//             
//
//    Constraints:
//
//            1 <= arr.length <= 300
//            1 <= arr[i] <= 10^8
//
//    来源：力扣（LeetCode）
//    链接：https://leetcode-cn.com/problems/count-triplets-that-can-form-two-arrays-of-equal-xor
//    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

    public int countTriplets(int[] arr) {

        int len = arr.length;
        if (len == 1) return 0;

        int[] s = new int[len + 1];
        int temp = 0;
        for (int i = 0; i < len; i++) {//  初始化异或前缀数组 // s[i] --- arr[0] ^ arr[1] ^ ... ^ arr[i - 1]
            s[i + 1] = temp ^ arr[i];
            temp = s[i + 1];
        }

        int result = 0;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j <= len; j++) {
                if (s[i] == s[j]){
                    result += j - i - 1;
                }
            }
        }
        return result;
    }


    // 当前位置之前出现了多少次相同值的数据（map集合记录次数  和 下标累加和）
    public int countTriplets2(int[] arr) {

        int len = arr.length;// 需循环长度
        int s = 0;// 异或初始值
        int result = 0;
        Map<Integer,Integer> num = new HashMap<>();
        Map<Integer,Integer> index = new HashMap<>();
        for (int i = 0; i < len; i++) {

            if (num.containsKey(s ^ arr[i])){
                result += num.get(s ^ arr[i]) * i - index.get(s ^ arr[i]);
            }
            num.put(s,num.getOrDefault(s,0) + 1);
            index.put(s,index.getOrDefault(s,0) + i);
            s ^= arr[i];
        }
        return result;
    }



}
