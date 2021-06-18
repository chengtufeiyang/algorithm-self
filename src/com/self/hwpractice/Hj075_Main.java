package com.self.hwpractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Hj075_Main {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String temp;
        while ((temp = bufferedReader.readLine()) != null) {

            String str2 = bufferedReader.readLine();
            System.out.println(getResultNor(temp, str2));
            System.out.println(getResultAarray(temp, str2));
        }

    }

    /**
     * 普通暴力方式
     *
     * @param str1
     * @param str2
     * @return
     */
    private static int getResultNor(String str1, String str2) {

        String lstr = str1.length() > str2.length() ? str1 : str2;
        String sstr = str1.length() > str2.length() ? str2 : str1;

        int len = sstr.length();

        int max = 0;
        for (int i = 0; i < len; i++) {

            for (int j = i + 1; j <= len; j++) {
                if (lstr.contains(sstr.substring(i, j))) {
                    max = Math.max(max,j - i);
                }else {
                    break;
                }
            }
        }
        return max;
    }


    private static int getResultAarray(String str1 ,String str2){

        int m = str1.length();
        int n = str2.length();

        char[] str1s = str1.toCharArray();
        char[] str2s = str2.toCharArray();

        int[][] dp = new int[m][n];
        int max = 0;
        // 第一排
        for (int i = 0; i < n; i++) {

            if (str1s[0] == str2s[i]){
                dp[0][i] = 1;
                max = 1;
            }
        }

        // 第一列
        for (int i = 0; i < m; i++) {

            if (str1s[i] == str2s[0]){
                dp[i][0] = 1;
                max = 1;
            }
        }

        for (int i = 1; i < n; i++) {

            for (int j = 1; j < m; j++) {

                if (str2s[i] == str1s[j]){
                    dp[j][i] = dp[j - 1][i - 1] + 1;
                    max = Math.max(dp[j][i],max);
                }
            }
        }
        return max;
    }


}
