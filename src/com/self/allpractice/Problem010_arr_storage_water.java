package com.self.allpractice;

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
}
