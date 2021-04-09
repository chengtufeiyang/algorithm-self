package com.self.allpractice;

public class Problem003_side_1_lagestSquare {

    public static void main(String[] args) {
//        int[][]  matrix = {
//                {1,1,0,0,1,1,1,1},
//                {1,1,0,0,1,1,1,1},
//                {0,1,1,1,1,1,1,1},
//                {0,1,0,1,1,1,1,1},
//                {0,1,1,1,0,0,0,0}
//        };


        int[][]  matrix = {
                {1,1,1,1,1,1,1,1},
                {1,1,0,0,1,1,1,1},
                {1,1,1,1,1,1,1,1},
                {1,1,0,1,1,1,1,1},
                {1,1,1,1,1,1,1,1}
        };

        System.out.println(lagestSquare(matrix));
    }


    public static int lagestSquare(int[][] matrix) {
        if (null == matrix || matrix.length == 0) return 0;

        int row = matrix.length;
        int col = matrix[0].length;
        // 获取向右最大距离数组
        // 获取向下最大距离数组
        int[][] right = new int[row][col];
        int[][] down = new int[row][col];
        initRightAndDown(matrix, right, down); // 初始化right 和down 数组

        int max = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == 1 && right[i][j] > max && down[i][j] > max) {
                    max = Math.max(max, maxSide(matrix, right, down, i, j,max));
                }
            }
        }
        return max;

    }

    private static int maxSide(int[][] matrix, int[][] right, int[][] down, int currRow, int currCol,int maxLen) {
        // 根据右侧和下侧最小值确定可能最大边长
        int possibleLen = Math.min(right[currRow][currCol],down[currRow][currCol]);

        for (int i = maxLen; i < possibleLen; i++) {
            // 原始点右侧节点的下方长度
            // 原始点下侧节点的右侧长度
            if (down[currRow][currCol + i] >= i && right[currRow + i][currCol] >= i){
                maxLen = i + 1;
            }
        }
        return maxLen;
    }

    private static void initRightAndDown(int[][] matrix, int[][] right, int[][] down) {
        int row = matrix.length;
        int col = matrix[0].length;
        // 初始化right数组 ，从最右侧开始
        for (int i = 0; i < row; i++) {
            right[i][col - 1] = matrix[i][col - 1];
        }
        for (int i = 0; i < row; i++) {
            for (int j = col - 2; j >= 0; j--) {
                right[i][j] = matrix[i][j] == 1 ? right[i][j + 1] + 1 : 0;
            }
        }


        // 初始化down数组，从最下层开始
        for (int i = 0; i < col; i++) {
            down[row - 1][i] = matrix[row - 1][i];
        }
        for (int i = row - 2; i >= 0; i--) {
            for (int j = 0; j < col; j++) {
                down[i][j] = matrix[i][j] == 1 ? down[i + 1][j] + 1 : 0;
            }
        }
    }


}
