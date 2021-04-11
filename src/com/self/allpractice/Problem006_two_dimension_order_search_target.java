package com.self.allpractice;

public class Problem006_two_dimension_order_search_target {

    public static void main(String[] args) {
        int[][] matrix = {{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}};
        int target = 5;
        System.out.println(isExist(matrix,target));
        System.out.println(isExist2(matrix,target));
    }


    /**
     * 从有序二维数组matrix中搜索目标值target
     * 右上角 or 左下角
     * @param matrix
     * @param target
     * @return
     */
    public static boolean isExist(int[][] matrix,int target){
        if (null == matrix || matrix.length == 0 ) return false;
        int row = matrix.length;
        int col = matrix[0].length;
        if (target < matrix[0][0] || target > matrix[row - 1][col - 1]) return false;

        boolean[][]  flag = new boolean[row][col]; //初始化数组，记录当前位置是否判断过

        int tempRow = 0;
        int tempCol = col - 1;
        while (tempRow >=0 && tempRow < row && tempCol >= 0 && tempCol < col && !flag[tempRow][tempCol] ){
            int temp = matrix[tempRow][tempCol];
            flag[tempRow][tempCol] = true;
            if (temp == target){
                return true;
            }else if(temp > target){
                tempCol -= 1;
            }else {
                tempRow += 1;
            }
        }
        return false;
    }

    public static boolean isExist2(int[][] matrix,int target){
        if (null == matrix || matrix.length == 0 ) return false;
        int row = matrix.length;
        int col = matrix[0].length;
        if (target < matrix[0][0] || target > matrix[row - 1][col - 1]) return false;

        int tempRow = 0;
        int tempCol = col - 1;
        int preRow = -1;
        int preCol = -1;
        while (tempRow >=0 && tempRow < row && tempCol >= 0 && tempCol < col && !(tempRow == preRow && tempCol == preCol) ){
            int temp = matrix[tempRow][tempCol];
            preRow = tempRow;
            preCol = tempCol;
            if (temp == target){
                return true;
            }else if(temp > target){
                tempCol -= 1;
            }else {
                tempRow += 1;
            }
        }
        return false;
    }
}
