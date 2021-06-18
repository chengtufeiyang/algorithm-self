package com.self.hwpractice;

import edu.princeton.cs.algs4.In;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        String str = "192.168.0.2~255.254.255.0";
        String[] strs = str.split("~");

        String[] ip = strs[0].split("\\.");
        String[] sub = strs[1].split("\\.");

        System.out.println(Hj018_Main.ipSubValid(ip,sub));

        String st = "255.254.255.0";
        String[] sts = st.split("\\.");
        for (int i = 0; i < sts.length; i++) {
            System.out.println(Integer.toBinaryString(Integer.parseInt(sts[i])));
        }


    }

}
