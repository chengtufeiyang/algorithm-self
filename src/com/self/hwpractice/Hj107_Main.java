package com.self.hwpractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Hj107_Main {


    //  牛顿迭代法
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String temp ;

        while ((temp = bufferedReader.readLine() ) != null){

            double d = Double.parseDouble(temp);
            getCube(d);
        }

    }


    public static void getSqr(double num){
        double x = 1;
        double x1 = x - (Math.pow(x,2) - num) / (2 * x);

        while (Math.abs(x - x1) > 0.01){
            x = x1;
            x1 = x - (Math.pow(x,2) - num) / (2 * x);
        }

//        System.out.println(x1);
        System.out.println(String.format("%.1f",x1));

    }

    public static void getCube(double num){
        double x = 1;
        double x1 = x - (Math.pow(x,3) - num) / (Math.pow(x,2) * 3);

        while (Math.abs(x - x1) > 0.01){
            x = x1;
            x1 = x - (Math.pow(x,3) - num) / (Math.pow(x,2) * 3);
        }
//        System.out.println(x1);
        System.out.println(String.format("%.1f",x1));
    }

}
