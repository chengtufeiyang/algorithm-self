package com.self.hwpractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Hj053_Main {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String temp;
        while ((temp = bufferedReader.readLine()) != null) {
            int line = Integer.valueOf(temp);

            if (line == 1 || line == 2){
                System.out.println(-1);
            }else {

                double[][] nums = new double[2][1 + 2 * (line - 1)];


                int curr = 3;// 第几行数据
                int val_ck = 0;// 参考第0行
                int cen_index = (1 + 2 * (line - 1)) / 2; //永远的中心的坐标

                nums[0][cen_index - 1] = 1;
                nums[0][cen_index] = 1;
                nums[0][cen_index + 1] = 1;

                while (curr <= line){
                    int num = 1 + 2 * (curr  - 1); // 当前待赋值行数据量

                    int start = cen_index - num / 2; //开始坐标位置


                    if (val_ck == 0){ // 参考第0行，赋值第一行

                        for (int i = start; i < (start + num); i++) {
                            nums[1][i] = getVal(nums[0],i - 1,i, i + 1);
                        }

                    }else { // 参考第1行赋值第0行

                        for (int i = start; i < (start + num); i++) {
                            nums[0][i] = getVal(nums[1],i - 1,i ,i + 1);
                        }
                    }
//                    System.out.println("第"+curr + "行：" + Arrays.toString(nums[val_ck ^ 1]));
                    curr++;// 下一行数据
                    val_ck ^= 1;
                }

                int count = 0;
                for (int i = 0; i < nums[val_ck].length; i++) {
                    if (nums[val_ck][i] % 2 == 0){
                        count = i;
                        break;
                    }
                }
                System.out.println(count == 0 ? -1 : count + 1);
            }
        }
    }

    private static double getVal(double[] num, int left, int curr, int right) {

        int result = 0;

        if (left >= 0 && left < num.length){
            result += num[left];
        }

        if (curr >= 0 && curr < num.length){
            result += num[curr];
        }

        if (right >= 0 && right < num.length){
            result += num[right];
        }

        return result;
    }
}
