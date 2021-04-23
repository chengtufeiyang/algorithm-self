package com.self.leetcode;

import com.wz.array.GenerateArray;
import edu.princeton.cs.algs4.In;

import java.util.Arrays;

public class Problem_000363_max_sum_of_rectangle_no_larger_than_k {

    public static void main(String[] args) {

        Problem_000363_max_sum_of_rectangle_no_larger_than_k test = new Problem_000363_max_sum_of_rectangle_no_larger_than_k();


//        for (int i = 0; i < 1000; i++) {
//            int[] nums = GenerateArray.generateRandomArray(10,20);
////            System.out.println(Arrays.toString(nums));
//            int val0 = maxSumArray(nums);
//            int val1 = maxSumArray_nor(nums);
//            if (val0 != val1){
//                System.out.println(String.format("val0:$d,val1:%d",val0,val1));
//                System.out.println(Arrays.toString(nums));
//            }
//        }


//        int[] arr = {-4, 1, 2, -1, 3, -8};
//        int k = 2;
//        System.out.println(maxSumArray(arr, k));

//        int[][] matrix = {{1, 0, 1}, {0, -2, 3}};
//        int k = 2;

//        int[][] matrix = {{2, 2, -1}};
//        int k = 3;

        int[][] matrix = {{5,-4,-3,4},{-3,-4,4,5},{5,1,5,-4}};
        int k = 3;

        System.out.println(test.maxSumSubmatrix(matrix,k));

    }


//    给你一个 m x n 的矩阵 matrix 和一个整数 k ，找出并返回矩阵内部矩形区域的不超过 k 的最大数值和。
//
//    题目数据保证总会存在一个数值和不超过 k 的矩形区域。

//    示例 1：

//    输入：matrix = [[1,0,1],[0,-2,3]], k = 2
//    输出：2
//    解释：蓝色边框圈出来的矩形区域 [[0, 1], [-2, 3]] 的数值和是 2，且 2 是不超过 k 的最大数字（k = 2）。
//    示例 2：

//    输入：matrix = [[2,2,-1]], k = 3
//    输出：3
//    m == matrix.length
//    n == matrix[i].length
//1 <= m, n <= 100
//            -100 <= matrix[i][j] <= 100
//            -105 <= k <= 105
//
//    来源：力扣（LeetCode）
//    链接：https://leetcode-cn.com/problems/max-sum-of-rectangle-no-larger-than-k
//    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

    public int maxSumSubmatrix(int[][] matrix, int k) {
        int m = matrix.length;
        int n = matrix[0].length;
        int max = Integer.MIN_VALUE;
        for (int row = 0; row < m; row++) { // 此行开始
            int[] temp = new int[n];

            for (int currRow = row; currRow < m; currRow++) { // 循环找出从开始到最后一行所有情况最大值
                for (int col = 0; col < n; col++) { // 列
                    temp[col] += matrix[currRow][col];
                }
                max = Math.max(max,maxSumArray_nor(temp,k));

                if (max == k) {
//                    System.out.println("row:"+row+ "    currRow:" + currRow);
//                    System.out.println(Arrays.toString(temp));
                    return k;
                }
            }
        }
        return max;
    }


    /**
     * 获取最大子数组和 ---
     *
     * @param arr
     * @return
     */
    public static int maxSumArray(int[] arr) {
        if (null == arr || arr.length == 0) return 0;
        int len = arr.length;
        int curr = 0;  //当前累加和
        int max = Integer.MIN_VALUE; // 最终获取最大值

        for (int i = 0; i < len; i++) {
            curr += arr[i];
            max = Math.max(max, curr);
            curr = curr < 0 ? 0 : curr;
        }
        return max;
    }

    /**
     * 获取最大子数组和 ---
     *
     * @param arr
     * @return
     */
    public static int maxSumArray_nor(int[] arr) {
        if (null == arr || arr.length == 0) return 0;
        int len = arr.length;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < len; i++) {
            int temp = 0;
            for (int j = i; j < len; j++) {
                temp += arr[j];
                max = Math.max(temp, max);
            }
        }
        return max;
    }


    /**
     * 获取最大子数组和 ---
     *
     * @param arr
     * @return
     */
    public static int maxSumArray(int[] arr, int k) {
        if (null == arr || arr.length == 0) return 0;
        int len = arr.length;
        int max = Integer.MIN_VALUE; // 最终获取最大值
        for (int i = 0; i < len; i++) {
            int left = i; // 初始状态下，左侧位置坐标
            int right = i; // 初始状态下，右侧位置坐标
            int curr = arr[i];  //当前累加和
            while (right < len) {
                if (curr == k) return k; //此一定为最接近情况，后续无需再进行判断

                if (curr < k) {
                    max = Math.max(max, curr);
                    right++;
                    curr += right < len ? arr[right] : 0;
                } else {
                    if (left == right) {
                        left++;
                        right++;
                        curr =right < len ?  arr[right] : 0; // curr 重新赋值
                    } else {
                        curr -= arr[left];
                        left++;
                    }
                }
            }
        }
        return max;
    }




    /**
     * 获取不超过k值的子数组的和
     *
     * @param arr
     * @return
     */
    public static int maxSumArray_nor(int[] arr, int k) {
        if (null == arr || arr.length == 0) return 0;
        int len = arr.length;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < len; i++) {
            int temp = 0;
            for (int j = i; j < len; j++) {
                temp += arr[j];
                if (temp <= k) max = Math.max(temp, max);
            }
        }
        return max;
    }


}
