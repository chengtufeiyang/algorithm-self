package com.self.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Problem_001738_find_kth_largest_xor_coordinate_value {


    public static void main(String[] args) {

        Problem_001738_find_kth_largest_xor_coordinate_value test = new Problem_001738_find_kth_largest_xor_coordinate_value();

        int[][] matrix = {{5,2},{1,6}};
//        int k = 1;
//        int k = 2;
//        int k = 3;
        int k = 4;
        System.out.println(test.kthLargestValue(matrix,k));
        System.out.println(test.kthLargestValue2(matrix,k));

    }


//    You are given a 2D matrix of size m x n, consisting of non-negative integers. You are also given an integer k.
//
//    The value of coordinate (a, b) of the matrix is the XOR of all matrix[i][j] where 0 <= i <= a < m and 0 <= j <= b < n (0-indexed).
//
//    Find the kth largest value (1-indexed) of all the coordinates of matrix.
//
//             
//
//    Example 1:
//
//    Input: matrix = [[5,2],[1,6]], k = 1
//    Output: 7
//    Explanation: The value of coordinate (0,1) is 5 XOR 2 = 7, which is the largest value.
//            Example 2:
//
//    Input: matrix = [[5,2],[1,6]], k = 2
//    Output: 5
//    Explanation: The value of coordinate (0,0) is 5 = 5, which is the 2nd largest value.
//            Example 3:
//
//    Input: matrix = [[5,2],[1,6]], k = 3
//    Output: 4
//    Explanation: The value of coordinate (1,0) is 5 XOR 1 = 4, which is the 3rd largest value.
//            Example 4:
//
//    Input: matrix = [[5,2],[1,6]], k = 4
//    Output: 0
//    Explanation: The value of coordinate (1,1) is 5 XOR 2 XOR 1 XOR 6 = 0, which is the 4th largest value.
// 
//
//    Constraints:
//
//    m == matrix.length
//    n == matrix[i].length
//1 <= m, n <= 1000
//            0 <= matrix[i][j] <= 106
//            1 <= k <= m * n
//
//    来源：力扣（LeetCode）
//    链接：https://leetcode-cn.com/problems/find-kth-largest-xor-coordinate-value
//    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。


    private class MyCom implements Comparator<Integer>{

        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    }


    public int kthLargestValue(int[][] matrix, int k) {
        int row = matrix.length;
        int col = matrix[0].length;

        PriorityQueue<Integer> result = new PriorityQueue<Integer>(k,new MyCom());// 辅助数组 1 ---记录最终结果数组 --可直接使用小根堆 且大小定义为 k
//        PriorityQueue<Integer> result = new PriorityQueue<Integer>(k);// 辅助数组 1 ---记录最终结果数组 --可直接使用小根堆 且大小定义为 k
        int[][]  row_ass = new int[row][col];// 辅助数组 2 --- 记录横向异或前缀和
        int[][]  col_ass = new int[row][col];// 辅助数组 3 --- 记录纵向异或前缀和
        int[][]  total_ass = new int[row][col];  // 存储所有结果
        for (int tempCol = 0; tempCol < col; tempCol++) {
            col_ass[0][tempCol] = matrix[0][tempCol];
            for (int tempRow = 1; tempRow < row; tempRow++) {
                col_ass[tempRow][tempCol] = col_ass[tempRow - 1][tempCol] ^ matrix[tempRow][tempCol];
            }
        }

        for (int tempRow = 0; tempRow < row; tempRow++) {
            row_ass[tempRow][0] = matrix[tempRow][0];
            for (int tempCol = 1; tempCol < col; tempCol++) {
                row_ass[tempRow][tempCol] = row_ass[tempRow][tempCol - 1] ^ matrix[tempRow][tempCol];
             }
        }

        for (int i = 0; i < col; i++) {
            total_ass[0][i] = row_ass[0][i];
            result.add(total_ass[0][i]);
        }

        for (int i = 1; i < row; i++) {
            total_ass[i][0] = col_ass[i][0];
            result.add(total_ass[i][0]);
        }

        for (int tempRow = 1; tempRow < row; tempRow++) {
            for (int tempCol = 1; tempCol < col; tempCol++) {

                total_ass[tempRow][tempCol] =  row_ass[tempRow][tempCol] ^ col_ass[tempRow][tempCol] ^ matrix[tempRow][tempCol]
                    ^ total_ass[tempRow - 1][tempCol - 1];

                result.add(total_ass[tempRow][tempCol]);

            }
        }

        for (int i = 0; i < k - 1; i++) {
            result.poll();
        }

        return result.peek();
    }



    public int kthLargestValue2(int[][] matrix, int k) {
        int row = matrix.length;
        int col = matrix[0].length;

        PriorityQueue<Integer> result = new PriorityQueue<Integer>(k);// 辅助数组 1 ---记录最终结果数组 --可直接使用小根堆 且大小定义为 k

        int[][] dp = new int[row + 1][col + 1];

        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= col; j++) {
                dp[i][j] = dp[i - 1][j] ^ dp[i][j - 1] ^ dp[i - 1][j - 1] ^ matrix[i - 1][j - 1];
                addNum(result,dp[i][j],k);
            }
        }
        return result.peek();
    }

    private void addNum(PriorityQueue<Integer> result, int val, int k) {

        if (result.size() < k){
            result.add(val);
        }else {
            if (val > result.peek()){
                result.poll();
                result.add(val);
            }
        }
    }


}
