package com.self.allpractice;

public class Problem008_arr_left_right_max_diff {

    public static void main(String[] args) {
        int[] arr = generateRandomArray(200);
        System.out.println(max(arr));
        System.out.println(maxABS1(arr));
    }

    /**
     * 任意排序数组中，任意分割两部分情况下，左右两侧部分中最大值差值的最大值
     * @param arr
     * @return
     */
    public static int max(int[] arr){
        if (null == arr || arr.length < 1) return 0;

        int len = arr.length;

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < len; i++) {
            max = Math.max(max,arr[i]);
        }
        return Math.max(max - arr[0],max - arr[len - 1]);
    }


    public static int maxABS1(int[] arr) {
        int res = Integer.MIN_VALUE;
        int maxLeft = 0;
        int maxRight = 0;
        for (int i = 0; i != arr.length - 1; i++) {
            maxLeft = Integer.MIN_VALUE;
            for (int j = 0; j != i + 1; j++) {
                maxLeft = Math.max(arr[j], maxLeft);
            }
            maxRight = Integer.MIN_VALUE;
            for (int j = i + 1; j != arr.length; j++) {
                maxRight = Math.max(arr[j], maxRight);
            }
            res = Math.max(Math.abs(maxLeft - maxRight), res);
        }
        return res;
    }

    public static int[] generateRandomArray(int length) {
        int[] arr = new int[length];
        for (int i = 0; i != arr.length; i++) {
            arr[i] = (int) (Math.random() * 1000) - 499;
        }
        return arr;
    }
}
