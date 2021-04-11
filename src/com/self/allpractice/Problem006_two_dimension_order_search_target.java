package com.self.allpractice;

public class Problem006_two_dimension_order_search_target {

    public static void main(String[] args) {

    }


    /**
     * 从有序二维数组matrix中搜索目标值target
     * @param matrix
     * @param target
     * @return
     */
    public static boolean isExist(int[][] matrix,int target){
        if (null == matrix || matrix.length == 0 ) return false;
        int row = matrix.length;
        int col = matrix[0].length;
        if (target < matrix[0][0] || target > matrix[row - 1][col - 1]) return false;




        return true;
    }
}
