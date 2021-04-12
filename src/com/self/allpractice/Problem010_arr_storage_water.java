package com.self.allpractice;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Problem010_arr_storage_water {

    public static void main(String[] args) {

        int len = 100;
        int value = 200;
        int testTimes = 100000;
        System.out.println("test begin");
        for (int i = 0; i < testTimes; i++) {
            int[] arr = generateRandomArray(len, value);
            int ans1 = water1(arr);
            int ans2 = maxWaterForOne(arr);
            if (ans1 != ans2 ) {
                System.out.println("Oops!");
            }
        }
        System.out.println("test finish");
    }

    /**
     * 一维数字蓄水问题
     * @param arr
     * @return
     */
    public static int maxWaterForOne(int[] arr){
        if (null == arr || arr.length < 3) return 0;

        int len = arr.length;
        int leftMax = arr[0]; // 左侧屏障
        int rightMax = arr[len - 1]; // 右侧屏障

        int leftIndex = 1;  // 左侧初始化判断位置
        int rightIndex = len - 2; // 右侧初始化判断位置
        int max = 0;
        while (leftIndex <= rightIndex){

            if (leftMax <= rightMax){ // 左侧屏障较小
//                if (arr[leftIndex] >= leftMax){
//                    leftMax = arr[leftIndex];
//                }else {
//                    max += leftMax - arr[leftIndex];
//                }
//                leftIndex++;
                leftMax = Math.max(arr[leftIndex],leftMax);
                max += Math.max(0,leftMax - arr[leftIndex++]);
            }else { // 右侧屏障较小
//                if (arr[rightIndex] >= rightMax){
//                    rightMax = arr[rightIndex];
//                }else {
//                    max += rightMax - arr[rightIndex];
//                }
//                rightIndex--;
                rightMax = Math.max(rightMax,arr[rightIndex]);
                max += Math.max(0,rightMax - arr[rightIndex--]);
            }
        }
        return max;
    }

    public static int water1(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }
        int N = arr.length;
        int water = 0;
        for (int i = 1; i < N - 1; i++) {
            int leftMax = Integer.MIN_VALUE;
            for (int j = 0; j < i; j++) {
                leftMax = Math.max(leftMax, arr[j]);
            }
            int rightMax = Integer.MIN_VALUE;
            for (int j = i + 1; j < N; j++) {
                rightMax = Math.max(rightMax, arr[j]);
            }
            water += Math.max(Math.min(leftMax, rightMax) - arr[i], 0);
        }
        return water;
    }

    public static int[] generateRandomArray(int len, int value) {
        int[] ans = new int[(int) (Math.random() * len) + 1];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = (int) (Math.random() * value) + 1;
        }
        return ans;
    }


    private static class MaxWaterForTwoClass{

        private int row;
        private int col;
        private int value;

        public MaxWaterForTwoClass(int row, int col, int value) {
            this.row = row;
            this.col = col;
            this.value = value;
        }
    }

    private static class MyCompare implements Comparator<MaxWaterForTwoClass>{

        @Override
        public int compare(MaxWaterForTwoClass o1, MaxWaterForTwoClass o2) {
            return o1.value - o2.value;// 从小到达顺序
        }
    }

    /**
     * 二维数组蓄水问题
     * @param arr
     * @return
     */
    public static int maxWaterForTwo(int[][] arr){
        if (null == arr || arr.length <3 || arr[0].length < 3) return 0;

        int row = arr.length;
        int col = arr[0].length;
        boolean[][] flag = new boolean[row][col];  // 标记数据是否已入队列
        //首先将外围数据存入小根堆中
        PriorityQueue<MaxWaterForTwoClass> queue = new PriorityQueue<>(new MyCompare());
        for (int i = 0; i < col; i++) { // up down
            flag[0][i] = true;
            queue.add(new MaxWaterForTwoClass(0,i,arr[0][i]));
            flag[row - 1][i] = true;
            queue.add(new MaxWaterForTwoClass(row - 1,i,arr[row - 1][i]));
        }

        for (int i = 0; i < row; i++) {  // left right
            if (!flag[i][0]){
                flag[i][0] = true;
                queue.add(new MaxWaterForTwoClass(i,0,arr[i][0]));
            }

            if (!flag[i][col - 1]){
                flag[i][col - 1] = true;
                queue.add(new MaxWaterForTwoClass(i,col - 1,arr[i][col - 1]));
            }
        }

        int max = 0;
        int limit = Integer.MIN_VALUE;
        while (!queue.isEmpty()){
            MaxWaterForTwoClass temp = queue.poll(); //瓶颈
            int tempRow = temp.row;
            int tempCol = temp.col;
            limit = Math.max(limit,temp.value);
            //对四个方向数据进行判断 赋值
            if (!flag[tempRow - 1][tempCol]){
                flag[tempRow - 1][tempCol] = true;
                max += Math.max(0,limit - arr[tempRow - 1][tempCol]);
                queue.add(new MaxWaterForTwoClass(tempRow - 1,col,arr[tempRow - 1][tempCol]));
            }

            if (!flag[tempRow + 1][tempCol]){
                flag[tempRow + 1][tempCol] = true;
                max += Math.max(0,limit - arr[tempRow + 1][tempCol]);
                queue.add(new MaxWaterForTwoClass(tempRow + 1,col,arr[tempRow + 1][tempCol]));
            }

            if (!flag[tempRow][tempCol - 1]){
                flag[tempRow][tempCol - 1] = true;
                max += Math.max(0,limit - arr[tempRow][tempCol - 1]);
                queue.add(new MaxWaterForTwoClass(tempRow ,col - 1,arr[tempRow][tempCol - 1]));
            }

            if (!flag[tempRow][tempCol + 1]){
                flag[tempRow][tempCol + 1] = true;
                max += Math.max(0,limit - arr[tempRow][tempCol + 1]);
                queue.add(new MaxWaterForTwoClass(tempRow ,col + 1,arr[tempRow][tempCol + 1]));
            }
        }
        return max;
    }


}
