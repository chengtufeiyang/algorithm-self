package com.self.hwpractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Hj085_Main {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String temp;
        while ((temp = bufferedReader.readLine()) != null) {
            System.out.println(getResultMid(temp));
            System.out.println(getResultManacher(temp));
        }
    }

    /**
     * 中心扩展法
     * @param str
     * @return
     */
    private static int getResultMid(String str) {
        if (str.length() == 1) return 1;

        StringBuilder sb = new StringBuilder("#");
        for (int i = 0; i < str.length(); i++) {
            sb.append(str.charAt(i)).append("#");
        }
        String newStr = sb.toString();  // 新的字符串
        int max = 1;
        for (int i = 2; i < newStr.length(); i++) { // 当前中心坐标
            int left = i - 1;
            int right = i + 1;
            while (left >= 0 && right < newStr.length()){
                if (newStr.charAt(left) == newStr.charAt(right)){
                    left--;
                    right++;
                }else {
                    break;
                }
            }
            max = Math.max(max,(right - left - 2) / 2);
        }
        return max;
    }


    private static int getResultManacher(String str) {
        if (str.length() == 1) return 1;
        StringBuilder sb = new StringBuilder("#");
        for (int i = 0; i < str.length(); i++) {
            sb.append(str.charAt(i)).append("#");
        }
        String newStr = sb.toString();
        int[] hw = new int[newStr.length()];// 回文半径数组
        int result = 1; //最终结果
        int R = -1; //记录之前最大右边界
        int index_R = -1; //记录之前最大右边界中心点位置



        for (int i = 0; i < newStr.length(); i++) {

            if (i > R){ // 直接暴力解法
                int left = i - 1;
                int right = i + 1;
                while (left >= 0 && right < newStr.length()
                && newStr.charAt(left) == newStr.charAt(right) ){
                    left--;
                    right++;
                }
                if ((right - i) > R){
                    index_R = i;
                    R = right - 1;
                }
                hw[i] = right - i;  //设置当前判断位置的回文半径

            }else { // 根据对称点回文串范围，使用不同方式应对

                int pre_i = 2 * index_R - i; // 找到对称点位置坐标
                int pre_i_r = hw[pre_i]; // 获取对称点回文半径
                int large = i + pre_i_r - 1; //根据对称关系，获取最大可能外扩位置

                if (large < R){ // 内部
                    hw[i] = hw[pre_i];//直接使用旧记录即可
                }else if (large == R){ // 刚好相等
                    int left = 2 * i - R - 1;
                    int right = R + 1;
                    while (left >= 0 && right < newStr.length()
                            && newStr.charAt(left) == newStr.charAt(right) ){

                        left--;
                        right++;
                    }
                    if ((right - i) > R){
                        index_R = i;
                        R = right - 1;
                    }
                    hw[i] = right - i;  //设置当前判断位置的回文半径

                }else { // 扩展出去
                    hw[i] = R - i + 1;
                }
            }
            result = Math.max(result,hw[i] - 1);
        }

        return result;
    }
}
