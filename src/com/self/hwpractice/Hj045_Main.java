package com.self.hwpractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Hj045_Main {


    /**
     * 给出一个名字，该名字有26个字符组成，定义这个字符串的“漂亮度”是其所有字母“漂亮度”的总和。
     * 每个字母都有一个“漂亮度”，范围在1到26之间。没有任何两个不同字母拥有相同的“漂亮度”。字母忽略大小写。
     *
     * 给出多个名字，计算每个名字最大可能的“漂亮度”。
     *
     * 本题含有多组数据。
     *
     * 输入描述：
     * 整数N，后续N个名字
     *
     * 输出描述：
     * 每个名称可能的最大漂亮程度
     *
     * 示例1
     * 输入：
     * 2
     * zhangsan
     * lisi
     *
     * 192
     * 101
     */


    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String temp;

        while ((temp = bufferedReader.readLine() ) != null){

            int num = Integer.valueOf(temp);// 字符数量

            for (int i = 0; i < num; i++) {

                temp = bufferedReader.readLine();  // 当前字符串
                int count = 26;
                int sum = 0;

                Map<Character,Integer> map = new HashMap<>();
                PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
                    @Override
                    public int compare(Integer o1, Integer o2) {
                        return o2 - o1;
                    }
                });


                for (int i1 = 0; i1 < temp.length(); i1++) {
                   map.put(temp.charAt(i1),map.getOrDefault(temp.charAt(i1),0) + 1);
                }

                for (Integer val:map.values() ) {
                    queue.add(val);
                }

                while (!queue.isEmpty()){
                    sum += count--  * queue.poll();
                }

                System.out.println(sum);
            }

        }


    }
}
