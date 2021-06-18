package com.self.hwpractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Hj105_Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String temp;

        int notNum = 0;
        double num = 0;
        int numNum = 0;


        while ((temp = bufferedReader.readLine()) != null){

            Double tempInt = Double.parseDouble(temp);
            if (tempInt > 0 ){
                num += tempInt;
                numNum++;
            }else if(tempInt < 0){
                notNum++;
            }
        }

        System.out.println(notNum);
        System.out.println((String.format("%.1f",(numNum > 0 ? num / numNum : 0))));
    }
}
