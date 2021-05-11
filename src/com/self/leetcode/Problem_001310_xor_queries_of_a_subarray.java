package com.self.leetcode;

import java.util.Arrays;

public class Problem_001310_xor_queries_of_a_subarray {
    public static void main(String[] args) {
        Problem_001310_xor_queries_of_a_subarray test = new Problem_001310_xor_queries_of_a_subarray();
//        int[] arr = {1,3,4,8};
//        int[][] queries = {{0,1},{1,2},{0,3},{3,3}};

        int[] arr = {4,8,2,10};
        int[][] queries = {{2,3},{1,3},{0,0},{0,3}};

        System.out.println(Arrays.toString(test.xorQueries(arr,queries)));
    }

//    Given the array arr of positive integers and the array queries
//    where queries[i] = [Li, Ri], for each query i compute the XOR of elements from Li to Ri (that is, arr[Li] xor arr[Li+1] xor ... xor arr[Ri] ).
//    Return an array containing the result for the given queries.

//    Example 1:
//
//    Input: arr = [1,3,4,8], queries = [[0,1],[1,2],[0,3],[3,3]]
//    Output: [2,7,14,8]
//    Explanation:
//    The binary representation of the elements in the array are:
//            1 = 0001
//            3 = 0011
//            4 = 0100
//            8 = 1000
//    The XOR values for queries are:
//            [0,1] = 1 xor 3 = 2
//            [1,2] = 3 xor 4 = 7
//            [0,3] = 1 xor 3 xor 4 xor 8 = 14
//            [3,3] = 8
//    Example 2:
//
//    Input: arr = [4,8,2,10], queries = [[2,3],[1,3],[0,0],[0,3]]
//    Output: [8,0,4,4]
//
//    Constraints:
//
//            1 <= arr.length <= 3 * 10^4
//            1 <= arr[i] <= 10^9
//            1 <= queries.length <= 3 * 10^4
//    queries[i].length == 2
//            0 <= queries[i][0] <= queries[i][1] < arr.length
//
//    来源：力扣（LeetCode）
//    链接：https://leetcode-cn.com/problems/xor-queries-of-a-subarray
//    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

    public int[] xorQueries(int[] arr, int[][] queries) {
        int lenArr = arr.length;
        int lenQ = queries.length;

        int[] xorArr = new int[lenArr];
        xorArr[0] = arr[0];
        for (int i = 1; i < lenArr; i++) { // 初始化异或结果数组
            xorArr[i] = xorArr[i - 1] ^ arr[i];
        }

        int[] result = new int[lenQ];
        for (int i = 0; i < lenQ; i++) {
//            if (queries[i][0] - 1 >= 0){
//                result[i] = xorArr[queries[i][1]] ^ xorArr[queries[i][0] - 1];
//            }else {
//                result[i] = xorArr[queries[i][1]] ^ xorArr[queries[i][0] - 1];
//            }

            result[i] = xorArr[queries[i][1]] ^ (queries[i][0] - 1 >= 0 ? xorArr[queries[i][0] - 1] : 0);
        }
        return result;
    }
}
