package com.self.hwpractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Hj103_Main {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String temp ;

        while ((temp = bufferedReader.readLine()) != null){


            System.out.println(logNum(Integer.valueOf(temp),bufferedReader.readLine()));

        }

    }

    private static int logNum(int len, String str) {

        int[] dp = new int[len];
        Arrays.fill(dp,1);
        int[] nums = new int[len];
        String[] strs = str.split(" ");
        for (int i = 0; i < len; i++) {
            nums[i] = Integer.valueOf(strs[i]);
        }

        int count = 1;
        for (int i = 1; i < len; i++) {


            for (int j = 0; j < i; j++) {

                dp[i] = nums[i] > nums[j] ?  Math.max(dp[i], dp[j] + 1) : dp[i];
            }
            count = Math.max(count,dp[i]);
        }

        return count;
    }
}
