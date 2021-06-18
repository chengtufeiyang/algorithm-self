package com.self.hwpractice;

import java.io.IOException;
import java.util.Scanner;

public class Hj018_Main {


    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);
        int[] count = {0, 0, 0, 0, 0, 0, 0};  //个数数组
        while (scanner.hasNext()) {
            String temp = scanner.nextLine();
            String[] strs = temp.split("~");  //  分为ip 和子网掩码两种情况
            String[] ip = strs[0].split("\\.");
            String[] sub = strs[1].split("\\.");


            Boolean flag = true;  //判断ip  子网掩码是否正确
            if (ip[0].equals("0") || ip[0].equals("127")) {
                continue;
            }

            flag = ipSubValid(ip, sub);

            if (flag) { // 如果IP正确，判断掩码是否正确
                int first = Integer.valueOf(ip[0]);
                int sec = Integer.valueOf(ip[1]);
                judgeIP(first, sec,count);

            } else { // 如果ip 子网掩码不正确
                count[5]++;
            }
        }
        System.out.println(count[0] + " " + count[1] + " " + count[2] + " " + count[3] + " " + count[4] + " "
                + count[5] + " " + count[6]);
    }

    private static void judgeIP(int first, int sec,int[] count) {

        if (first >= 1 && first <= 126){
            count[0]++;
        }else if (first >= 128 && first <= 191){
            count[1]++;
        }else if (first >= 192 && first <= 223){
            count[2]++;
        }else if (first >= 224 && first <= 239){
            count[3]++;
        }else if (first >= 240 && first <= 255){
            count[4]++;
        }


        if (first == 192 && sec == 168){
            count[6]++;
        }
        if (first == 172 && sec >= 16 && sec <= 31){
            count[6]++;
        }
        if (first == 10){
            count[6]++;
        }

    }

    /**
     * 判断ip或者子网掩码是否合法
     * @param ip
     * @param sub
     * @return
     */
    public static boolean ipSubValid(String[] ip,String[] sub) {

        if (ip.length != 4 || sub.length != 4
        ) return false;

        for (int i = 0; i < ip.length; i++) {

            if (ip[i].equals("") || ip[i].length() <= 0){
                return false;
            }
        }


        long num = 0;

        for (int i = 0; i < sub.length; i++) {

            num = (num << 8) + Integer.valueOf(sub[i]);

        }

        String temp = Long.toBinaryString(num);
        if (temp.length() < 32) return false;

        int zero = temp.indexOf("0");
        int one = temp.lastIndexOf("1");

        if (zero < 0 || one < 0) return false;
        if (zero < one) return false;
        return true;

    }

}
