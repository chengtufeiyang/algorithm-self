package com.self.hwpractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Hj097_Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String temp;
        while ((temp = bufferedReader.readLine()) != null) {

            int num = Integer.valueOf(temp);
            int numNega = 0; // 负数数量
            double avg = 0.0; // 所有正整数的平均值
            int numAvg = 0;

            String[] strs = (bufferedReader.readLine()).split(" ");
            for (int i = 0; i < strs.length; i++) {
                int tempVal = Integer.valueOf(strs[i]);
                if (tempVal > 0 ){
                    avg += tempVal;
                    numAvg++;
                }else if (tempVal < 0){
                    numNega++;
                }
            }

            System.out.println(numNega + " " + String.format("%.1f",(avg / numAvg)));
        }
    }
}
