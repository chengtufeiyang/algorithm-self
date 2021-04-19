package com.self.comm.sort;

import com.wz.array.ArraysSelf;
import com.wz.array.GenerateArray;
import com.wz.array.SwapArray;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {

        for (int i = 0; i < 100000; i++) {
            int[] num = GenerateArray.generateRandomArray(60,100);
//        int[] num = {-75, -3, -79};
            quickSort3(num);
//            System.out.println("pre-----------------"+Arrays.toString(num));
            if (!ArraysSelf.isOrderAsc(num)){
                System.out.println("error");
                System.out.println("after-----------------"+Arrays.toString(num));
                break;
            }
        }

//        for (int i = 0; i < 100000; i++) {
//            System.out.println((int) (Math.random() * 20));
//        }
    }


    /**
     * 选取最右侧值进行比较
     * @param arr
     */
    public static void quickSort2(int[] arr){
        if (null == arr || arr.length == 0 )return;
        dutchFlag2(arr,0,arr.length - 1);
    }

    private static void dutchFlag2(int[] arr, int left, int right) {
        if (left >= right) return;

        int curr = arr[right];
        int currLeft = left; // 当前情况 < curr 数值范围外第一个数位置
        int currRight = right; // 当前情况 > curr 数值范围外第一个数位置
        int move = left; // 从左侧小于范围外第一个数开始循环查找
        while (move <= currRight){
            if (arr[move] == curr){
                move++;
            }else if(arr[move] > curr){
                SwapArray.swap(arr,move,currRight--);
            }else {
                SwapArray.swap(arr,currLeft++,move++);
            }
        }
        dutchFlag2(arr,left,currLeft - 1);
        dutchFlag2(arr,currRight + 1,right);
    }

    /**
     * 选取随机数进行比较
     * @param arr
     */
    public static void quickSort3(int[] arr){
        if (null == arr || arr.length == 0 )return;
        dutchFlag3(arr,0,arr.length - 1);
    }

    private static void dutchFlag3(int[] arr, int left, int right) {
        if (left >= right) return;

        int temp = left + (int)(Math.random() * ( right - left));
//        System.out.println("temp=-------"+temp);
//        System.out.println(String.format("%d,%d",left,right));
        int curr = arr[temp]; // 随机数选取标准值

        int currLeft = left;
        int currRight = right;
        int move = left;
        while (move <= currRight){
            if (arr[move] == curr){
                move++;
            }else if (arr[move] > curr){
                SwapArray.swap(arr,move,currRight--);
            }else {
                SwapArray.swap(arr,move++,currLeft++);
            }
        }

        dutchFlag3(arr,left,currLeft - 1);
        dutchFlag3(arr,currRight + 1, right);
    }


}
