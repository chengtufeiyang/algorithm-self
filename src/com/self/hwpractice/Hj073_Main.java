package com.self.hwpractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Hj073_Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String temp;
        while ((temp = bufferedReader.readLine()) != null) {
            System.out.println(getResult(temp.split(" ")));
        }
    }

    private static int getResult(String[] strs) {
        int year = Integer.valueOf(strs[0]); // 年
        int month = Integer.valueOf(strs[1]); // 月
        int day = Integer.valueOf(strs[2]); // 日


        // 判断月份，如果是1月份，直接使用天数即可
        if (month == 1) return day;
        // 如果大于1月，统计之前月份天数 + 目前天数即为结果
        // 如果含有2月，需判断是否为闰年，如果是闰年则2月为29天，如果是平年则2月是28天
        //  闰年的两条规则： 1、年份是4的倍数，但不是100的倍数。   2、年份数是400的倍数。
        for (int i = 1; i < month; i++) {

            if (i == 2){
                day += isRn(year);
            }else {
                if (i == 1 || i == 3 || i == 5 ||
                i == 7 || i == 8 || i == 10 || i == 12){
                    day += 31;
                }else {
                    day += 30;
                }
            }
        }
        return day;
    }

    /**
     * 判断是否为闰年
     * @param year
     * @return
     */
    private static int isRn(int year) {

        if ((year % 4 == 0 && year % 100 != 0) ||
         year % 400 == 0){
            return 29;
        }
        return 28;
    }
}
