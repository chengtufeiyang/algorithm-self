package com.self.practice.c03_dp;

public class P00_fibonacci_sque {

    public static void main(String[] args) {
        long time = System.currentTimeMillis();
        System.out.println(fibonacciRecusion(40));
        long end1 = System.currentTimeMillis();
        System.out.println("time:  "+(end1 - time));

        System.out.println(fibonacciDp(40));
        System.out.println("time:  "+(System.currentTimeMillis() - end1));
    }

    /**
     * 递归
     * @param n
     * @return
     */
    public static int fibonacciRecusion(int n){
        if (n==1) return 1;
        if (n==2) return 1;

        return fibonacciRecusion(n-1) + fibonacciRecusion(n -2);
    }

    public static int fibonacciDp(int n){
        if (n==1) return 1;
        if (n==2) return 1;

        int[] arr = new int[n+1];
        arr[1] = arr[2] = 1;
        for (int i = 3; i < arr.length; i++) {
            arr[i] = arr[i-1] + arr[i-2];
        }
        return arr[n];
    }


}
