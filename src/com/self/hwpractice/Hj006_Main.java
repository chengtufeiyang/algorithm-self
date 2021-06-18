package com.self.hwpractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Hj006_Main {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String temp ;

        while ((temp = bufferedReader.readLine()) != null){
            StringBuilder sb = new StringBuilder();
            int tempI = Integer.valueOf(temp);

            int num = 2;

            while (num <= Math.sqrt(tempI)){

                if (tempI % num == 0){
                    sb.append(num).append(" ");
                    tempI = tempI / num;
                }else {
                    num++;
                }
            }
            sb.append(tempI).append(" ");

//            while (tempI > 1){
//                if (tempI % num == 0){
//                    sb.append(num).append(" ");
//                    tempI = tempI / num;
//                }else {
//                    num++;
//                }
//            }
            System.out.println(sb);
        }

    }
}
