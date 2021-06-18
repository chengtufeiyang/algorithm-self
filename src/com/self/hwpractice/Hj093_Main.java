package com.self.hwpractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Hj093_Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String temp;
        while ((temp = bufferedReader.readLine()) != null) {

            int len = Integer.valueOf(temp);// 数组长度

            String[] strs = (bufferedReader.readLine()).split(" ");
            int[] nums = new int[len];
            for (int i = 0; i < len; i++) {
                nums[i] = Integer.valueOf(strs[i]);
            }
            System.out.println(isEquels(nums,0,0,0,len));

        }
    }

    private static boolean isEquels(int[] nums, int curr, int left, int right, int len) {

        if (curr == len) return left == right;

        // 判断当前数值3  还是5
        if (nums[curr] % 3 == 0){
            return isEquels(nums,curr + 1,left + nums[curr],right,len);
        }else if (nums[curr] % 5 == 0){
            return isEquels(nums,curr + 1,left,right + nums[curr],len);
        }else {
            return isEquels(nums,curr + 1,left + nums[curr],right,len)
                    || isEquels(nums,curr + 1,left,right + nums[curr],len);
        }
    }
}
