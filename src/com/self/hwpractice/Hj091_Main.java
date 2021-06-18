package com.self.hwpractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Hj091_Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String temp;
        while ((temp = bufferedReader.readLine()) != null) {

            String[] strs = temp.split(" ");
            System.out.println(getNum(0,0,Integer.valueOf(strs[0]) ,Integer.valueOf(strs[1])));

        }
    }

    private static int getNum(int currX, int currY, int maxX, int maxY) {

        if (currX == maxX && currY == maxY) return 1;

        //  当前位置
        if (currX < maxX && currY < maxY){
            return getNum(currX + 1,currY,maxX,maxY) +
                    getNum(currX,currY + 1,maxX,maxY);
        }else if (currX < maxX && currY == maxY){
            return getNum(currX + 1,currY,maxX,maxY) ;
        }else {
            return getNum(currX,currY + 1,maxX,maxY) ;
        }
    }
}
