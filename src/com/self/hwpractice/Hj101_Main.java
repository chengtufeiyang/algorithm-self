package com.self.hwpractice;

import java.io.BufferedReader;
import java.io.IOException;

import java.io.InputStreamReader;
import java.util.Arrays;

public class Hj101_Main {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String temp;

        while ((temp = bufferedReader.readLine()) != null){

            int len = Integer.valueOf(temp);
            int[] nums = new int[len];

            nums = getArray(bufferedReader.readLine(),nums);
            Arrays.sort(nums);

            temp = bufferedReader.readLine();
            if ("0".equals(temp)){ // 升序
                for (int i = 0; i < len; i++) {
                    System.out.print(nums[i] + " ");
                }
            }else {// 逆序
                for (int i = len - 1; i >= 0; i--) {
                    System.out.print(nums[i] + " ");
                }
            }
            System.out.println();

        }

    }

    private static int[] getArray(String readLine, int[] nums) {

        String[] strs = readLine.split(" ");

        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.valueOf(strs[i]);
        }

        return nums;
    }
}
